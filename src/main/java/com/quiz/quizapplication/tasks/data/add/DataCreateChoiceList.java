package com.quiz.quizapplication.tasks.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class DataCreateChoiceList {

    String toDoList = "To do";
    String inProgressList = "In progress";
    String doneList = "Done";

    public ObservableList<String> list;

    public ObservableList<String> createObservableList() {
        return list = FXCollections.observableArrayList(toDoList, inProgressList, doneList);
    }

}
