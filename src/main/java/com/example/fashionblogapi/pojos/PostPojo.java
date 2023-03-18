package com.example.fashionblogapi.pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PostPojo {

    private Long userId;
    private String postTitle;
    private String body;
}

