package com.quiz.quizapplication.controller;

import com.quiz.quizapplication.database.GroupChoiceBox;
import javafx.collections.ObservableList;
import java.util.List;

public class GroupChoiceBoxController {

    GroupChoiceBox groupChoiceBox = new GroupChoiceBox();

    public ObservableList<String> create() {
        List<String> list = groupChoiceBox.createList();
        return groupChoiceBox.createObservableList(list);
    }
}
