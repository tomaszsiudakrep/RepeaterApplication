package com.quiz.quizapplication;

import java.io.*;

public class LoadSolution {

public static String IMG_PATH = "E:\\gibon\\Desktop\\Repositorium\\QuizApplication\\src\\main\\resources\\solutions\\ex";

    public void loadExampleSolution(String exercisesId) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        String file = IMG_PATH + exercisesId + ".txt";
        runtime.exec("notepad " + file);
    }

}
