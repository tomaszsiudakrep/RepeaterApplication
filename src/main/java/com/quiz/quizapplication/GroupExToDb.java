package com.quiz.quizapplication.repeat;

import com.quiz.quizapplication.database.ConnectToDb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GroupExToDb {

    public boolean addGroup(String name) throws SQLException {
        boolean result = false;
        try {
            String sqlQuery = "INSERT INTO GROUP_EXERCISES(NAME, ARCHIVED) VALUES ('" + name + "', 0)";
            ConnectToDb connectToDb = ConnectToDb.getInstance();
            Statement statement = connectToDb.getConn().createStatement();
            statement.executeUpdate(sqlQuery);
            statement.close();
            result = true;
        } catch (SQLException e) {
            System.out.println("Some things is wrong: " + e);
        }
        return result;
    }

    public boolean checkNameGroup(String name) throws SQLException {
        boolean result = false;
        try {
            String sql = "SELECT * FROM GROUP_EXERCISES WHERE ARCHIVED = 0";
            ConnectToDb connectToDb = ConnectToDb.getInstance();
            Statement statement = connectToDb.getConn().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                if (resultSet.getString("NAME").equals(name)) {
                    result = true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Some things is wrong: " + e);
        }
        return result;
    }

    public int checkId(String name) throws SQLException {
        ConnectToDb connectToDb = ConnectToDb.getInstance();
        Statement statement = connectToDb.getConn().createStatement();
        int result = 0;
        if (name != null) {
            try {
                String sqlQuery = "SELECT * FROM GROUP_EXERCISES WHERE NAME = '" + name + "'";
                ResultSet resultSet = statement.executeQuery(sqlQuery);
                while (resultSet.next()) {
                    result = resultSet.getInt("ID");
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return result;
    }

    public String checkGroupName(int id) throws SQLException {
        String result = "";
        ConnectToDb connectToDb = ConnectToDb.getInstance();
        Statement statement = connectToDb.getConn().createStatement();
        String sqlQuery = "SELECT * FROM GROUP_EXERCISES";
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        while (resultSet.next()) {
            if (resultSet.getInt(1) == id) {
                result = resultSet.getString(2);
            }
        }
        return result;
    }

    public boolean countOfExInGroup(String groupName) throws SQLException {
        boolean result = true;
        int size = 0;
        String sqlQuery = "SELECT * FROM EXERCISES WHERE GROUP_ID = (Select ID from GROUP_EXERCISES where name = '" + groupName + "') and archived = 0";
        Statement statement = ConnectToDb.getInstance().getConn().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        while (resultSet.next()) {
            size++;
        }
        if (size > 0) result = false;
        return result;
    }

}
