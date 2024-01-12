package com.example.demo.domain.volunteer.service;

import com.example.demo.domain.post.Post;
import com.example.demo.domain.volunteer.Volunteer;
import com.example.demo.domain.volunteer.converter.VolunteerConverter;
import com.example.demo.domain.volunteer.dto.VolunteerRequestDto;
import com.example.demo.domain.volunteer.dto.VolunteerResponseDto;
import com.example.demo.domain.volunteer.repository.VolunteerRepository;
import com.example.demo.exception.errorCode.UserErrorCode;
import com.example.demo.exception.exception.RestApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class VolunteerService {

    private final VolunteerRepository volunteerRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public Long createVolunteers(VolunteerRequestDto.VolunteerRDto volunteerRDto) {
        volunteerRDto.setPassword(bCryptPasswordEncoder.encode(volunteerRDto.getPassword()));
        Volunteer volunteer = VolunteerConverter.toVolunteer(volunteerRDto);
        Volunteer saveVolunteer = volunteerRepository.save(volunteer);
        return saveVolunteer.getId();
    }

    @Transactional(readOnly = true)
    public VolunteerResponseDto.VolunteerListDto readVolunteers() {
        List<Volunteer> volunteers = volunteerRepository.findAllByOrderByUpdateAtDesc();
        return VolunteerConverter.toVolunteerListDto(volunteers);
    }

    @Transactional(readOnly = true)
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
        //if (!(volunteerDeleteDto.getPassword().equals(volunteer.getPassword()))) {
        if(!bCryptPasswordEncoder.matches(volunteerDeleteDto.getPassword(), volunteer.getPassword())){
            throw new RestApiException(UserErrorCode.INCORRECTING_PASSWORD);
        }
        volunteerRepository.delete(volunteer);
        return "봉사 신청 이력서 삭제가 완료되었습니다.";
    }

    public Long updateVolunteer(Long volunteerId, VolunteerRequestDto.VolunteerUpdateDto volunteerUpdateDto) {
        Volunteer volunteer = volunteerRepository.findById(volunteerId).orElseThrow(()-> {
            throw new RestApiException(UserErrorCode.INACTIVE_VOLUNTEER);
        });
        if(!bCryptPasswordEncoder.matches(volunteerUpdateDto.getPassword(), volunteer.getPassword())){
            throw new RestApiException(UserErrorCode.INCORRECTING_PASSWORD);
        }
        Volunteer updateVolunteer = Volunteer.builder()
                                    .id(volunteer.getId())
                                    .preferVolunteer(volunteerUpdateDto.getPreferVolunteer())
                                    .isCorrectVolunteer(volunteerUpdateDto.isCorrectVolunteer())
                                    .preferAddress(volunteerUpdateDto.getPreferAddress())
                                    .phone(volunteerUpdateDto.getPhone())
                                    .volunteer(volunteerUpdateDto.getVolunteer())
                                    .password(volunteer.getPassword())
                                    .writer(volunteer.getWriter())
                                    .build();

        Volunteer volunteer1 = volunteerRepository.save(updateVolunteer);
        Long id = volunteer1.getId();
        return id;
    }

    public void verifyVolunteer(Long volunteerId, VolunteerRequestDto.VolunteerVerifyDto verifyDto) {
        Volunteer volunteer = volunteerRepository.findById(volunteerId).orElseThrow(()-> {
            throw new RestApiException(UserErrorCode.INACTIVE_VOLUNTEER);
        });
        if(!bCryptPasswordEncoder.matches(verifyDto.getPassword(), volunteer.getPassword())){
            throw new RestApiException(UserErrorCode.INCORRECTING_PASSWORD);
        }
    }
}
