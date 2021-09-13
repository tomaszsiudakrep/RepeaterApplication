package com.quiz.quizapplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalTime;

public class SaveAndLoadSettings {

    public void saveSettings() throws IOException {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        PrintWriter writer = new PrintWriter("settings.txt", StandardCharsets.UTF_8);
        writer.println("Date: " + localDate);
        writer.println("Time: " + localTime);
        writer.close();
    }

}
