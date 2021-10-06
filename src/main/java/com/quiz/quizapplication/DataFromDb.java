package com.quiz.quizapplication;

import com.quiz.quizapplication.exercises.objects.Exercises;
import com.quiz.quizapplication.data.file.LoadFileTxt;
import com.quiz.quizapplication.database.ConnectToDb;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataFromDb {

    private List<Integer> lists;
    private int counter = 0;
    public static ListView<String> list;

    public static int count;

    public void saveExercisesToDb(Exercises exercises, int id) {
        try {
            ConnectToDb connectToDb = ConnectToDb.getInstance();
            String sqlQuery = "INSERT INTO EXERCISES (TITLE, DESCRIPTION, ARCHIVED, GROUP_ID, TIME_DONE) " +
                    "VALUES ('" + exercises.getTitle() + "', '" + exercises.getDescription() + "', '" + exercises.isArchived() + "', " + id + "," + exercises.getBestResultTime() + ")";
            Statement statement = connectToDb.getConn().createStatement();
            statement.executeUpdate(sqlQuery);
            statement.close();
        } catch (SQLException e) {
            System.out.println("oops some things is wrong: " + e);
        }

    }

    public List<Integer> loadListWithExercisesId() throws SQLException {
        lists = new ArrayList<>();
        ConnectToDb connectToDb = ConnectToDb.getInstance();
        Statement statement = connectToDb.getConn().createStatement();
        String sqlQuery = "SELECT * FROM EXERCISES WHERE " + "  archived = 0";
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        while (resultSet.next()) {
            int varId = resultSet.getInt("ID");
            lists.add(varId);
        }
        resultSet.close();
        statement.close();
        return lists;
    }

    public List<Integer> loadListWithExercisesId2(String groupName) throws SQLException {
        lists = new ArrayList<>();
        String sqlQuery = "SELECT * FROM EXERCISES WHERE archived = 0";
        ConnectToDb connectToDb = ConnectToDb.getInstance();
        Statement statement = connectToDb.getConn().createStatement();
        if (groupName != null) sqlQuery = "SELECT * FROM EXERCISES WHERE " + "  archived = 0 and GROUP_ID = (SELECT ID FROM GROUP_EXERCISES WHERE NAME = '" + groupName + "')";
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        while (resultSet.next()) {
            int varId = resultSet.getInt("ID");
            lists.add(varId);
        }
        resultSet.close();
        statement.close();
        return lists;
    }

    public List<Integer> shuffleList() throws SQLException {
        loadListWithExercisesId();
        Collections.shuffle(lists);
        return lists;
    }

    public int allExercises() throws SQLException {
        int allEx = 0;
        String sqlQuery = "SELECT COUNT(ID) FROM EXERCISES WHERE ARCHIVED = 0";
        ConnectToDb connectToDb = ConnectToDb.getInstance();
        Statement statement = connectToDb.getConn().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        if (resultSet.next()) {
            allEx = resultSet.getInt(1);
        }
        resultSet.close();
        statement.close();
        return allEx;
    }

    public int firstElementFromDb() throws SQLException {
        int minId = 0;
        String sqlQuery = "SELECT MIN(ID) FROM EXERCISES WHERE ARCHIVED = 0";
        ConnectToDb connectToDb = ConnectToDb.getInstance();
        Statement statement = connectToDb.getConn().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        if (resultSet.next()) {
            minId = resultSet.getInt(1);
        }
        resultSet.close();
        statement.close();
        return minId;
    }

    public boolean archiveExercises(String id) {
        boolean result = false;
        if (id.length() > 0) {
            try {
                ConnectToDb connectToDb = ConnectToDb.getInstance();
                Statement statement = connectToDb.getConn().createStatement();
                String sqlQuery = "UPDATE EXERCISES SET ARCHIVED = 1 where id = " + id;
                statement.executeUpdate(sqlQuery);
                statement.close();
                result = true;
            } catch (SQLException e) {
                System.out.println("oops some things is wrong: " + e);
            }
        }
        return result;
    }

    public static void deleteAllGroupAndTasks() throws SQLException {
        String sqlDel = "DELETE FROM EXERCISES;\n DELETE FROM GROUP_EXERCISES;";
        ConnectToDb connectToDb = ConnectToDb.getInstance();
        Statement statement = connectToDb.getConn().createStatement();
        statement.executeUpdate(sqlDel);
    }

}
