package com.quiz.quizapplication.data.alerts;

import javafx.scene.control.Alert;

public class AlertAddObject {

    public static Alert dialogInformation = new Alert(Alert.AlertType.INFORMATION);

    public AlertAddObject() {
        dialogInformation.setTitle("Information");
    }

    public void informationHasBeenAdded() {
        dialogInformation.setHeaderText("Object has been added.");
    }

    public void informationWasNotAdded() {
        dialogInformation.setHeaderText("Object was not added. Problem with data base.");
    }

    public void informationTextFieldOrGroupIsEmpty() {
        dialogInformation.setHeaderText("The title, group or description of object is empty.");
    }

    public void informationAlreadyExist() {
        dialogInformation.setHeaderText("The object in chosen group already exist.");
    }


}
