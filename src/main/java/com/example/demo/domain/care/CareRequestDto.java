package com.example.demo.domain.care;

import lombok.Getter;

public class CareRequestDto {

    @Getter
    public static class CareInfoRequestDto {
        private String name;
        private String licenseId;
        private String homeNumber;
        private String phoneNumber;
        private String registeredAddress;
        private String specAddress;
        private boolean collectPersonalInfo;
        private boolean offerPersonalInfo;
        private boolean isIdentificationInfo;
        private boolean isSenseInfo;
        private boolean isService;
        private String requestName;
        private String relative;
        private int year;
        private int month;
        private int day;
    }
}
