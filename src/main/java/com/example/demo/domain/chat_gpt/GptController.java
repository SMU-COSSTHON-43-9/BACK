package com.example.demo.domain.chat_gpt;

import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class GptController {

    private final ChatService chatService;

    //chat-gpt 와 간단한 채팅 서비스 소스
    @PostMapping("/chat")
    public ResponseEntity<?> chatGpt(@RequestBody ChatDto.ChatGptRequestDto chatGptRequestDto){
        ChatDto.ChatResponseDto chatResponseDto = chatService.getChatResponse(chatGptRequestDto.getQuestion());
        return ResponseEntity.ok(chatResponseDto);
    }

}
