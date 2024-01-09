package com.example.demo.domain.volunteer.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class VolunteerRequestDto {

//    	"password":1234,
//                "prefer_volunteer":"교육, 도서관 등",
//                "prefer_address":"서울특별시 경기도",
//                "is_volunteer":true
//                "volunteer":"2013-01-01 ~ 2015-02-02 은평구 도서관",
//                "writer":"김철수",
//                "phone":"010-1234-5689"

    @Getter
    public static class VolunteerDto {
        @NotNull
        private int password;
        @NotNull
        private String preferVolunteer;
        @NotNull
        private String preferAddress;
        @NotNull
        private boolean isVolunteer;
        @NotNull
        private String volunteer;
        @NotNull
        private String phone;
        @NotNull
        private String writer;
    }

    @Getter
    public static class VolunteerDeleteDto {
        @NotNull
        private int password;
    }
}
