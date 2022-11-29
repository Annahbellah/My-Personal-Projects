package com.example.fashionblogapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String postTitle;
    private String body;
    private Date dateCreated;
    private long likeCounts = 0;
    private long commentCounts = 0;
    @ManyToOne
    @JsonIgnore
    private User postCreator;

    @OneToMany
    private List<Comment> comment;


}
