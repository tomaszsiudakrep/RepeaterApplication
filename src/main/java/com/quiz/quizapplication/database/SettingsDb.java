package com.quiz.quizapplication.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SettingsDb {

    public Statement createStatement() throws SQLException {
        ConnectToDb connectToDb = ConnectToDb.getInstance();
        Statement statement = connectToDb.getConn().createStatement();
        return statement;
    }

    public int convertToBit(boolean result) {
        int n = 0;
        if (result) {
            n = 1;
        }
        return n;
    }

    public void insertSettings(Statement statement, int result) throws SQLException {
        String sqlQuery = "INSERT INTO SETTINGS(NAME, VALUE) VALUES( 'RandomRepeat', " + result + ")";
        statement.executeUpdate(sqlQuery);
        statement.close();
    }

    public int sumRandomRepeatSettings(Statement statement) throws SQLException {
        int count = 0;
        String sqlQuery = "SELECT * FROM SETTINGS WHERE NAME = 'RandomRepeat'";
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        while (resultSet.next()) {
            count++;
        }
        return count;
    }

    public int idRandomRepeatSetting(Statement statement) throws SQLException {
        String sqlQuery = "SELECT * FROM SETTINGS WHERE NAME = 'RandomRepeat'";
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        resultSet.next();
        int id = resultSet.getInt("id");
        return id;
    }

    public int valueOfRandomSettings(Statement statement, int id) throws SQLException {
        String sqlQuery = "SELECT * FROM SETTINGS WHERE id = " + id;
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        resultSet.next();
        int value = resultSet.getInt("id");
        return value;
    }

    public void updateSettings(Statement statement, boolean result) throws SQLException {
        String sqlQuery = "UPDATE SETTINGS SET VALUE = " + result;
        statement.executeUpdate(sqlQuery);
    }
}
