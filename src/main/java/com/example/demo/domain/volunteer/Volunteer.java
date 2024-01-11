package com.example.demo.domain.volunteer;

import com.example.demo.domain.User;
import com.example.demo.domain.global.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Volunteer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "volunteer_id")
    private Long id;

    @Column(name = "prefer_volunteer")
    private String preferVolunteer;

    @Column(name = "prefer_address")
    private String preferAddress;

    private String volunteer;

    private String writer;

    private String phone;

    @Column(name = "is_volunteer")
    private boolean isCorrectVolunteer;

    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


}
