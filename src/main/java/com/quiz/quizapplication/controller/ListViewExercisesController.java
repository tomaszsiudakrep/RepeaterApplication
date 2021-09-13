package com.quiz.quizapplication.controller;

import com.quiz.quizapplication.database.ListOfExercisesListView;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class ListViewExercisesController {

    ListOfExercisesListView listOfExercisesListView = new ListOfExercisesListView();

    public int countSizeOfListView() throws SQLException {
        ObservableList<String> listOfExercises = listOfExercisesListView.createList();
        return listOfExercises.size();
    }
}
