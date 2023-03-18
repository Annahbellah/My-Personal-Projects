package com.example.fashionblogapi.services.serviceImpl;

import com.example.fashionblogapi.enums.Roles;
import com.example.fashionblogapi.exceptions.CustomException;
import com.example.fashionblogapi.exceptions.CustomRequestException;
import com.example.fashionblogapi.exceptions.UserNotFoundException;
import com.example.fashionblogapi.pojos.RegistrationPojo;
import com.example.fashionblogapi.entities.User;
import com.example.fashionblogapi.pojos.UserPojo;
import com.example.fashionblogapi.repositories.UserRepository;
import com.example.fashionblogapi.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Optional;

@AllArgsConstructor
@Service

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;




    @Override
    public String createUser(RegistrationPojo registrationPojo) {
        if (registrationPojo.getEmail()==null || registrationPojo.getPassword()==null) throw new
                CustomRequestException("field cannot be empty");
        Optional<User> existingUser = userRepository.findByEmail(registrationPojo.getEmail());
        if(existingUser.isPresent())
            throw new CustomException("user already exists, kindly login", HttpStatus.BAD_REQUEST, ZonedDateTime.parse ("2011-12-03T10:15:30+01:00"));
        User user = User.builder()
                .userName(registrationPojo.getUserName())
                .password(registrationPojo.getPassword())
                .email(registrationPojo.getEmail())
                .firstName(registrationPojo.getFirstName())
                .lastName(registrationPojo.getLastName())
                .role(Roles.USER)
                .build();

        userRepository.save(user);
        return "registration successful";

    }

    @Override
    public UserPojo login(UserPojo userPojo) {


        Optional<User> userLogin= Optional.ofNullable(userRepository.findByEmail(userPojo.getEmail())
                .orElseThrow(() -> new UserNotFoundException("User is not found")));

         UserPojo returnValue = new UserPojo();
         BeanUtils.copyProperties(userLogin.get(),returnValue);


        return returnValue;





//        UserPojo found = loginRepository.findByUserNameAndPassword(email, password)
//                .orElseThrow(() -> new CustomRequestException("invalid username or password"));
//        User user=userRepository.findByEmail(email).orElseThrow(() -> new CustomRequestException("invalid username or password"));
//        UserPojo userPojo=new UserPojo();
//        BeanUtils.copyProperties(user,userPojo);
//        return new ResponseEntity<>(userPojo,HttpStatus.OK);..
    }


}

// GIT REMOTE COMMANDLINE
//    git init
//    git add README.md
//        git commit -m "first commit"
//        git branch -M main
//        git remote add origin https://github.com/decadevs/week_nine_sq012-Annahbellah.git
//        git push -u origin main