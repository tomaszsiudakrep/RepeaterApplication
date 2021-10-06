package com.quiz.quizapplication.exercises.data.add;

import com.quiz.quizapplication.database.ConnectToDb;
import com.quiz.quizapplication.exercises.objects.GroupExercises;
import com.quiz.quizapplication.exercises.scene.add.AddGroupExercisesScene;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataAddExercisesGroup {

    GroupExercises groupExercises;

    public GroupExercises createGroupExercisesObject(String groupName) {
        return groupExercises = new GroupExercises(groupName);
    }

    public String downloadGroupNameFromChoiceBox() {
        return AddGroupExercisesScene.choiceBoxNew.getValue();
    }

    public String downloadGroupNameToAdd() {
        return AddGroupExercisesScene.groupTextField.getText();
    }

    public String downloadNewGroupNameToChangeTitle() {
        return AddGroupExercisesScene.newNameOfGroupTextField.getText();
    }

    public boolean checkIfGroupNameIsNotNull(String groupName) {
        boolean result = false;
        if (!groupName.equals("")) {
            result = true;
        }
        return result;
    }

    public boolean checkIfGroupNameNotExist(String groupName) throws SQLException {
        boolean result = false;
        String sqlQuery = "SELECT * FROM GROUP_IMPORTANT_INFORMATION WHERE NAME = '" + groupName + "' and ARCHIVED = 0";
        int counter = 0;
        Statement statement = ConnectToDb.getInstance().getConn().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        while (resultSet.next()) {
            counter++;
        }
        if (counter == 0) result = true;
        resultSet.close();
        statement.close();
        return result;
    }

    public boolean addGroup(GroupExercises groupExercises) {
        boolean addGroupResult = false;
        String sqlQuery = "INSERT INTO GROUP_IMPORTANT_INFORMATION(NAME, ARCHIVED) " +
                "VALUES ('" + groupExercises.getGroupName() + "','" + groupExercises.isArchived() + "')";
        try {
            Statement statement = ConnectToDb.getInstance().getConn().createStatement();
            statement.executeUpdate(sqlQuery);
            statement.close();
            addGroupResult = true;
        } catch (SQLException e) {
            System.out.println("Wrong: " + e);
        }
        return addGroupResult;
    }

    public boolean changeGroupName(String newGroupName, String groupName) throws SQLException {
        boolean result = false;
        String sqlQuery = "UPDATE GROUP_EXERCISES SET NAME = '" + newGroupName + "' WHERE NAME = '" + groupName + "'";
        Statement statement = ConnectToDb.getInstance().getConn().createStatement();
        try {
            statement.executeUpdate(sqlQuery);
            result = true;

        } catch (SQLException e) {
            System.out.println("Wrong: " + e);
        }
        statement.close();
        return result;

    }

    public List<String> createGroupList(String sqlQuery) throws SQLException {
        List<String> list = new ArrayList<>();
        Statement statement = ConnectToDb.getInstance().getConn().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        while (resultSet.next()) {
            String groupName = resultSet.getString("NAME");
            list.add(groupName);
        }
        resultSet.close();
        statement.close();
        return list;
    }

    public boolean deleteGroup(String groupName) {
        boolean result = false;
        String sqlQuery = "DELETE FROM GROUP_EXERCISES WHERE NAME = '" + groupName + "'";
        try {
            Statement statement = ConnectToDb.getInstance().getConn().createStatement();
            statement.executeUpdate(sqlQuery);
            statement.close();
            result = true;
        } catch (SQLException e) {
            System.out.println("Wrong: " + e);
        }
        return result;
    }

    public int checkGroupId(String groupName) {
        int id = 0;
        String sqlQuery = "SELECT * FROM GROUP_EXERCISES WHERE NAME = '" + groupName + "' and ARCHIVED = 0";
        try {
            Statement statement = ConnectToDb.getInstance().getConn().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                id = resultSet.getInt("ID");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Wrong: " + e);
        }
        return id;
    }
}
