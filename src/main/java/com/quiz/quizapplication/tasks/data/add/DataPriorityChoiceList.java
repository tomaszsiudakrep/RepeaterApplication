package com.quiz.quizapplication.tasks.data.add;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataPriorityChoiceList {

    String low = "Low";
    String medium = "Medium";
    String high = "High";

    public ObservableList<String> list;

    public ObservableList<String> createObservableList() {
        return list = FXCollections.observableArrayList(low, medium, high);
    }
}
