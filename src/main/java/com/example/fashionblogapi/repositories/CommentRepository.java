package com.example.fashionblogapi.repositories;

import com.example.fashionblogapi.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
