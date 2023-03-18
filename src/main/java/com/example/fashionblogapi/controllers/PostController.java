package com.example.fashionblogapi.controllers;

import com.example.fashionblogapi.pojos.LikePojo;
import com.example.fashionblogapi.pojos.PostPojo;
import com.example.fashionblogapi.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/post")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/create-post")
    public ResponseEntity<PostPojo> createPost(@RequestBody PostPojo postPojo) {
        return new ResponseEntity<>(postService.createPost(postPojo), HttpStatus.CREATED);
    }

    @GetMapping("/fetch-posts")
    public ResponseEntity<List<PostPojo>> fetchAllPosts(){
        return postService.fetchAllPosts();
    }

    @DeleteMapping("/delete-post/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable Long postId){
        return postService.deletePost(postId);
    }


    @GetMapping("/get-a-post")
    public ResponseEntity<?> getAPost(@RequestParam(name = "postTitle") String postTitle){
        return ResponseEntity.ok(postService.fetchSinglePost(postTitle));
    }

    @DeleteMapping("/dislike-post")
    public ResponseEntity<?> dislikePost(@RequestBody LikePojo likePojo) {
        postService.likePost(likePojo.getPostId(),likePojo.getUserId());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/like-post")
    public ResponseEntity<?> likePost (@RequestBody LikePojo likePojo) {
        postService.likePost(likePojo.getPostId(),likePojo.getUserId());
        return ResponseEntity.ok().build();
    }
}


