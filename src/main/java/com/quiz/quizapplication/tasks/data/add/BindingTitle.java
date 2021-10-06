package com.quiz.quizapplication.tasks.data.add;

import com.quiz.quizapplication.tasks.scene.AddTasksScene;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;

public class BindingTitle {

    public StringBinding binding = Bindings.createStringBinding(() -> {
        int characterCount = 0;
        if (AddTasksScene.titleTextField.getText() != null) {
            characterCount = AddTasksScene.titleTextField.getText().length();
        }
        if (characterCount > 0) AddTasksScene.saveButton.setDisable(false);
        if (characterCount == 0) AddTasksScene.saveButton.setDisable(true);

        return "Title:";
    }, AddTasksScene.titleTextField.textProperty());

    public BindingTitle() {
        AddTasksScene.titleLabel.textProperty().bind(binding);
    }
}
