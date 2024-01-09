package com.example.demo.domain.care.converter;

import com.example.demo.domain.care.CareRequestDto;

import java.util.ArrayList;
import java.util.List;

public class CareConverter {

    public static List<String> toInfoList(CareRequestDto.CareInfoRequestDto careInfoRequestDto) {
        List<String> careInfo = new ArrayList();
        careInfo.add("이름 : " + careInfoRequestDto.getName());
        careInfo.add("주민등록번호 : " + careInfoRequestDto.getLicenseId());
        careInfo.add("집 전화번호 : " + careInfoRequestDto.getHomeNumber());
        careInfo.add("핸드폰 번호 : " + careInfoRequestDto.getPhoneNumber());
        careInfo.add("등록지 주소 : " + careInfoRequestDto.getRegisteredAddress());
        careInfo.add("실 거주 주소 : " + careInfoRequestDto.getSpecAddress());
        careInfo.add("개인정보 수집 동의 여부 : " + careInfoRequestDto.isCollectPersonalInfo());
        careInfo.add("개인정보 제공 동의 여부 : " + careInfoRequestDto.isOfferPersonalInfo());
        careInfo.add("고유식별정보 수집동의 여부 : " + careInfoRequestDto.isIdentificationInfo());
        careInfo.add("민감정보 수집동의 여부 : " + careInfoRequestDto.isSenseInfo());
        careInfo.add("서비스 신청 동의 여부 : " + careInfoRequestDto.isService());
        careInfo.add("신청인 성명 : " + careInfoRequestDto.getRequestName());
        careInfo.add("신청인과의 관계 : " + careInfoRequestDto.getRelative());
        careInfo.add("날짜 : " + careInfoRequestDto.getYear() + '-' + careInfoRequestDto.getMonth() + '-' + careInfoRequestDto.getDay());
        return careInfo;
    }
}
