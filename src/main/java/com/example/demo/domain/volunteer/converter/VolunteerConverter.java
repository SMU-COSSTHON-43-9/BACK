package com.example.demo.domain.volunteer.converter;

import com.example.demo.domain.volunteer.Volunteer;
import com.example.demo.domain.volunteer.dto.VolunteerRequestDto;
import com.example.demo.domain.volunteer.dto.VolunteerResponseDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VolunteerConverter {

    public static Volunteer toVolunteer (VolunteerRequestDto.VolunteerRDto volunteerRDto) {
        return com.example.demo.domain.volunteer.Volunteer.builder()
                .isCorrectVolunteer(volunteerRDto.isCorrectVolunteer())
                .password(volunteerRDto.getPassword())
                .writer(volunteerRDto.getWriter())
                .preferAddress(volunteerRDto.getPreferAddress())
                .preferVolunteer(volunteerRDto.getPreferVolunteer())
                .phone(volunteerRDto.getPhone())
                .volunteer(volunteerRDto.getVolunteer())
                .build();
    }

    public static VolunteerResponseDto.VolunteerDto toVolunteerDto(Volunteer volunteer) {
        return VolunteerResponseDto.VolunteerDto.builder()
                .id(volunteer.getId())
                .preferVolunteer(volunteer.getPreferVolunteer())
                .isVolunteer(volunteer.isCorrectVolunteer())
                .volunteer(volunteer.getVolunteer())
                .preferAddress(volunteer.getPreferAddress())
                .writer(volunteer.getWriter())
                .updatedTime(LocalDate.from(volunteer.getUpdateAt()))
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
