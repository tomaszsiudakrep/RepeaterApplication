package com.quiz.quizapplication.controller;

import com.quiz.quizapplication.repeat.testKnowledge.scene.TestSettingsScene;

public class CountdownTimerController {

        public  int convertTime() {
        String time = TestSettingsScene.countOfTimeToTestLabel.getText();
        int elapsedTime = Integer.parseInt(time);
        return elapsedTime * 1000 * 60;
    }

    public int getElapsedTime() {
        return TestSettingsScene.time * 1000 * 60;
    }
}
