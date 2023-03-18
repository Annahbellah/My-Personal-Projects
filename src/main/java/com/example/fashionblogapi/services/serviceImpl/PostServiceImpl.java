package com.example.fashionblogapi.services.serviceImpl;

import com.example.fashionblogapi.enums.Roles;
import com.example.fashionblogapi.exceptions.UserNotFoundException;
import com.example.fashionblogapi.pojos.PostPojo;
import com.example.fashionblogapi.entities.Like;
import com.example.fashionblogapi.entities.Post;
import com.example.fashionblogapi.entities.User;
import com.example.fashionblogapi.exceptions.CustomRequestException;
import com.example.fashionblogapi.repositories.LikeRepository;
import com.example.fashionblogapi.repositories.PostRepository;
import com.example.fashionblogapi.repositories.UserRepository;
import com.example.fashionblogapi.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final LikeRepository likeRepository;
    private final UserRepository userRepository;



    @Override
    public ResponseEntity<List<PostPojo>> fetchAllPosts() {
        List<Post> allPosts = postRepository.findAll();
        List<PostPojo> allPostPojo = new ArrayList<>();
                allPosts.stream()
                .forEach(post -> { PostPojo postPojo = new PostPojo();
                   BeanUtils.copyProperties(post, postPojo);
                   allPostPojo.add(postPojo);
                });



        return new ResponseEntity<>(allPostPojo, HttpStatus.OK);
    }

    @Override
    public PostPojo createPost(PostPojo postPojo) {
        User user = userRepository.findById(postPojo.getUserId())
                .orElseThrow(() -> new UserNotFoundException("user is invalid"));
        if (user.getRole().equals(Roles.ADMIN)) {

            Post newPost = new Post();
            newPost.setPostTitle(postPojo.getPostTitle());
            newPost.setBody(postPojo.getBody());
            newPost.setPostCreator(user);
            Post savePost = postRepository.save(newPost);
            PostPojo postPojo1 = new PostPojo();
            BeanUtils.copyProperties(savePost, postPojo1);
            return postPojo1;

        }
        else throw new CustomRequestException("Only admins can create a post!");

    }

    @Override
    public ResponseEntity<PostPojo> fetchSinglePost(String postTitle) {
        Post post = postRepository.findByPostTitle(postTitle);
        PostPojo postPojo = new PostPojo();
        BeanUtils.copyProperties(post, postPojo);

        return new ResponseEntity<>(postPojo, HttpStatus.FOUND);

    }


    @Override
    public void likePost(final Long postId, final Long userId) {
        Like like= Like.builder()
                .postId(postId)
                .userId(userId).build();
       likeRepository.save(like);
    }

    @Override
    public ResponseEntity<String> deletePost(Long id) {
        boolean ifPostExists = postRepository.existsById(id);
        if(!ifPostExists){
            throw new CustomRequestException("This post does not exist");
        }
        postRepository.deleteById(id);

    return new ResponseEntity<>("post deleted",HttpStatus.OK);
    }

    @Override
    public void dislikePost(Long postId, Long userId) {
        Like like = likeRepository.findLikeByPostIdAndUserId(postId,userId);
        likeRepository.delete(like);
    }
}
