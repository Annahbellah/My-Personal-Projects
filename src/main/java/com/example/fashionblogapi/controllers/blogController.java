package com.example.fashionblogapi.controllers;

import com.example.fashionblogapi.pojos.LoginPojo;
import com.example.fashionblogapi.pojos.RegistrationPojo;
import com.example.fashionblogapi.entities.User;
import com.example.fashionblogapi.services.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@AllArgsConstructor
//@RequestMapping("/Api/v1/blog")
public class blogController {
    private final UserService userService;
   // private final PostService postService;

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody RegistrationPojo registrationPojo) {
        return ResponseEntity.ok(userService.createUser(registrationPojo));
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginPojo loginPojo, HttpSession session) {
        ResponseEntity<User> response = userService.login(loginPojo);
        session.setAttribute("user", response.getBody());
        return response;
    }

    @GetMapping("/users")
    public List<User> getUser() {
        return Collections.emptyList();
    }





//    @PostMapping("/users/{postId}{userId}/likes")
//    public ResponseEntity<?> likePost(@PathVariable(name = "postId") Long postId,
//                                      @PathVariable(name = "userId") Long userId) {
//        postService.likePost(postId,userId);
//        return ResponseEntity.ok().build();
//    }
//
//    @DeleteMapping("/users/{postId}{userId}/likes")
//    public ResponseEntity<?> dislikePost(@PathVariable(name = "postId") Long postId,
//                                      @PathVariable(name = "userId") Long userId) {
//        postService.likePost(postId,userId);
//        return ResponseEntity.ok().build();
//    }

//    @GetMapping("/posts")
//    public List<Post> getPost(){
//        return postService.fetchAllPosts();
//    }

//    @GetMapping("/users/{postId}{userId}/likes")
//    public ResponseEntity<Post> getPost(@PathVariable(name = "postId") Long postId ){
//        return ResponseEntity.ok(postService.fetchSinglePost(postId));
//    }

//    @GetMapping("/posts/{postId}{userId}/likes")
//    public ResponseEntity<Post> getPost(@PathVariable(name = "postTitle") String postTitle ){
//        return ResponseEntity.ok(postService.fetchSinglePost(postTitle));
//    }


}
