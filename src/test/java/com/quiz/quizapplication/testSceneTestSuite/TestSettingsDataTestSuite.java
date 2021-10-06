package com.quiz.quizapplication.testSceneTestSuite;

import com.quiz.quizapplication.repeat.testKnowledge.data.TestSettings;
import com.quiz.quizapplication.repeat.testKnowledge.scene.TestSettingsScene;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSettingsTestSuite {

    private TestSettings testSettings;

    @BeforeEach
    public void initialize() {
        testSettings = new TestSettings();
    }

    @Test
    void testPlusOne() {
        //Given
        TestSettingsScene.countOfExercises = 0;
        //When
        TestSettings.plusOne();
        //Then
        Assertions.assertEquals(1, TestSettingsScene.countOfExercises);
//        Assertions.assertEquals("1", TestSettingsScene.countOfExercisesToTestLabel);
    }
}
