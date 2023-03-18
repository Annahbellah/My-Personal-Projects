package com.example.fashionblogapi.pojos;

import com.example.fashionblogapi.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentCreationPojo {
    private Long postId;
    private String commentBody;
    private Long commentAuthorId;
}
