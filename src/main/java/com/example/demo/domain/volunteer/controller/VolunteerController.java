package com.example.demo.domain.volunteer.controller;

import com.example.demo.domain.volunteer.dto.VolunteerResponseDto;
import com.example.demo.domain.volunteer.service.VolunteerService;
import com.example.demo.domain.volunteer.dto.VolunteerRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = "노인 봉사 신청", description = "노인 봉사 신청 컨트롤러 입니다.")
public class VolunteerController {

    private final VolunteerService volunteerService;


    @Operation(summary = "노인 봉사 신청 작성", description = "노인 봉사 신청 작성")
    @ApiResponse(responseCode = "200", description = "노인 봉사 신청 작성 성공", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Long.class))
    })
    @ApiResponse(responseCode = "500", description = "서버 내 오류")
    @PostMapping("/volunteers")
    public ResponseEntity<?> createVolunteers(@Valid @RequestBody VolunteerRequestDto.VolunteerRDto volunteerRDto) {
        Long id = volunteerService.createVolunteers(volunteerRDto);
        return ResponseEntity.ok(id);
    }

    @Operation(summary = "노인 봉사 신청 전체 조회", description = "노인 봉사 신청 전체 조회")
    @ApiResponse(responseCode = "200", description = "노인 봉사 신청 작성 성공", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = VolunteerResponseDto.VolunteerListDto.class))
    })
    @ApiResponse(responseCode = "500", description = "서버 내 오류")
    @GetMapping("/volunteers")
    public ResponseEntity<?> readVolunteers() {
        VolunteerResponseDto.VolunteerListDto readVolunteers = volunteerService.readVolunteers();
        return ResponseEntity.ok(readVolunteers);
    }

    @Operation(summary = "노인 봉사 신청 조회", description = "노인 봉사 신청 전체 조회")
    @ApiResponse(responseCode = "200", description = "노인 봉사 신청 작성 성공", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = VolunteerResponseDto.VolunteerDto.class))
    })
    @ApiResponse(responseCode = "403", description = "존재하지 않는 봉사 활동 신청이력서 입니다.")
    @ApiResponse(responseCode = "500", description = "서버 내 오류")
    @GetMapping("/volunteers/{volunteerId}")
    public ResponseEntity<?> readVolunteer(@PathVariable Long volunteerId) {
        VolunteerResponseDto.VolunteerDto volunteerDto = volunteerService.readVolunteer(volunteerId);
        return ResponseEntity.ok(volunteerDto);
    }

    @Operation(summary = "노인 봉사 신청 삭제", description = "노인 봉사 신청 삭제")
    @ApiResponse(responseCode = "200", description = "노인 봉사 신청 성공", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
    })
    @ApiResponse(responseCode = "403", description = "존재하지 않는 봉사 활동 신청이력서 입니다.")
    @ApiResponse(responseCode = "403", description = "비밀번호가 다릅니다.")
    @ApiResponse(responseCode = "500", description = "서버 내 오류")
    @DeleteMapping("/volunteers/{volunteerId}")
    public ResponseEntity<?> deleteVolunteer(@PathVariable Long volunteerId, @Valid @RequestBody VolunteerRequestDto.VolunteerDeleteDto volunteerDeleteDto) {
        String deleteComplete = volunteerService.deleteVolunteer(volunteerId,volunteerDeleteDto);
        return ResponseEntity.ok(deleteComplete);
    }

}
