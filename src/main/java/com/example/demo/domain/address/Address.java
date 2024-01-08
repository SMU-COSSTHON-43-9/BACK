package com.example.demo.domain.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Embeddable
@Getter
@AllArgsConstructor
public class Address {
    private String region;
    private String city;
    private String dong;

    protected Address() {

    }
}
