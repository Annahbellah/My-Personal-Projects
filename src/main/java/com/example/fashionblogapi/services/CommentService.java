package com.example.fashionblogapi.services;

import com.example.fashionblogapi.pojos.CommentCreationPojo;
import com.example.fashionblogapi.pojos.CommentPojo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CommentService {
    CommentPojo  createNewComment(CommentCreationPojo commentPojo);
    CommentPojo editComment(CommentPojo commentPojo);
    ResponseEntity<List<CommentPojo>> getAllComments();
    ResponseEntity<String> deleteComment(Long id);


}


