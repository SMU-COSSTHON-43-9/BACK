package com.example.demo.domain.care;

import com.example.demo.domain.care.converter.CareConverter;
import com.example.demo.domain.care.mail.MailSendService;
import com.example.demo.domain.care.pdf.PdfService;
import com.example.demo.exception.errorCode.UserErrorCode;
import com.example.demo.exception.exception.RestApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CareService {

    private final MailSendService mailSendService;
    private final PdfService pdfService;

    public void carePost(CareRequestDto.CareInfoRequestDto careInfoRequestDto) {
        try {
            List<String> careStrings =CareConverter.toInfoList(careInfoRequestDto);
            pdfService.getPdf(careStrings);
        } catch (IOException e) {
            e.printStackTrace();
            File file = new File("request.pdf");
            file.delete();
            throw new RestApiException(UserErrorCode.PDF_GENERATE_ERROR);
        }

        try {
            mailSendService.exampleMail(careInfoRequestDto.getName());
        } catch (Exception e) {
            e.printStackTrace();
            File file = new File("request.pdf");
            file.delete();
            throw new RestApiException(UserErrorCode.MAIL_ERROR);
        }

    }
}
