package com.quiz.quizapplication.exercises.data.add;

import com.quiz.quizapplication.exercises.scene.add.AddExercisesScene;
import com.quiz.quizapplication.importantInformation.scene.add.AddInformationScene;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;

public class BindingsAddExercises {

    public StringBinding binding = Bindings.createStringBinding(() -> {
        int characterCount = 0;
        if (AddExercisesScene.descriptionTextArea.getText() != null) {
            characterCount = AddExercisesScene.descriptionTextArea.getText().length();
        }
        if (characterCount >= 8000) {
            AddExercisesScene.descriptionTextArea.deleteNextChar();
        }
        return "Description (" + characterCount + "/ 8000)";
    }, AddExercisesScene.descriptionTextArea.textProperty());

    public BindingsAddExercises() {
        AddExercisesScene.descriptionLabel.textProperty().bind(binding);
    }
}
