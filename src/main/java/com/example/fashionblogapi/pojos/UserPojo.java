package com.example.fashionblogapi.pojos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserPojo {
    private String email;
    private  String password;
    private String username;
}
