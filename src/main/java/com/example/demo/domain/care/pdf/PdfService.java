package com.example.demo.domain.care.pdf;


import org.apache.fontbox.ttf.TrueTypeCollection;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
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
        File fontFile = new File("/root/gulim.ttc");
        PDType0Font fontGulim = PDType0Font.load(document, new TrueTypeCollection(fontFile).getFontByName("Gulim"), true);
        PDPageContentStream pcs = new PDPageContentStream(document, document.getPage(0), PDPageContentStream.AppendMode.APPEND, false);
        pcs.beginText();
        pcs.setFont(fontGulim,20); // 폰트 크기 설정
        pcs.newLineAtOffset(35f, 780f);

        for(String info : infos) {
            pcs.showText(info);
            pcs.newLine();
            pcs.newLineAtOffset(0, -28f);
        }
        pcs.endText();
        pcs.close();
        document.save("request.pdf");
        document.close();
    }
}
