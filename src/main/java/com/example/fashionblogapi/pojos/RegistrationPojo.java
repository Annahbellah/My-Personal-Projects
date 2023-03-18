package com.example.fashionblogapi.pojos;

import com.example.fashionblogapi.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class RegistrationPojo {
    private String firstName;
    private String lastName;
    private String email;

    private String userName;

    private Roles role;

    private String password;



}
