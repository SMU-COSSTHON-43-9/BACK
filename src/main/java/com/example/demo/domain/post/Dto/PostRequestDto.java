package com.example.demo.domain.post.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class PostRequestDto {
    @Getter
    public static class PostRDto {
        @Schema(description = "제목", example = "배드민턴 모임 입니다!")
        @NotNull
        private String title;
        @Schema(description = "내용", example = "서울 특별시 은평구에서 10시에 같이 배드민턴할사람")
        @NotNull
        private String content;
        @Schema(description = "제목", example = "1234")
        @NotNull
        private int password;
        @Schema(description = "제목", example = "훈이")
        @NotNull
        private String name;
    }

    @Getter
    public static class PostDeleteDto{
        @Schema(description = "비밀번호", example = "1234")
        @NotNull
        private int password;
    }
}
