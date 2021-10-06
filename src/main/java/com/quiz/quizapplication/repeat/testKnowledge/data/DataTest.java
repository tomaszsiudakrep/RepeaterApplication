package com.quiz.quizapplication.repeat.testKnowledge.data;

import com.quiz.quizapplication.repeat.testKnowledge.scene.TestScene;
import com.quiz.quizapplication.repeat.testKnowledge.scene.TestSettingsScene;

import java.sql.SQLException;

public class DataTest {

    DataTestSettings dataTestSettings = new DataTestSettings();

    public void counterPlusPlus() {
        TestScene.counter++;
    }

    public void setTextInLabel() {
        TestScene.exerciseCounterLabel.setText(TestScene.counter + "/" + TestSettingsScene.countOfExercises);
    }

    public void nextRandomExercise() throws SQLException {
        dataTestSettings.randomExerciseFromList();
        dataTestSettings.displayExercises();
    }

    public boolean checkIfCounterEqualCountOfExercises() {
        boolean result = false;
        if (TestScene.counter == TestSettingsScene.countOfExercises) result = true;
        return result;
    }

}
