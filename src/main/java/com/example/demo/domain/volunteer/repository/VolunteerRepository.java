package com.example.demo.domain.volunteer.repository;

import com.example.demo.domain.volunteer.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {
}
