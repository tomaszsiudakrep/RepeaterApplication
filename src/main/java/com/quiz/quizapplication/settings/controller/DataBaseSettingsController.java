package com.quiz.quizapplication.settings.controller;

import com.quiz.quizapplication.DataFromDb;
import com.quiz.quizapplication.settings.data.AlertDataBase;
import com.quiz.quizapplication.settings.data.DataDataBaseSettings;
import javafx.scene.control.ButtonType;

import java.sql.SQLException;

public class DataBaseSettingsController {

    DataDataBaseSettings dataDataBaseSettings = new DataDataBaseSettings();
    AlertDataBase alertDataBase = new AlertDataBase();

    public void createTestData() throws SQLException {
        AlertDataBase.dialogConfirmationGenerateTestData.showAndWait();
        if (AlertDataBase.dialogConfirmationGenerateTestData.getResult() == ButtonType.OK) {
            DataFromDb.deleteAllGroupAndTasks();
            dataDataBaseSettings.createGroup();
            dataDataBaseSettings.createExercises();
            alertDataBase.testDataHasBeenGenerated();
        }
        AlertDataBase.dialogInformationGenerateTestData.show();
    }

    public void cleanAllExercisesAndGroups() throws SQLException {
        AlertDataBase.dialogConfirmationClean.showAndWait();
        if (AlertDataBase.dialogConfirmationClean.getResult() == ButtonType.OK) {
            DataFromDb.deleteAllGroupAndTasks();
            alertDataBase.allDataHasBeenDeleted();
        }
        AlertDataBase.dialogInformationClean.show();
    }
}
