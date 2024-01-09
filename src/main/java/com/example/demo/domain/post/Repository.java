package com.example.demo.domain.post;


import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Post, Long> {
}
