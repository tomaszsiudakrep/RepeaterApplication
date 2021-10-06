package com.quiz.quizapplication.repeat.commonRepeat.data;

import com.quiz.quizapplication.database.ConnectToDb;
import com.quiz.quizapplication.repeat.ChooseRepeatScene;
import com.quiz.quizapplication.repeat.commonRepeat.scene.RepeatScene;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataCommonRepeat {

    List<Integer> listOfExercises = new ArrayList<>();
    DataSaveTime dataSaveTime = new DataSaveTime();

    public String downloadChosenGroupFromChoiceBox() {
        return ChooseRepeatScene.groupChoiceBox.getValue();
    }

    public List<Integer> createListWithExercisesId(String sqlQuery) throws SQLException {
        Statement statement = ConnectToDb.getInstance().getConn().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                int exercisesId = resultSet.getInt("ID");
                listOfExercises.add(exercisesId);
            }
            resultSet.close();
            statement.close();
        return listOfExercises;
    }

    public void createFinallyList(List<Integer> list) {
        ChooseRepeatScene.listToCommonRepeat = list;
    }

    public void shuffleList(List<Integer> list) {
        Collections.shuffle(list);
    }

    public void showMeExercisesById(String sqlQuery) throws SQLException {
        Statement statement = ConnectToDb.getInstance().getConn().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                String description = resultSet.getString("DESCRIPTION");
                String title = resultSet.getString("TITLE");
                int id = resultSet.getInt("ID");
                int elapsedTime = resultSet.getInt("TIME_DONE");
                    String timeToShow = dataSaveTime.convertElapsedTimeToString(elapsedTime);
                RepeatScene.idTextField.setText(id + "");
                RepeatScene.titleTextField.setText(title);
                RepeatScene.descriptionAreaText.setText(description);
                RepeatScene.bestResultLabel.setText("BEST RESULT " + timeToShow);
            }
            resultSet.close();
            statement.close();
    }

    public void initializeFieldsToEmpty() {
        RepeatScene.titleTextField.clear();
        RepeatScene.idTextField.clear();
        RepeatScene.descriptionAreaText.clear();
    }

    public String checkIfIdIsShowing() {
        return RepeatScene.idTextField.getText();
    }

}
