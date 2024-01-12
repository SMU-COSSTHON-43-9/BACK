package com.example.demo.domain.care.pdf;


import org.apache.fontbox.ttf.TrueTypeCollection;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class PdfService {
    public void getPdf(List<String> infos) throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);
        File fontFile = new File("gulim.ttc");
        PDType0Font fontGulim = PDType0Font.load(document, new TrueTypeCollection(fontFile).getFontByName("Gulim"), true);
        PDImageXObject pdImage = PDImageXObject.createFromFile("oldman_request.png", document);
        PDPageContentStream pcs = new PDPageContentStream(document, document.getPage(0), PDPageContentStream.AppendMode.APPEND, false);
        pcs.drawImage(pdImage,0,0,595,842);
        pcs.beginText();
        pcs.setFont(fontGulim,10); // 폰트 크기 설정
        pcs.newLineAtOffset(175f, 633f);
        pcs.showText(infos.get(0)); // 이름
        pcs.newLineAtOffset(175f, 0f);
        pcs.showText(infos.get(1)); // 주민등록 번호
        pcs.newLineAtOffset(-145f, -18f);
        pcs.showText(infos.get(2)); // 집 전화번호
        pcs.newLineAtOffset(175f, 0f);
        pcs.showText(infos.get(5)); // 등록지
        pcs.newLineAtOffset(-178f, -18f);
        pcs.showText(infos.get(3)); // 휴대폰
        pcs.newLineAtOffset(180f, 0f);
        pcs.showText(infos.get(4)); // 거주지
        pcs.newLineAtOffset(90f, -50f);

        if(infos.get(6).equals("true")) {
            pcs.showText("V");
        } else {
            pcs.newLineAtOffset(0f, -20f);
            pcs.showText("V");
            pcs.newLineAtOffset(0f, 20f);
        }

        pcs.newLineAtOffset(0f, -70f);

        if(infos.get(7).equals("true")) {
            pcs.showText("V");
        } else {
            pcs.newLineAtOffset(0f, -20f);
            pcs.showText("V");
            pcs.newLineAtOffset(0f, 20f);
        }

        pcs.newLineAtOffset(0f, -73f);

        if(infos.get(8).equals("true")) {
            pcs.showText("V");
        } else {
            pcs.newLineAtOffset(0f, -20f);
            pcs.showText("V");
            pcs.newLineAtOffset(0f, 20f);
        }

        pcs.newLineAtOffset(0f, -55f);
        if(infos.get(9).equals("true")) {
            pcs.showText("V");
        } else {
            pcs.newLineAtOffset(0f, -20f);
            pcs.showText("V");
            pcs.newLineAtOffset(0f, 20f);
        }

        pcs.newLineAtOffset(0f, -86f);
        if(infos.get(10).equals("true")) {
            pcs.showText("V");
        } else {
            pcs.newLineAtOffset(0f, -20f);
            pcs.showText("V");
            pcs.newLineAtOffset(0f, 20f);
        }

        pcs.newLineAtOffset(-275f, -78f);
        pcs.showText(infos.get(11));

        pcs.newLineAtOffset(45f, 0f);
        pcs.showText(infos.get(11));

        pcs.newLineAtOffset(167f, -14f);
        pcs.showText(infos.get(12));

        pcs.newLineAtOffset(0f, 27f);
        pcs.showText(infos.get(13));

        pcs.newLineAtOffset(40f, 0f);
        pcs.showText(infos.get(14));

        pcs.newLineAtOffset(30f, 0f);
        pcs.showText(infos.get(15));

        pcs.endText();
        pcs.close();
        document.save("request.pdf");
        document.close();
    }
}
