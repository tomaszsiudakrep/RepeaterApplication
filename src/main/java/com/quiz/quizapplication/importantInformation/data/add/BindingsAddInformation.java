package com.quiz.quizapplication.importantInformation.data.add;

import com.quiz.quizapplication.importantInformation.scene.add.AddInformationScene;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;

public class BindingsAddInformation {

    public StringBinding binding = Bindings.createStringBinding(() -> {
        int characterCount = 0;
        if (AddInformationScene.descriptionTextArea.getText() != null) {
            characterCount = AddInformationScene.descriptionTextArea.getText().length();
        }
        if (characterCount >= 8000) {
            AddInformationScene.descriptionTextArea.deleteNextChar();
        }
        return "Description (" + characterCount + "/ 8000)";
    }, AddInformationScene.descriptionTextArea.textProperty());

    public BindingsAddInformation() {
        AddInformationScene.descriptionLabel.textProperty().bind(binding);
    }
}
