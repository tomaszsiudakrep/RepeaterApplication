package com.quiz.quizapplication.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListOfExercisesListView {

    public ObservableList<String> createList() throws SQLException {
        ObservableList<String> observableList = FXCollections.observableArrayList();
        String sqlSelect = "SELECT * FROM EXERCISES WHERE ARCHIVED = 0";
        Statement statement = ConnectToDb.getInstance().getConn().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlSelect);
            while (resultSet.next()) {
                String title = resultSet.getString("TITLE");
                int id = resultSet.getInt("ID");
                observableList.add(id + " - " + title);
            }
        return observableList;
    }
}
