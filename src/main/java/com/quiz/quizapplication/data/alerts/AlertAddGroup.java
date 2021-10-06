package com.quiz.quizapplication.data.alerts;

import javafx.scene.control.Alert;

public class AlertAddGroup {

    public static Alert dialogInformation = new Alert(Alert.AlertType.INFORMATION);
    public static Alert dialogConfirmation = new Alert(Alert.AlertType.CONFIRMATION);

    public AlertAddGroup() {
        dialogInformation.setTitle("Information");
        dialogConfirmation.setTitle("Warning");
        dialogConfirmation.setHeaderText("Are you sure you want to delete a group?");
    }

    public void groupHasBeenAdded() {
        dialogInformation.setHeaderText("The group has been added.");
    }

    public void groupWasNotAdded() {
        dialogInformation.setHeaderText("The group was not added. Problem with data base.");
    }

    public void groupNameIsNullOrAlreadyExists() {
        dialogInformation.setHeaderText("The group name is empty or already exists.");
    }

    public void groupNameHasBeenChanged() {
        dialogInformation.setHeaderText("The group name has been changed.");
    }

    public void groupNameWasNotChanged() {
        dialogInformation.setHeaderText("The group name was not changed. Problem with data base.");
    }

    public void groupHasBeenDeleted() {
        dialogInformation.setHeaderText("The group has been deleted.");
    }

    public void groupWasNotDeleted() {
        dialogInformation.setHeaderText("The group was not deleted. Problem with data base or there are tasks assigned to this group.");
    }

    public void confirmDeleteGroup() {
        dialogConfirmation.setHeaderText("Are you sure you want to delete a group?");
    }




}
