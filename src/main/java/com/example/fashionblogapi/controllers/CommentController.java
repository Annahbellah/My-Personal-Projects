package com.example.fashionblogapi.controllers;

import com.example.fashionblogapi.pojos.CommentPojo;
import com.example.fashionblogapi.services.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Api/v1/comment")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("//Api/v1/comments")
    public ResponseEntity<String> createComment(@RequestBody CommentPojo commentPojo) {
        return ResponseEntity.ok(commentService.createComment(commentPojo));
    }

    @PutMapping("/editComment{cid}")
    public ResponseEntity<String> deleteComment(@RequestBody CommentPojo commentPojo) {
        return ResponseEntity.ok(commentService.createComment(commentPojo));
    }
}
