package com.example.demo.domain.verify;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;

@Getter
@AllArgsConstructor
@Data
public class SMSResponseDto {
    @JsonProperty("isSuccess")
    private boolean isSuccess;
    private String message;
}
