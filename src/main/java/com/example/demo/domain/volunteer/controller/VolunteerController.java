package com.example.demo.domain.volunteer.controller;

import com.example.demo.domain.volunteer.dto.VolunteerResponseDto;
import com.example.demo.domain.volunteer.service.VolunteerService;
import com.example.demo.domain.volunteer.dto.VolunteerRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class VolunteerController {

    private final VolunteerService volunteerService;

    @PostMapping("/volunteers")
    public ResponseEntity<?> createVolunteers(@RequestBody VolunteerRequestDto.VolunteerDto volunteerDto) {
        Long id = volunteerService.createVolunteers(volunteerDto);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/volunteers")
    public ResponseEntity<?> readVolunteers() {
        VolunteerResponseDto.VolunteerListDto readVolunteers = volunteerService.readVolunteers();
        return ResponseEntity.ok(readVolunteers);
    }

    @GetMapping("/volunteers/{volunteerId}")
    public ResponseEntity<?> readVolunteer(@PathVariable Long volunteerId) {
        VolunteerResponseDto.VolunteerDto volunteerDto = volunteerService.readVolunteer(volunteerId);
        return ResponseEntity.ok(volunteerDto);
    }

    @DeleteMapping("/volunteers/{volunteerId}")
    public ResponseEntity<?> deleteVolunteer(@PathVariable Long volunteerId, @RequestBody VolunteerRequestDto.VolunteerDeleteDto volunteerDeleteDto) {
        String deleteComplete = volunteerService.deleteVolunteer(volunteerId,volunteerDeleteDto);
        return ResponseEntity.ok(deleteComplete);
    }

}
