package com.example.demo.domain.chat_gpt;

import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatgptService chatgptService;

    public ChatDto.ChatResponseDto getChatResponse(String prompt) {
        String result = chatgptService.sendMessage(prompt);
        return ChatDto.ChatResponseDto.builder().response(result).build();
    }

}
