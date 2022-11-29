package com.example.fashionblogapi.repositories;

import com.example.fashionblogapi.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
//    Post fetchAllPosts();
    Post findByPostTitle(String postTitle);
//    void deleteById(Long id);
}
