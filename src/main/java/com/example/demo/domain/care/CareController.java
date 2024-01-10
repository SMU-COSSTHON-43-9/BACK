package com.example.demo.domain.care;

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
@Tag(name = "노인 돌봄 신청", description = "노인 돌봄 신청 컨트롤러 입니다.")
public class CareController {

    private final CareService careService;


    @Operation(summary = "노인 돌봄 신청", description = "노인 돌봄 신청서 작성 및 전송")
    @ApiResponse(responseCode = "200", description = "노인 돌봄 신청 성공", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
    })
    @ApiResponse(responseCode = "403", description = "pdf 생성에 실패하였습니다.")
    @ApiResponse(responseCode = "403", description = "존재하지 않는 post입니다.")
    @ApiResponse(responseCode = "500", description = "서버 내 오류")
    @PostMapping("/cares")
    public ResponseEntity<?> carePost(@Valid @RequestBody CareRequestDto.CareInfoRequestDto careInfoRequestDto) {
        careService.carePost(careInfoRequestDto);
        return ResponseEntity.ok("메일 전송에 성공하였습니다.");
    }
}
