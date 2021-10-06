package com.quiz.quizapplication.exercises.data.add;

import com.quiz.quizapplication.database.ConnectToDb;
import com.quiz.quizapplication.exercises.objects.Exercises;
import com.quiz.quizapplication.exercises.scene.add.AddExercisesScene;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAddExercises {

    Exercises exercises;

    public Exercises createExercisesObject(String title, String description) {
        return exercises = new Exercises(title, description);
    }

    public String downloadGroupFromChoiceBox() {
        return AddExercisesScene.groupChoiceBox.getValue();
    }

    public String downloadDescription() {
        return AddExercisesScene.descriptionTextArea.getText();
    }

    public String downloadTitle() {
        return AddExercisesScene.titleTextField.getText();
    }

    public void clearTextField() {
        AddExercisesScene.titleTextField.clear();
        AddExercisesScene.descriptionTextArea.clear();
    }

    public boolean addObject(int groupId, Exercises exercises) {
        boolean addResult = false;
        String sqlQuery = "INSERT INTO EXERCISES (TITLE, DESCRIPTION, ARCHIVED, GROUP_ID, TIME_DONE) VALUES "+
                "('" + exercises.getTitle()   + "', '" + exercises.getDescription() + "', '"
                + exercises.isArchived() + "'," + groupId + ","
                + exercises.getBestResultTime() + ")";
        try {
            Statement statement = ConnectToDb.getInstance().getConn().createStatement();
            statement.executeUpdate(sqlQuery);
            statement.close();
            addResult = true;
        } catch (SQLException e) {
            System.out.println("Wrong: " + e);
        }
        return addResult;
    }

    public boolean checkIfObjectAlreadyExistInGroup(String title, int groupId) {
        boolean result = false;
        String sqlQuery = "SELECT * FROM EXERCISES WHERE TITLE = '" + title + "' AND GROUP_ID =" + groupId;
        int counter = 0;
        try {
            Statement statement = ConnectToDb.getInstance().getConn().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                counter++;
            }
            if (counter > 0) result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
