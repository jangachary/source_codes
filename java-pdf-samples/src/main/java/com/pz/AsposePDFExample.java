package com.pz;
import com.aspose.pdf.*;

public class AsposePDFExample {
    public static void main(String[] args) {
        Document document = new Document();
        Page page = document.getPages().add();
        page.getParagraphs().add(new TextFragment("Hello, Aspose PDF!"));
        document.save("aspose_pdf_example.pdf");
        System.out.println("PDF created successfully.");
    }
}
