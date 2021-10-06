package com.quiz.quizapplication.controller;

import com.quiz.quizapplication.CountdownTimer;
import com.quiz.quizapplication.exercises.data.GroupExToDb;
import com.quiz.quizapplication.repeat.testKnowledge.data.TestSettings;
import com.quiz.quizapplication.scene.repeatScene.TestSettingsScene;

import java.sql.SQLException;

public class TestRepeaterController {

    TestSettings testSettings = new TestSettings();
    GroupExToDb groupExToDb = new GroupExToDb();

    public void startTest() throws SQLException {
        testSettings.createlist();
        testSettings.sizeOfList();
        testSettings.randomExerciseFromList();
        testSettings.displayExercises();
        CountdownTimer.start();
    }

    public void nextRandomExercise() throws SQLException {
        testSettings.randomExerciseFromList();
        testSettings.displayExercises();
    }

    public boolean checkIfGroupIsEmpty() throws SQLException {
        return groupExToDb.countOfExInGroup(TestSettingsScene.groupName);
    }


}
