package com.example.demo.domain.chat_gpt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class ChatDto {

    @Getter
    public static class ChatGptRequestDto{
        private String question;
    }

    @Getter
    @NoArgsConstructor
    @Builder
    @AllArgsConstructor
    public static class ChatResponseDto{
        private String response;
    }
}
