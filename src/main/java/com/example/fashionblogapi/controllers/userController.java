package com.example.fashionblogapi.controllers;

import com.example.fashionblogapi.entities.Post;
import com.example.fashionblogapi.pojos.LikePojo;
import com.example.fashionblogapi.pojos.PostPojo;
import com.example.fashionblogapi.pojos.RegistrationPojo;
import com.example.fashionblogapi.entities.User;
import com.example.fashionblogapi.pojos.UserPojo;
import com.example.fashionblogapi.services.PostService;
import com.example.fashionblogapi.services.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class userController {
    private final UserService userService;
    private final PostService postService;

    @PostMapping("/signup")
    public ResponseEntity<String> createUser(@RequestBody RegistrationPojo registrationPojo) {
        return ResponseEntity.ok(userService.createUser(registrationPojo));
    }

    @PostMapping("/login")
    public ResponseEntity<UserPojo> login(@RequestBody UserPojo userPojo) {
        UserPojo response = userService.login(userPojo);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/")
    public List<User> getUser() {
        return Collections.emptyList();
    }








}
