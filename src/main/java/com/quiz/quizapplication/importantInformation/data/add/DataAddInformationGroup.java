package com.quiz.quizapplication.importantInformation.data.add;

import com.quiz.quizapplication.database.ConnectToDb;
import com.quiz.quizapplication.importantInformation.objects.GroupInformation;
import com.quiz.quizapplication.importantInformation.scene.add.AddGroupInformationScene;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataAddInformationGroup {

    GroupInformation groupInformation;

    public String downloadGroupNameToAdd() {
        return AddGroupInformationScene.groupTextField.getText();
    }

    public String downloadNewGroupNameToChangeTitle() {
        return AddGroupInformationScene.newNameOfGroupTextField.getText();
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

    public boolean addGroup(GroupInformation groupInformation) {
        boolean addGroupResult = false;
        String sqlQuery = "INSERT INTO GROUP_IMPORTANT_INFORMATION(NAME, ARCHIVED) " +
                "VALUES ('" + groupInformation.getGroupName() + "','" + groupInformation.isArchived() + "')";
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
        String sqlQuery = "UPDATE GROUP_IMPORTANT_INFORMATION SET NAME = '" + newGroupName + "' WHERE NAME = '" + groupName + "'";
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

    public String downloadGroupNameFromChoiceBox() {
        return AddGroupInformationScene.choiceBox.getValue();
    }

    public List<String> createGroupList() throws SQLException {
        String sqlQuery = "SELECT * FROM GROUP_IMPORTANT_INFORMATION WHERE ARCHIVED = 0";
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
        String sqlQuery = "DELETE FROM GROUP_IMPORTANT_INFORMATION WHERE NAME = '" + groupName + "'";
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
        String sqlQuery = "SELECT * FROM GROUP_IMPORTANT_INFORMATION WHERE NAME = '" + groupName + "' and ARCHIVED = 0";
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

    public GroupInformation createGroupObject(String groupName) {
        return groupInformation = new GroupInformation(groupName);
    }

}
