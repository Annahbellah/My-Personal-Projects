package com.example.fashionblogapi.services;

import com.example.fashionblogapi.pojos.LoginPojo;
import com.example.fashionblogapi.pojos.RegistrationPojo;
import com.example.fashionblogapi.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public interface UserService {
    String createUser(RegistrationPojo newUser);

    ResponseEntity<User> login(LoginPojo loginPojo);
}
