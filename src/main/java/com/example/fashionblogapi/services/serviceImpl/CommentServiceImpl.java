package com.example.fashionblogapi.services.serviceImpl;

import com.example.fashionblogapi.pojos.CommentCreationPojo;
import com.example.fashionblogapi.pojos.CommentPojo;
import com.example.fashionblogapi.pojos.PostPojo;
import com.example.fashionblogapi.entities.Comment;
import com.example.fashionblogapi.entities.Post;
import com.example.fashionblogapi.entities.User;
import com.example.fashionblogapi.exceptions.CustomRequestException;
import com.example.fashionblogapi.repositories.CommentRepository;
import com.example.fashionblogapi.repositories.PostRepository;
import com.example.fashionblogapi.repositories.UserRepository;
import com.example.fashionblogapi.services.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;


    @Override
    public CommentPojo createNewComment(CommentCreationPojo commentPojo) {
        System.out.println("creation method called");
        Comment comment = new Comment();
        Post post = postRepository.findById(commentPojo.getPostId())
                .orElseThrow(() -> new CustomRequestException("Post not found"));

        User author=userRepository.findById(commentPojo.getCommentAuthorId())
                .orElseThrow(() -> new CustomRequestException("Author not found"));

        comment.setCommentBody(commentPojo.getCommentBody());
        comment.setPost(post);
        comment.setCommentAuthor(author);

        System.out.println(author);
        System.out.println(post);

        Comment saveComment = commentRepository.save(comment);
        CommentPojo commentPojo1 = new CommentPojo();
        System.out.println(saveComment);
        BeanUtils.copyProperties(saveComment, commentPojo1);

        return commentPojo1;

    }

    @Override
    public CommentPojo editComment(CommentPojo commentPojo) {
        Comment comment = commentRepository.findById(commentPojo.getCommentId())
                .orElseThrow(() -> new CustomRequestException("Comment not found"));
        if (comment.getCommentAuthor().getUserId() == commentPojo.getUserId()) {
            comment.setCommentBody(commentPojo.getCommentBody());
            commentRepository.save(comment);
        } else {
            throw new CustomRequestException("comment edit failed!");
        }
        return commentPojo;
    }

    @Override
    public ResponseEntity<List<CommentPojo>> getAllComments() {
        List<Comment> allComments = commentRepository.findAll();
        List<CommentPojo> allCommentPojo = new ArrayList<>();
        allComments.stream()
                .forEach(comment -> {
                    CommentPojo commentPojo2 = new CommentPojo();
                    BeanUtils.copyProperties(comment, commentPojo2);
                    allCommentPojo.add(commentPojo2);
                });



        return new ResponseEntity<>(allCommentPojo, HttpStatus.OK);


    }


    @Override
    public ResponseEntity<String> deleteComment(Long id) {
          boolean ifCommentExists = commentRepository.existsById(id);
          if(!ifCommentExists){
                throw new CustomRequestException("This comment does not exist");
        }
           commentRepository.deleteById(id);

         return new ResponseEntity<>("post deleted", HttpStatus.OK);
    }


}
