package com.example.demo.domain.care;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class CareRequestDto {

    @Getter
    public static class CareInfoRequestDto {
        @Schema(description = "이름", example = "훈이")
        @NotNull
        private String name;
        @Schema(description = "주민등록번호", example = "031111-3555555")
        @NotNull
        private String licenseId;
        @Schema(description = "집 전화번호", example = "02-1111-1111")
        @NotNull
        private String homeNumber;
        @Schema(description = "핸드폰 번호", example = "010-1234-1234")
        @NotNull
        private String phoneNumber;
        @Schema(description = "등록지 주소", example = "서울 특별시 은평구")
        @NotNull
        private String registeredAddress;
        @Schema(description = "거주지 주소", example = "서울 특별시 도봉구")
        @NotNull
        private String specAddress;
        @Schema(description = "개인정보 수집 동의 여부", example = "true")
        @NotNull
        private boolean collectPersonalInfo;
        @Schema(description = "개인정보 제공 동의 여부", example = "true")
        @NotNull
        private boolean offerPersonalInfo;
        @Schema(description = "식별번호 동의 여부", example = "true")
        @NotNull
        private boolean isIdentificationInfo;
        @Schema(description = "민감정보 동의 여부", example = "true")
        @NotNull
        private boolean isSenseInfo;
        @Schema(description = "서비스 동의 여부", example = "true")
        @NotNull
        private boolean isService;
        @Schema(description = "신청자 이름", example = "김영희")
        @NotNull
        private String requestName;
        @Schema(description = "관계", example = "모")
        @NotNull
        private String relative;
        @Schema(description = "년도", example = "2013")
        @NotNull
        private int year;
        @Schema(description = "월", example = "10")
        @NotNull
        private int month;
        @Schema(description = "일", example = "30")
        @NotNull
        private int day;
    }
}
