package com.example.demo.domain.care.converter;

import com.example.demo.domain.care.CareRequestDto;

import java.util.ArrayList;
import java.util.List;

public class CareConverter {

    public static List<String> toInfoList(CareRequestDto.CareInfoRequestDto careInfoRequestDto) {
        List<String> careInfo = new ArrayList();
        careInfo.add(careInfoRequestDto.getName());
        careInfo.add(careInfoRequestDto.getLicenseId());
        careInfo.add(careInfoRequestDto.getHomeNumber());
        careInfo.add(careInfoRequestDto.getPhoneNumber());
        careInfo.add(careInfoRequestDto.getRegisteredAddress());
        careInfo.add(careInfoRequestDto.getSpecAddress());
        careInfo.add(String.valueOf(careInfoRequestDto.isCollectPersonalInfo()));
        careInfo.add(String.valueOf(careInfoRequestDto.isOfferPersonalInfo()));
        careInfo.add(String.valueOf(careInfoRequestDto.isIdentificationInfo()));
        careInfo.add(String.valueOf(careInfoRequestDto.isSenseInfo()));
        careInfo.add(String.valueOf(careInfoRequestDto.isService()));
        careInfo.add(careInfoRequestDto.getRequestName());
        careInfo.add(careInfoRequestDto.getRelative());
        careInfo.add(careInfoRequestDto.getYear());
        careInfo.add(careInfoRequestDto.getMonth());
        careInfo.add(careInfoRequestDto.getDay());
        return careInfo;
    }
}
