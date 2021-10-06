package com.quiz.quizapplication.exercises.data.exercises;

import com.quiz.quizapplication.database.ConnectToDb;
import com.quiz.quizapplication.exercises.scene.ownExercises.OwnExercisesScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataExercises {

    public String downloadChosenElementFromListView() {
        return OwnExercisesScene.listView.getSelectionModel().getSelectedItem();
    }

    public String downloadTitleFromChangeTitleTextField() {
        return OwnExercisesScene.changeTitleTextField.getText();
    }

    public String downloadNewGroupFromChoiceBox() {
        return OwnExercisesScene.changeGroupChoiceBox.getValue();
    }

    public long sizeOfListView() {
        return OwnExercisesScene.listView.getItems().size();
    }

    public List<String> createList(String sqlQuery) throws SQLException {
        List<String> list = new ArrayList<>();
        Statement statement = ConnectToDb.getInstance().getConn().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        while (resultSet.next()) {
            String title = resultSet.getString("TITLE");
            int id = resultSet.getInt("ID");
            list.add(id + "/" + title);
        }
        resultSet.close();
        statement.close();
        return list;
    }

    public ObservableList<String> observableList(List<String> list) {
        return FXCollections.observableList(list);
    }

    public boolean deleteExercise(int exerciseId) {
        boolean result = false;
        String sqlQuery = "DELETE FROM EXERCISES WHERE ID = " + exerciseId;
        try {
            Statement statement = ConnectToDb.getInstance().getConn().createStatement();
            statement.executeUpdate(sqlQuery);
            result = true;
        } catch (SQLException e) {
            System.out.println("Wrong: " + e);
        }
        return result;
    }

    public boolean deleteAllExercises() {
        boolean result = false;
        String sqlQuery = "DELETE FROM EXERCISES";
        try {
            Statement statement = ConnectToDb.getInstance().getConn().createStatement();
            statement.executeUpdate(sqlQuery);
            result = true;
        } catch (SQLException e) {
            System.out.println("Wrong: " + e);
        }
        return result;
    }

    public int returnIdInformationFromListViewItem(String listViewItem) {
        String varId = listViewItem.substring(0, listViewItem.indexOf("/"));
        return Integer.parseInt(varId);
    }

    public String returnTitleInformationFromListViewItem(String listViewItem) {
        return listViewItem.substring(listViewItem.indexOf("/")+1);
    }

    public int returnGroupIdFromTableInformation(int exercisesId) {
        int groupId = 0;
        String sqlQuery = "SELECT GROUP_ID FROM EXERCISES WHERE ID = " + exercisesId;
        try {
            Statement statement = ConnectToDb.getInstance().getConn().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            resultSet.next();
            groupId = resultSet.getInt("GROUP_ID");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groupId;
    }

    public boolean checkIfNewTitleExist(int groupId, String newTitle) {
        boolean result = false;
        int counter = 0;
        String sqlQuery = "SELECT * FROM EXERCISES WHERE TITLE = '" + newTitle + "' AND GROUP_ID = " + groupId;
        try {
            Statement statement = ConnectToDb.getInstance().getConn().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                counter++;
            }
            if (counter > 0) result = true;
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean updateTitle(String newTitle, int exercisesId) {
        boolean result = false;
        String sqlQuery = "UPDATE EXERCISES SET TITLE = '" + newTitle + "' WHERE ID = " + exercisesId;
        try {
            Statement statement = ConnectToDb.getInstance().getConn().createStatement();
            statement.executeUpdate(sqlQuery);
            result = true;
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean changeGroup(int newGroupId, int exercisesId) {
        boolean result = false;
        String sqlQuery = "UPDATE EXERCISES SET GROUP_ID = " + newGroupId + " WHERE ID = " + exercisesId;
        try {
            Statement statement = ConnectToDb.getInstance().getConn().createStatement();
            statement.executeUpdate(sqlQuery);
            result = true;
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int returnGroupIdFromTableGroup(String groupName) {
        int groupId = 0;
        String sqlQuery = "SELECT ID FROM GROUP_EXERCISES WHERE NAME = '" + groupName + "'";
        try {
            Statement statement = ConnectToDb.getInstance().getConn().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            resultSet.next();
            groupId = resultSet.getInt("ID");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groupId;
    }


}
