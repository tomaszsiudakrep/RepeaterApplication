package com.quiz.quizapplication.importantInformation.data;

import com.quiz.quizapplication.database.ConnectToDb;
import com.quiz.quizapplication.importantInformation.GroupInformation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GroupDataBase {

    public boolean addGroup(GroupInformation groupInformation) {
        boolean addGroupResult = false;
        String sqlAddGroup = "INSERT INTO GROUP_IMPORTANTINFORMATION(NAME, ARCHIVED) " +
                             "VALUES ('" + groupInformation.getGroupName() + "','" + groupInformation.isArchived() + "')";
        try {
            Statement statement = ConnectToDb.getInstance().getConn().createStatement();
            statement.executeUpdate(sqlAddGroup);
            statement.close();
            addGroupResult = true;
        } catch (SQLException e) {
            System.out.println("Wrong: " + e);
        }
        return addGroupResult;
    }

    public int checkGroupId(String nameOfGroup) {
        int resultId = 0;
        String sqlSelectId = "SELECT * FROM GROUP_IMPORTANTINFORMATION WHERE NAME = '" + nameOfGroup + "'";
        try {
            Statement statement = ConnectToDb.getInstance().getConn().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelectId);
            resultSet.next();
            resultId = resultSet.getInt("ID");
        } catch (SQLException e) {
            System.out.println("Wrong: " + e);
        }
        return resultId;
    }

    public boolean checkIfGroupExist(String groupName) {
        boolean duplicateResult = false;
        int counter = 0;
        String sqlSelectName = "SELECT * FROM GROUP_IMPORTANTINFORMATION WHERE NAME = '" +  groupName + "'";
        try {
            Statement statement = ConnectToDb.getInstance().getConn().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelectName);
            while (resultSet.next()) {
                counter++;
            }
                if (counter > 0) {
                    duplicateResult = true;
                }
        } catch (SQLException e) {
            System.out.println("Wrong: " + e);
        }
        return duplicateResult;
    }
}
