package com.example.fashionblogapi.services;

import com.example.fashionblogapi.pojos.PostPojo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
   PostPojo createPost(PostPojo postPojo);

   ResponseEntity<PostPojo> fetchSinglePost(String postTitle);

   ResponseEntity<List<PostPojo>> fetchAllPosts();

   void likePost(Long postId, Long userId);

   ResponseEntity<String> deletePost(Long id);

   void dislikePost(Long postId, Long userId);
}
