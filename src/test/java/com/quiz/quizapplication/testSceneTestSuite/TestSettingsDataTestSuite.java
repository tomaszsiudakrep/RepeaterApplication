package com.quiz.quizapplication.testSceneTestSuite;

import com.quiz.quizapplication.repeat.testKnowledge.data.DataTestSettings;
import com.quiz.quizapplication.repeat.testKnowledge.scene.TestSettingsScene;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSettingsDataTestSuite {

    private DataTestSettings dataTestSettings;

    @BeforeEach
    public void initialize() {
        dataTestSettings = new DataTestSettings();
    }

    @Test
    void testPlusOne() {
        //Given
        TestSettingsScene.countOfExercises = 0;
        //When
        DataTestSettings.plusOne();
        //Then
        Assertions.assertEquals(1, TestSettingsScene.countOfExercises);
//        Assertions.assertEquals("1", TestSettingsScene.countOfExercisesToTestLabel);
    }
}
