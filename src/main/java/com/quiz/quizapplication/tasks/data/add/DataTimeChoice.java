package com.quiz.quizapplication.tasks.data.add;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataTimeChoice {

    public ObservableList<Integer> listHours;
    public ObservableList<Integer> listMinutes;

    public ObservableList<Integer> createObservableListOfHours() {
        return listHours = FXCollections.observableArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23);
    }

    public ObservableList<Integer> createObservableListOfMinutes() {
        return listMinutes = FXCollections.observableArrayList(00, 15, 30, 45);
    }

}
