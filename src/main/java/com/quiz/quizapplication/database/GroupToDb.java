package com.quiz.quizapplication.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GroupToDb {

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
//                    System.out.println(resultSet.getString("NAME"));
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
//                    System.out.println(result);
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

    public boolean archiveGroup(String groupName) throws SQLException {
        boolean result = false;
        try {
            String sqlArchive = "UPDATE GROUP_EXERCISES SET ARCHIVED = 1 WHERE name = '" + groupName + "'" ;
            ConnectToDb connectToDb = ConnectToDb.getInstance();
            Statement statement = connectToDb.getConn().createStatement();
            statement.executeUpdate(sqlArchive);
            result = true;
        } catch (SQLException e) {
            System.out.println("Ups.." + e);
        }
        return result;
    }

    public boolean changeGroupName(String groupName, String newGroupName) throws SQLException {
        boolean result = false;
                try {
                String sqlUpdate = "UPDATE GROUP_EXERCISES SET NAME = '" + newGroupName + "' where name = '" + groupName + "'";
                ConnectToDb connectToDb = ConnectToDb.getInstance();
                Statement statement = connectToDb.getConn().createStatement();
                statement.executeUpdate(sqlUpdate);
                result = true;
            } catch (SQLException e) {
                System.out.println("Ups.." + e);
            }
        return result;
    }
}
