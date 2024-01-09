package com.example.demo.domain.volunteer.service;

import com.example.demo.domain.volunteer.Volunteer;
import com.example.demo.domain.volunteer.converter.VolunteerConverter;
import com.example.demo.domain.volunteer.dto.VolunteerRequestDto;
import com.example.demo.domain.volunteer.dto.VolunteerResponseDto;
import com.example.demo.domain.volunteer.repository.VolunteerRepository;
import com.example.demo.exception.errorCode.UserErrorCode;
import com.example.demo.exception.exception.RestApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VolunteerService {

    private final VolunteerRepository volunteerRepository;

    public Long createVolunteers(VolunteerRequestDto.VolunteerDto volunteerDto) {
        Volunteer volunteer = VolunteerConverter.toVolunteer(volunteerDto);
        Volunteer saveVolunteer = volunteerRepository.save(volunteer);
        return saveVolunteer.getId();
    }

    public VolunteerResponseDto.VolunteerListDto readVolunteers() {
        List<Volunteer> volunteers = volunteerRepository.findAll();
        return VolunteerConverter.toVolunteerListDto(volunteers);
    }

    public VolunteerResponseDto.VolunteerDto readVolunteer(Long id) {
        Volunteer volunteer = volunteerRepository.findById(id).orElseThrow(()-> {
            throw new RestApiException(UserErrorCode.INACTIVE_VOLUNTEER);
        });

        return VolunteerConverter.toVolunteerDto(volunteer);
    }

    public String deleteVolunteer(Long volunteerId, VolunteerRequestDto.VolunteerDeleteDto volunteerDeleteDto) {
        Volunteer volunteer = volunteerRepository.findById(volunteerId).orElseThrow(()-> {
            throw new RestApiException(UserErrorCode.INACTIVE_VOLUNTEER);
        });
        if (volunteerDeleteDto.getPassword() != volunteer.getPassword()) {
            throw new RestApiException(UserErrorCode.INCORRECTING_PASSWORD);
        }
        volunteerRepository.delete(volunteer);
        return "삭제가 완료되었습니다.";
    }
}
