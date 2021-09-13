package com.quiz.quizapplication.controller;

import com.quiz.quizapplication.LoadSolution;
import com.quiz.quizapplication.TimerCommon;
import com.quiz.quizapplication.database.DataFromDb;
import com.quiz.quizapplication.database.SaveAndLoadBestResultTime;
import com.quiz.quizapplication.scene.repeatScene.RepeatScene;

import java.io.IOException;
import java.sql.SQLException;

public class RepeatSceneController {

    SaveAndLoadBestResultTime saveAndLoadBestResultTime = new SaveAndLoadBestResultTime();
    DataFromDb dataFromDb = new DataFromDb();
    CreateLog createLog = new CreateLog();
    LoadSolution loadSolution = new LoadSolution();

    public RepeatSceneController() throws SQLException {
    }

    public void saveTime() {
        String idExe = RepeatScene.idTextField.getText();
        int elapsedTime = TimerCommon.elapsedTime;
        try {
            saveAndLoadBestResultTime.saveTimeResult(elapsedTime, idExe);
            RepeatScene.bestResultLabel.setText("BEST RESULT " + saveAndLoadBestResultTime.convertElapsedTimeToString(elapsedTime));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean archiveExercise() throws IOException {
        boolean archiveResult = false;
        try {
            String id = RepeatScene.idTextField.getText();
            dataFromDb.archiveExercises(id);
            archiveResult = true;
        }  catch (Exception e) {
            System.out.println("Something is wrong: " + e);
            createLog.logException("RepeatSceneControllerLog", e);
        }
        return archiveResult;
    }

    public void exampleSolution() {
        String id = RepeatScene.idTextField.getText();
        try {
            loadSolution.loadExampleSolution(id);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}
