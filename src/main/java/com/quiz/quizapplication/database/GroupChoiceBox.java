package com.quiz.quizapplication.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GroupChoiceBox {

    public List<String> createList() {
        List<String> listOfGroupName = new ArrayList<>();
        String sql = "SELECT * FROM GROUP_EXERCISES WHERE ARCHIVED = 0";
        try {
            Statement statement = ConnectToDb.getInstance().getConn().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    String name = resultSet.getString("NAME");
                    listOfGroupName.add(name);
                }
            resultSet.close();
            statement.close();
        } catch (ExceptionInInitializerError | SQLException e) {
            System.out.println("Ups, something is an wrong: " + e);
        }
        return listOfGroupName;
    }

    public ObservableList<String> createObservableList(List<String> listOfGroupName) {
        return FXCollections.observableList(listOfGroupName);
    }
}
