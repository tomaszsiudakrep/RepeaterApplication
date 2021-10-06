package com.quiz.quizapplication.repeat.testKnowledge.data;

import com.quiz.quizapplication.database.ConnectToDb;
import com.quiz.quizapplication.DataFromDb;
import com.quiz.quizapplication.repeat.testKnowledge.scene.TestScene;
import com.quiz.quizapplication.repeat.testKnowledge.scene.TestSettingsScene;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class TestSettings {

    DataFromDb dataFromDb = new DataFromDb();

    public static void plusOne() {
        TestSettingsScene.countOfExercises++;
        TestSettingsScene.countOfExercisesToTestLabel.setText(TestSettingsScene.countOfExercises + "");
    }

    public static void minusOne() {
        TestSettingsScene.countOfExercises--;
        if (TestSettingsScene.countOfExercises < 1) TestSettingsScene.countOfExercises = 1;
        TestSettingsScene.countOfExercisesToTestLabel.setText(TestSettingsScene.countOfExercises + "");
    }


    public void createlist() throws SQLException {
        TestSettingsScene.listOfExercises =  dataFromDb.loadListWithExercisesId2(TestSettingsScene.groupName);
    }

    public void sizeOfList() throws SQLException {
        int size =  TestSettingsScene.listOfExercises.size();
        if (TestSettingsScene.countOfExercises > size) {
            TestSettingsScene.countOfExercises = size;
        }
    }

    public void randomExerciseFromList() {
        Random random = new Random();
        if (TestSettingsScene.listOfExercises.size() > 0) {
            int randomNum = random.nextInt(TestSettingsScene.listOfExercises.size());
            TestScene.randomNumberIdToDisplay = TestSettingsScene.listOfExercises.get(randomNum);
            TestSettingsScene.listOfExercises.remove(randomNum);
        }
    }

    public void displayExercises() throws SQLException {
        String sqlQuery = "SELECT * FROM EXERCISES WHERE ID = " + TestScene.randomNumberIdToDisplay + " and archived = 0";
        Statement statement = ConnectToDb.getInstance().getConn().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        while (resultSet.next()) {
            int id = resultSet.getInt("ID");
            TestScene.idTextField.setText(id + "");
            String title = resultSet.getString("TITLE");
            TestScene.titleTextField.setText(title);
            String description = resultSet.getString("DESCRIPTION");
            TestScene.descriptionAreaText.setText(description);
        }
        resultSet.close();
        statement.close();
    }


}
