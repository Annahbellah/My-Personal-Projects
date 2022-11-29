package com.example.fashionblogapi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    private String commentBody;
    private Date dateCommented;
    private Time timeCommented;
    private Long likeCount;
    @ManyToOne
    private Post post;
    @ManyToOne
    private User commentAuthor;


}

