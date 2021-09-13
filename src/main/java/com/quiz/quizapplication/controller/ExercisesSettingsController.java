package com.quiz.quizapplication.controller;

import com.quiz.quizapplication.LoadSolution;
import com.quiz.quizapplication.database.DataFromDb;
import com.quiz.quizapplication.scene.settingsScene.ExercisesSettings;
import java.io.IOException;
import java.sql.SQLException;

public class ExercisesSettingsController {

    DataFromDb dataFromDb = new DataFromDb();
    LoadSolution loadSolution = new LoadSolution();

    public ExercisesSettingsController() throws SQLException {
    }

    public boolean archiveAllExercises() {
        boolean archiveAllResult = false;
        boolean expected = dataFromDb.archiveAllExercises();
        if (expected) archiveAllResult = true;
        return archiveAllResult;
    }

    public boolean archiveChosenExercise() {
        boolean result = false;
        String title = DataFromDb.list.getSelectionModel().getSelectedItem();
        if (title == null) {

        } else {
            title = title.substring(6);
            dataFromDb.archiveExercisesFromSettings(title);
            result = true;
        }
        return result;
    }

    public boolean changeTitleOfExercise() {
        boolean result = false;
        String newTitleName = ExercisesSettings.titleTextField.getText();
        String idEx = DataFromDb.list.getSelectionModel().getSelectedItem();
        if (idEx != null) {
            idEx = idEx.substring(0, idEx.indexOf(" -"));
            try {
                dataFromDb.changeTitleName(idEx, newTitleName);
                result = true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ExercisesSettings.titleTextField.clear();
        } else {
            ExercisesSettings.titleTextField.setText("You need to choose an exercise above");
        }
        return result;
    }

    public void loadExampleSolution() {
        String idEx = DataFromDb.list.getSelectionModel().getSelectedItem();
        if (idEx != null) {
            idEx = idEx.substring(0, idEx.indexOf(" -"));
            try {
                loadSolution.loadExampleSolution(idEx);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
