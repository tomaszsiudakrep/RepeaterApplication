package com.quiz.quizapplication.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public enum ConnectToDb {

    INSTANCE;

    private Connection conn;

    ConnectToDb() {
        Properties connectionProps = new Properties();
        connectionProps.put("user", "sa");
        connectionProps.put("password", "BrakHaslaDoTejBazy");
        String dbURL = "jdbc:sqlserver://TOM\\SQL_SIUDAK;database=RepeatExercises";

        try {
            conn = DriverManager.getConnection(dbURL, connectionProps);
        } catch (SQLException e) {
            System.out.println("Oops, there is an error: " + e);
        }
    }

    public static ConnectToDb getInstance() {
        return INSTANCE;
    }

    public Connection getConn() {
        return conn;
    }

}
