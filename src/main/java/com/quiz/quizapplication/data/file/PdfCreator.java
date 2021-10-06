package com.quiz.quizapplication.data;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;

public class PdfCreator {

    Document document = new Document();

    String imgPath = "E:\\gibon\\Desktop\\Repositorium\\QuizApplication\\src\\main\\resources\\";

    public void createPdfFile() {
        try
        {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Test_" + LocalDate.now() + ".pdf"));
            document.open();

            document.add(new Paragraph("Test_" + LocalDate.now()));
            document.add(new Paragraph("Count of points: "));
            document.add(new Paragraph("Name: "));
            document.add(new Paragraph("Surname: "));
            document.add(new Paragraph("Group: "));

            document.addCreator("Tomasz");
            document.addAuthor("Tomasz");
            document.addHeader("TEST", "Test");
            document.addTitle("Test");

            Image image = Image.getInstance(imgPath + "test.jpg");
                image.scaleAbsolute(500, 400);
                image.setAlignment(5);
            Image image1 = Image.getInstance(imgPath + "code.jpg");
                image1.scaleAbsolute(500, 400);
                image1.setAlignment(5);

            document.add(image);
            document.add(image1);

            document.close();
            writer.close();

        } catch (DocumentException e) {
            System.out.println("Somethings is as wrong: " + e);
        } catch (FileNotFoundException e) {
            System.out.println("Somethings is as wrong: " + e);
        } catch (IOException e) {
            System.out.println("Somethings is as wrong: " + e);
        }
    }

}
