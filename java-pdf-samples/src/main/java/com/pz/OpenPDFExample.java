package com.pz;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileOutputStream;

public class OpenPDFExample {
    public static void main(String[] args) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("openpdf_example.pdf"));
            document.open();
            document.add(new Paragraph("Hello, OpenPDF!"));
            System.out.println("PDF created successfully.");
        } catch (DocumentException | java.io.IOException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}
