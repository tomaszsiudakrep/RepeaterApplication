package com.quiz.quizapplication.database;

import com.quiz.quizapplication.Exercises;
import com.quiz.quizapplication.LoadSolution;
import com.sun.javafx.collections.ObservableListWrapper;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
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
    private MenuItem showDescriptionMenuItem;
    private MenuItem showSolutionMenuItem;
    LoadSolution loadSolution = new LoadSolution();
    public static int count;

    public void saveExercisesToDb(Exercises exercises, int id) {
        try {
            ConnectToDb connectToDb = ConnectToDb.getInstance();
            String sqlQuery = "INSERT INTO EXERCISES (TITLE, DESCRIPTION, ARCHIVED, GROUP_ID, TIME_DONE) " +
                    "VALUES ('" + exercises.getTitleTask() + "', '" + exercises.getDescriptionTask() + "', '" + exercises.isArchivedTask() + "', " + id + "," + exercises.getBestResultTime() + ")";
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

    public boolean archiveExercisesFromSettings(String title) {
        boolean result = false;
            try {
                ConnectToDb connectToDb = ConnectToDb.getInstance();
                Statement statement = connectToDb.getConn().createStatement();
                String sqlQuery = "UPDATE EXERCISES SET ARCHIVED = 1 where title = '" + title + "'";
                statement.executeUpdate(sqlQuery);
                statement.close();
                result = true;
            } catch (SQLException e) {
                System.out.println("oops some things is wrong: " + e);
            }
        return result;
    }

    public void listExercises() throws SQLException {
        ContextMenu listExContextMenu = new ContextMenu();
        showDescriptionMenuItem = new MenuItem("Show description");
        showSolutionMenuItem = new MenuItem("Show solution");
        list = new ListView<>();
        listExContextMenu.getItems().add(0, showDescriptionMenuItem);
        listExContextMenu.getItems().add(1, showSolutionMenuItem);
        list.setContextMenu(listExContextMenu);


        String sqlSelect = "SELECT * FROM EXERCISES WHERE ARCHIVED = 0";
        ConnectToDb connectToDb = ConnectToDb.getInstance();
        Statement statement = connectToDb.getConn().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlSelect);
        while (resultSet.next()) {
            String title = resultSet.getString("TITLE");
            int id = resultSet.getInt("ID");
            list.getItems().add(id + " - " + title);
        }
    }

    public int countExercises() throws SQLException {
        ConnectToDb connectToDb = ConnectToDb.getInstance();
        Statement statement = connectToDb.getConn().createStatement();
        String sqlCount = "select count(id) from EXERCISES where ARCHIVED = 0";
        ResultSet resultSet = statement.executeQuery(sqlCount);
        resultSet.next();
        int count = resultSet.getInt(1);
        return count;
    }

    public boolean archiveAllExercises() {
        boolean result = false;
            try {
                ConnectToDb connectToDb = ConnectToDb.getInstance();
                Statement statement = connectToDb.getConn().createStatement();
                String sqlQuery = "UPDATE EXERCISES SET ARCHIVED = 1 ";
                statement.executeUpdate(sqlQuery);
                statement.close();
                result = true;
            } catch (SQLException e) {
                System.out.println("oops some things is wrong: " + e);
            }
        return result;
    }

    public boolean changeTitleName(String id, String newTitleName) throws SQLException {
        boolean result = false;
        try {
            String sqlUpdateTitle = "UPDATE EXERCISES SET title = '" + newTitleName + "' where id = " + id;
            ConnectToDb connectToDb = ConnectToDb.getInstance();
            Statement statement = connectToDb.getConn().createStatement();
            statement.executeUpdate(sqlUpdateTitle);
            result = true;
        } catch (SQLException e) {
            System.out.println("Somethings is wrong.." + e);
        }
        return result;
    }

    public static void deleteAllGroupAndTasks() throws SQLException {
        String sqlDel = "DELETE FROM EXERCISES;\n DELETE FROM GROUP_EXERCISES;";
        ConnectToDb connectToDb = ConnectToDb.getInstance();
        Statement statement = connectToDb.getConn().createStatement();
        statement.executeUpdate(sqlDel);
    }

    public String returnId() {
        String idEx = DataFromDb.list.getSelectionModel().getSelectedItem();
        idEx = idEx.substring(0, idEx.indexOf(" -"));
        return idEx;
    }

    public void showDescriptionFromList(String id) throws IOException {
        showSolutionMenuItem.setOnAction(event -> {
            try {
                loadSolution.loadExampleSolution(id);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });

    }

}
