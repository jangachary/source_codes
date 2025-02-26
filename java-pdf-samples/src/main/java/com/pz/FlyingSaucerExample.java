package com.pz;
import org.xhtmlrenderer.pdf.ITextRenderer;
import java.io.FileOutputStream;

public class FlyingSaucerExample {
    public static void main(String[] args) {
        try (FileOutputStream outputStream = new FileOutputStream("flying_saucer_example.pdf")) {
            String html = "<html><body><h1>Hello, Flying Saucer!</h1></body></html>";
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(html);
            renderer.layout();
            renderer.createPDF(outputStream);
            System.out.println("PDF created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
