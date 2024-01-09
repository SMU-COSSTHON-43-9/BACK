package com.example.demo.domain.care.mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@RequiredArgsConstructor
public class MailSendService {

    private final JavaMailSender mailSender;

    @Value("${user.email}")
    private String toEmail;

    @Value("${spring.mail.username}")
    private String fromEmail;

    public void exampleMail(String name) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setFrom(fromEmail);
        mimeMessageHelper.setText(name + "님의 노인 돌봄 신청서 입니다");
        File file = new File("request.pdf");
        mimeMessageHelper.addAttachment(name + "님의 노인 돌봄 신청서.pdf", file);
        mailSender.send(mimeMessage);
        file.delete();
    }
}
