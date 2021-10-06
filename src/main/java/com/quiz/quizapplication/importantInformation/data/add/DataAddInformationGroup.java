package com.quiz.quizapplication.importantInformation.data.add;

import com.quiz.quizapplication.database.ConnectToDb;
import com.quiz.quizapplication.importantInformation.objects.GroupInformation;
import com.quiz.quizapplication.importantInformation.scene.add.AddGroupInformationScene;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataAddGroup {

    GroupInformation groupInformation;

    public String sqlQuerySelectAllFromGroupWhereName(String groupName) {
        return "SELECT * FROM GROUP_IMPORTANT_INFORMATION WHERE NAME = '" + groupName + "' and ARCHIVED = 0";
    }

    public String sqlQueryAddGroup() {
        return  "INSERT INTO GROUP_IMPORTANT_INFORMATION(NAME, ARCHIVED) " +
                "VALUES ('" + groupInformation.getGroupName() + "','" + groupInformation.isArchived() + "')";
    }

    public String sqlQueryUpdateGroupName(String newGroupName, String groupName) {
        return "UPDATE GROUP_IMPORTANT_INFORMATION SET NAME = '" + newGroupName + "' WHERE NAME = '" + groupName + "'";
    }

    public String sqlQuerySelectAllFromGroup() {
        return "SELECT * FROM GROUP_IMPORTANT_INFORMATION WHERE ARCHIVED = 0";
    }

    public String sqlQueryDeleteGroup(String groupName) {
        return "DELETE FROM GROUP_IMPORTANT_INFORMATION WHERE NAME = '" + groupName + "'";
    }

    public String downloadGroupNameToAdd() {
        return AddGroupInformationScene.groupTextField.getText();
    }

    public String downloadNewGroupNameToChangeTitle() {
        return AddGroupInformationScene.newNameOfGroupTextField.getText();
    }

    public GroupInformation createGroupObject(String groupName) {
        return groupInformation = new GroupInformation(groupName);
    }

    public boolean checkIfGroupNameIsNotNull() {
        boolean result = false;
        String groupName = downloadGroupNameToAdd();
        if (!groupName.equals("")) {
            result = true;
        }
        return result;
    }

    public boolean checkIfGroupNameNotExist(String sqlQuery) throws SQLException {
        boolean result = false;
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

    public boolean addGroup() {
        boolean addGroupResult = false;
        try {
            Statement statement = ConnectToDb.getInstance().getConn().createStatement();
                statement.executeUpdate(sqlQueryAddGroup());
                statement.close();
            addGroupResult = true;
        } catch (SQLException e) {
            System.out.println("Wrong: " + e);
        }
        return addGroupResult;
    }

    public boolean changeGroupName(String sqlQuery) throws SQLException {
        boolean result = false;
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
        List<String> list = new ArrayList<>();
        Statement statement = ConnectToDb.getInstance().getConn().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuerySelectAllFromGroup());
            while (resultSet.next()) {
                String groupName = resultSet.getString("NAME");
                list.add(groupName);
            }
        resultSet.close();
        statement.close();
        return list;
    }

    public boolean deleteGroup(String sqlQuery) {
        boolean result = false;
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

    public int checkGroupId(String group) {
        int id = 0;
        try {
            Statement statement = ConnectToDb.getInstance().getConn().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuerySelectAllFromGroupWhereName(group));
                while (resultSet.next()) {
                    id = resultSet.getInt("ID");
                }
        } catch (SQLException e) {
            System.out.println("Wrong: " + e);
        }
        return id;
    }
}
