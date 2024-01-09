package com.example.demo.domain.volunteer.converter;

import com.example.demo.domain.volunteer.Volunteer;
import com.example.demo.domain.volunteer.dto.VolunteerRequestDto;
import com.example.demo.domain.volunteer.dto.VolunteerResponseDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VolunteerConverter {

    public static Volunteer toVolunteer (VolunteerRequestDto.VolunteerDto volunteerDto) {
        return com.example.demo.domain.volunteer.Volunteer.builder()
                .isVolunteer(volunteerDto.isVolunteer())
                .password(volunteerDto.getPassword())
                .writer(volunteerDto.getWriter())
                .preferAddress(volunteerDto.getPreferAddress())
                .preferVolunteer(volunteerDto.getPreferVolunteer())
                .phone(volunteerDto.getPhone())
                .volunteer(volunteerDto.getVolunteer())
                .build();
    }

    public static VolunteerResponseDto.VolunteerDto toVolunteerDto(Volunteer volunteer) {
        return VolunteerResponseDto.VolunteerDto.builder()
                .id(volunteer.getId())
                .preferVolunteer(volunteer.getPreferVolunteer())
                .isVolunteer(true)
                .preferAddress(volunteer.getPreferAddress())
                .writer(volunteer.getWriter())
                .build();
    }

    public static VolunteerResponseDto.VolunteerListDto toVolunteerListDto(List<Volunteer> volunteer) {
        List<VolunteerResponseDto.VolunteerDto> volunteerList = new ArrayList<>();
        for(Volunteer v : volunteer) {
            volunteerList.add(toVolunteerDto(v));
        }


        return VolunteerResponseDto.VolunteerListDto.builder()
                .count(volunteerList.size())
                .volunteers(volunteerList)
                .build();
    }

}
