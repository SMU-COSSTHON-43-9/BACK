package com.example.demo.domain.care;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CareController {

    private final CareService careService;

    @PostMapping("/cares")
    public ResponseEntity<?> carePost(@RequestBody CareRequestDto.CareInfoRequestDto careInfoRequestDto) {
        careService.carePost(careInfoRequestDto);
        return ResponseEntity.ok("메일 전송에 성공하였습니다.");
    }
}
