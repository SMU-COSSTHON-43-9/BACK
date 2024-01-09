package com.example.demo.domain.post.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class PostRequestDto {
    @Getter
    public static class PostDto{
        @NotNull
        private String title;
        @NotNull
        private String content;
        @NotNull
        private int password;
        @NotNull
        private String name;
    }

    @Getter
    public static class PostDeleteDto{
        @NotNull
        private int password;
    }
}
