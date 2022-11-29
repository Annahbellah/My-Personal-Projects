package com.example.fashionblogapi.services;

import com.example.fashionblogapi.pojos.CommentPojo;
import com.example.fashionblogapi.pojos.PostPojo;
import com.example.fashionblogapi.entities.Comment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CommentService {
    ResponseEntity<CommentPojo>  createNewComment(long userId, long postId, CommentPojo commentPojo);
    ResponseEntity<Comment> editComment(Long userId, PostPojo postPojo, Long CommentId);
    ResponseEntity<List<CommentPojo>> getAllComments();
    ResponseEntity<String> deleteComment(Long id);

    String createComment(CommentPojo commentPojo);

}


