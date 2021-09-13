package com.quiz.quizapplication.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class CreateLog {

    public void logException(String name, Exception e) throws IOException {
        LocalTime localTime = LocalTime.now();
        PrintWriter writer = new PrintWriter(name + "_" + LocalDate.now() + "_" +  localTime.getHour() + "_" + localTime.getMinute() + ".txt", StandardCharsets.UTF_8);
        writer.println("Time: " + localTime);
        writer.println("Wrong: \n" + e);
        writer.close();
    }

    public void logSqlException(String name, SQLException e) throws IOException {
        LocalTime localTime = LocalTime.now();
        PrintWriter writer = new PrintWriter(name + "_" + LocalDate.now() + "_" +  localTime.getHour() + "_" + localTime.getMinute() + ".txt", StandardCharsets.UTF_8);
        writer.println("Time: " + localTime);
        writer.println("Wrong: \n" + e);
        writer.close();
    }

}
