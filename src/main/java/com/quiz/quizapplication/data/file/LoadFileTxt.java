package com.quiz.quizapplication.data;

import java.io.*;

public class LoadSolution {

public static String exercises_path = "E:\\gibon\\Desktop\\Repositorium\\QuizApplication\\src\\main\\resources\\solutions\\ex";
public static String information_path = "E:\\gibon\\Desktop\\IT\\ImportantInformation\\";

    public void loadExampleSolution(String exercisesId) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        String file = exercises_path + exercisesId + ".txt";
        runtime.exec("notepad " + file);
    }

    public void loadImportantInformation(String group, String title) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        String file = information_path + group + "_" + title + ".txt";
        runtime.exec("notepad " + file);
    }

    public void loadExampleSolution(String group, String title) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        String file = exercises_path + group + "_" + title + ".txt";
        runtime.exec("notepad " + file);
    }



}
