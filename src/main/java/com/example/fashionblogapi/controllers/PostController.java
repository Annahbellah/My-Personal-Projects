package com.example.fashionblogapi.controllers;

import com.example.fashionblogapi.pojos.PostPojo;
import com.example.fashionblogapi.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api/v1/post")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/posts")
    public ResponseEntity<PostPojo> createPost(@RequestBody PostPojo postPojo) {
        return postService.createPost(postPojo);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostPojo>> fetchAllPosts(){
        return postService.fetchAllPosts();
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable Long postId){
        return postService.deletePost(postId);
    }
}


