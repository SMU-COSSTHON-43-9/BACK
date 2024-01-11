package com.example.demo.domain.verify;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
@RequiredArgsConstructor
public class VerifyController {

    private final VerifyService verifyService;

    @PostMapping("/phone")
    public ResponseEntity<?> sendPassword(@RequestBody SMSRequestDto.SMSPhone smsPhone) {
        SMSResponseDto sendSMS = verifyService.sendSMS(smsPhone.getPhone());
        return ResponseEntity.ok(sendSMS);
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verifyPassword(@RequestBody SMSRequestDto.SMSVerify smsVerify) {
        SMSResponseDto s = verifyService.verify(smsVerify);
        return ResponseEntity.ok(s);
    }
}
