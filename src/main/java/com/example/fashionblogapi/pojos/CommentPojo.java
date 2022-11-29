package com.example.fashionblogapi.pojos;

import com.example.fashionblogapi.entities.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentPojo {
    private String commentBody;

    private User commentAuthor;
}
