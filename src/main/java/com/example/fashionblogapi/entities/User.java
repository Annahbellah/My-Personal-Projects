package com.example.fashionblogapi.entities;

 import com.example.fashionblogapi.enums.Roles;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

 import javax.management.relation.Role;
 import java.util.Set;


@Entity
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private long userId;

    private String firstName;

    private String lastName;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(unique = true,nullable = false)
    private String userName;

    @JsonIgnore
    @Column(nullable = false)
    private String password;

//    @Column(nullable = false)
//    private String roles;

    @Enumerated(EnumType.STRING)
    private Roles role;

    @OneToMany(mappedBy = "postCreator", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Post> posts;



}


