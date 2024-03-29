package com.example.demo.domain;

import com.example.demo.domain.global.BaseEntity;
import com.example.demo.domain.post.Post;
import com.example.demo.domain.volunteer.Volunteer;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String name;

    private String password;

    @Embedded
    private Address address;

    private String phone;

    @OneToMany(mappedBy = "user")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Volunteer> volunteers = new ArrayList<>();
}
