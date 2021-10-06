package com.quiz.quizapplication.data.alerts;

import javafx.scene.control.Alert;

public class AlertExercises {

    public static Alert dialogInformation = new Alert(Alert.AlertType.INFORMATION);

    public AlertExercises() {
        dialogInformation.setTitle("Information");
        dialogInformation.setHeaderText("No more exercises!");
    }

}
