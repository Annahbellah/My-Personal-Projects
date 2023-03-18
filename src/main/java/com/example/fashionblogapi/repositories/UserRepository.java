package com.example.fashionblogapi.repositories;

import com.example.fashionblogapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
 User findByUserName(String userName);
 User findByUserNameAndPassword(String userName, String password);
 User findByRoles(String role);



 Optional<User> findByEmail(String email);
}
