package com.example.fashionblogapi.controllers;

import com.example.fashionblogapi.pojos.CommentCreationPojo;
import com.example.fashionblogapi.pojos.CommentPojo;
import com.example.fashionblogapi.services.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/create-comment")
    public ResponseEntity<CommentPojo> createComment(@RequestBody CommentCreationPojo commentPojo) {
        System.out.println("inside the controller");
        return ResponseEntity.ok(commentService.createNewComment(commentPojo));
    }

    @PutMapping("/edit-Comment/")
    public ResponseEntity<CommentPojo> editComments(@RequestBody CommentPojo commentPojo) {
        return ResponseEntity.ok(commentService.editComment(commentPojo));
    }
}
