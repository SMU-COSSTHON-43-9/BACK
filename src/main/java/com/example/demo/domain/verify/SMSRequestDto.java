package com.example.demo.domain.verify;

import lombok.Getter;

public class SMSRequestDto {

    @Getter
    public static class SMSPhone {
        private String phone;
    }

    @Getter
    public static class SMSVerify {
        private String phone;
        private String password;
    }

}
