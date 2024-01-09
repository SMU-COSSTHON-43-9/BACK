package com.example.demo.exception.errorCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum UserErrorCode implements ErrorCode{

    // 추가할 에러
    INACTIVE_USER(HttpStatus.FORBIDDEN, "존재하지 않는 유저입니다."),
    INACTIVE_FRIEND(HttpStatus.FORBIDDEN, "존재하지 않는 친구 ID입니다."),
    INACTIVE_VOLUNTEER(HttpStatus.NOT_FOUND, "존재하지 않는 봉사 활동 신청이력서 입니다."),
    INCORRECTING_PASSWORD(HttpStatus.FORBIDDEN, "비밀번호가 다릅니다.");




    // 기본 에러 형식
    private final HttpStatus httpStatus;
    private final String message;

}
