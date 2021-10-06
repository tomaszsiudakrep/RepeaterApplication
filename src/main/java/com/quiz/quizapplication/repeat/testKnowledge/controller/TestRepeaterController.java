package com.quiz.quizapplication.repeat.testKnowledge.controller;

import com.quiz.quizapplication.data.timers.CountdownTimer;
import com.quiz.quizapplication.repeat.testKnowledge.data.DataTest;
import com.quiz.quizapplication.repeat.testKnowledge.data.DataTestSettings;
import com.quiz.quizapplication.repeat.testKnowledge.scene.TestScene;
import java.sql.SQLException;

public class TestRepeaterController {

    DataTestSettings dataTestSettings = new DataTestSettings();
    DataTest dataTest = new DataTest();

    public void startTest() throws SQLException {
        dataTestSettings.createList();
        dataTestSettings.sizeOfList();
        dataTestSettings.randomExerciseFromList();
        dataTestSettings.displayExercises();
        CountdownTimer.start();
    }

    public boolean checkIfGroupIsEmpty() throws SQLException {
        String groupName = dataTestSettings.downloadGroupName();
        return dataTestSettings.countOfExInGroup(groupName);
    }

    public void nextRandomExercise() throws SQLException {
        dataTest.counterPlusPlus();
        dataTest.setTextInLabel();
        dataTest.nextRandomExercise();
        boolean result = dataTest.checkIfCounterEqualCountOfExercises();
        if (result) TestScene.nextExercisesButton.setDisable(true);
    }

    public void initializeCounter() {
        TestScene.counter = 1;
    }

}
