package com.example.fashionblogapi.services.serviceImpl;

import com.example.fashionblogapi.pojos.LoginPojo;
import com.example.fashionblogapi.pojos.RegistrationPojo;
import com.example.fashionblogapi.entities.User;
import com.example.fashionblogapi.repositories.UserRepository;
import com.example.fashionblogapi.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public String createUser(RegistrationPojo newUser) {
        if (newUser.getEmail()==null || newUser.getPassword() == null || newUser.getUserName() == null)
            throw new

        return null;
    }

    @Override
    public ResponseEntity<User> login(LoginPojo loginPojo) {
        return null;
    }
//
//    @Override
//    public String createUser(RegistrationDto registrationDto) {
//        User user = new User();
//        User byUserName = userRepository.findByUserName(registrationDto.getUserName());
//
//        if( byUserName == null){
//            user.setFirstName(registrationDto.getFirstName());
//            user.setLastName(registrationDto.getLastName());
//            user.setEmail(registrationDto.getEmail());
//            user.setUserName(registrationDto.getUserName());
//            user.setPassword(registrationDto.getPassword());
//
//            userRepository.save(user);
//            return "Registration Successful";
//        }
//
//            throw new CustomRequestException("This user already exists. Go to Login");
//    }
//
//    @Override
//    public ResponseEntity<User> login(LoginDto loginDto) {
//        User byUserNameAndPassword = userRepository.findByUserNameAndPassword(loginDto.getUserName(),
//                                   loginDto.getPassword());
//
//        if(byUserNameAndPassword == null){
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
//
//      return new ResponseEntity<>(byUserNameAndPassword, HttpStatus.OK);
//    }



}
//    git init
//    git add README.md
//        git commit -m "first commit"
//        git branch -M main
//        git remote add origin https://github.com/decadevs/week_nine_sq012-Annahbellah.git
//        git push -u origin main