package com.example.fashionblogapi.pojos;

import com.example.fashionblogapi.entities.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentPojo {
    private Long userId;
    private Long commentId;
    private Long postId;
    private String commentBody;
    private User commentAuthor;
}

