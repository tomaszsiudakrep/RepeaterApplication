package com.quiz.quizapplication.controller;

import javafx.application.Platform;

public class Exit {

    public void endApplication() {
        System.exit(0);
        Platform.exit();
    }

}
