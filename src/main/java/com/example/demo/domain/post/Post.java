package com.example.demo.domain.post;

import com.example.demo.domain.User;
import com.example.demo.domain.global.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EnableJpaAuditing
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    private String title;

    private String content;

    private String name;

    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
