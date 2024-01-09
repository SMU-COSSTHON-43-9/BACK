package com.example.demo.domain.volunteer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class VolunteerResponseDto {

    @Getter
    @NoArgsConstructor
    @Builder
    @AllArgsConstructor
    public static class VolunteerDto {
        @NotNull
        private Long id;
        @NotNull
        private String preferVolunteer;
        @NotNull
        private String preferAddress;
        @NotNull
        private boolean isVolunteer;
        @NotNull
        private String writer;
    }

    @Getter
    @NoArgsConstructor
    @Builder
    @AllArgsConstructor
    public static class VolunteerListDto {
        private int count;
        private List<VolunteerDto> volunteers;
    }

}
