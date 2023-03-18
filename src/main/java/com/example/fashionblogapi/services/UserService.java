package com.example.fashionblogapi.services;

import com.example.fashionblogapi.pojos.RegistrationPojo;
import com.example.fashionblogapi.pojos.UserPojo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public interface UserService {
    String createUser(RegistrationPojo registrationPojo);

    UserPojo login(UserPojo userPojo);
}
