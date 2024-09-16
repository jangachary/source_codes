package com.pz.main;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;

public class PdfGenerator {

    private static String htmlToXhtml(String html) {
        // Convert HTML to XHTML
        Document document = Jsoup.parse(html);
        document.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
        return document.html();
    }

    public static void main(String[] args) {
        String inputFile = "appointment_letter.html"; // Path to your XHTML/XML file
        String outputFile = "output.pdf"; // Path to the output PDF file

        try {
            // Create an ITextRenderer instance
            ITextRenderer renderer = new ITextRenderer();

            // Read HTML content from file
            String content = FileUtils.readFileToString(Paths.get(inputFile).toFile(), StandardCharsets.UTF_8);

            // Perform replacements
            Map<String, String> valueMap = new HashMap<>();
            valueMap.put("employeeId", "20240200001");
            valueMap.put("employeeName", "Harish Jay Raj");
            valueMap.put("startDate", "25-03-2024");

            Set<Entry<String, String>> entrySet = valueMap.entrySet();
            for (Entry<String, String> es : entrySet) {
                content = content.replace("@{" + es.getKey() + "}", es.getValue());
            }

            // Convert HTML to XHTML
            String htmlToXhtml = PdfGenerator.htmlToXhtml(content);
            renderer.setDocumentFromString(htmlToXhtml);

            // Render the document to PDF
            renderer.layout();
            FileOutputStream fos = new FileOutputStream(outputFile);
            renderer.createPDF(fos);
            fos.close();

            System.out.println("PDF generated successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}