package com.quiz.quizapplication.tasks.data.add;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataReminderChoiceBox {

    String hour1 = "1 hour before";
    String hour2 = "2 hours before";
    String hour4 = "4 hours before";
    String hour12 = "12 hours before";
    String hour24 = "24 hours before";

    public ObservableList<String> list;

    public ObservableList<String> observableList() {
        return list = FXCollections.observableArrayList(hour1, hour2, hour4, hour12, hour24);
    }
}
