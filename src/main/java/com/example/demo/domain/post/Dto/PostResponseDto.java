package com.example.demo.domain.post.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


public class PostResponseDto {

    @Getter
    @NoArgsConstructor
    @Builder
    @AllArgsConstructor
    public static class PostDto{

        @NotNull
        private String title;
        @NotNull
        private String content;
        @NotNull
        private String name;
    }

    @Getter
    @NoArgsConstructor
    @Builder
    @AllArgsConstructor
    public static class PostListDto{
        private int count;
        private List<PostDto> Posts;
    }
}
