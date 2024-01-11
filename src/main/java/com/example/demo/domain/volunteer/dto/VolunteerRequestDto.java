package com.example.demo.domain.volunteer.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class VolunteerRequestDto {

    @Getter
    public static class VolunteerRDto {
        @Schema(description = "비밀 번호", example = "1234")
        @NotNull
        private String password;
        @Schema(description = "선호 봉사 카테고리", example = "교육, 체육 등")
        @NotNull
        private String preferVolunteer;
        @Schema(description = "봉사 선호 지역", example = "서울특별시 도봉구")
        @NotNull
        private String preferAddress;
        @Schema(description = "봉사 공개 여부", example = "true")
        @NotNull
        private boolean correctVolunteer;
        @Schema(description = "지금 까지한 봉사활동", example = "은평구청 청소, 도서관 청소 ...")
        @NotNull
        private String volunteer;
        @Schema(description = "연락처", example = "010-1234-1234")
        @NotNull
        private String phone;
        @Schema(description = "작성자", example = "김철수")
        @NotNull
        private String writer;
    }

    @Getter
    public static class VolunteerDeleteDto {
        @Schema(description = "비밀 번호", example = "1234")
        @NotNull
        private String password;
    }

    @Getter
    public static class VolunteerUpdateDto {
        @Schema(description = "비밀 번호", example = "1234")
        @NotNull
        private String password;
        @Schema(description = "선호 봉사 카테고리", example = "교육, 체육 등")
        @NotNull
        private String preferVolunteer;
        @Schema(description = "봉사 선호 지역", example = "서울특별시 도봉구")
        @NotNull
        private String preferAddress;
        @Schema(description = "봉사 공개 여부", example = "true")
        @NotNull
        private boolean correctVolunteer;
        @Schema(description = "지금 까지한 봉사활동", example = "은평구청 청소, 도서관 청소 ...")
        @NotNull
        private String volunteer;
        @Schema(description = "연락처", example = "010-1234-1234")
        @NotNull
        private String phone;
    }
}
