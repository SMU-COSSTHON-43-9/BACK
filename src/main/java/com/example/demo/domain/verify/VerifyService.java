package com.example.demo.domain.verify;

import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;
import com.example.demo.exception.errorCode.UserErrorCode;
import com.example.demo.exception.exception.RestApiException;
import jakarta.persistence.EntityManager;
import kotlinx.serialization.json.JsonObject;
import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.util.Random;
import java.util.regex.Pattern;

@Service
public class VerifyService {

    @Value("${sms.key}")
    private String api_key;

    @Value("${sms.secret}")
    private String api_secret;

    @Value("${phone.num}")
    private String from;

    @Autowired
    private UserRepository userRepository;

    DefaultMessageService messageService;

    public SMSResponseDto sendSMS(String phonenumber) {
        System.out.println(api_key);
        System.out.println(api_secret);

        try{
            if(phonenumber == null || !Pattern.matches("\\d{11}$", phonenumber)) {
                throw new RestApiException(UserErrorCode.IN_PHONE_NUM);
            }

            // 난수 생성해서 저장
            Random random = new Random();
            random.setSeed(System.currentTimeMillis()); // 정말 랜덤하게 나오도록!
            int randomNumber = (int)(random.nextInt(8999)) + 1000;  //  (100000 ~ 999999)
            String s = String.valueOf(randomNumber);

            // coolsms
            // 반드시 계정 내 등록된 유효한 API 키, API Secret Key를 입력해주셔야 합니다!
            this.messageService = NurigoApp.INSTANCE.initialize(api_key, api_secret, "https://api.coolsms.co.kr");

            Message message = new Message();
            // 발신번호 및 수신번호는 반드시 01012345678 형태로 입력되어야 합니다.
            message.setFrom(from);
            message.setTo(phonenumber);
            message.setText("노봄 인증번호 : " + String.valueOf(s));
            SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(message));



            User user1 = userRepository.findUserByPhone(phonenumber);

            if (user1 == null) {
                User user = User.builder()
                        .phone(phonenumber)
                        .password(s)
                        .build();
                userRepository.save(user);
            } else {
                User user = User.builder()
                        .id(user1.getId())
                        .phone(phonenumber)
                        .password(s)
                        .build();
                userRepository.save(user);
            }


            return new SMSResponseDto(true, "전화번호 인증번호 요청 성공");
        } catch(Exception e) {
            System.out.println(e);
            throw new RestApiException(UserErrorCode.IN_PHONE_NUM);
        }

    }

    public SMSResponseDto verify(SMSRequestDto.SMSVerify smsVerify) {
        User user = userRepository.findUserByPhone(smsVerify.getPhone());
        if (user == null) {
            throw new RestApiException(UserErrorCode.INACTIVE_USER);
        }
        if(!(user.getPassword().equals(smsVerify.getPassword()))) {
            throw new RestApiException(UserErrorCode.INCORRECTING_PASSWORD);
        }
        return new SMSResponseDto(true, "검증 성공");
    }
}
