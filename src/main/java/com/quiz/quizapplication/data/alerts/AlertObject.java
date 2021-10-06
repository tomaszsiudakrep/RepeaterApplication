package com.quiz.quizapplication.data.alerts;

import javafx.scene.control.Alert;

public class AlertImportantInformation {

    public static Alert dialogInformation = new Alert(Alert.AlertType.INFORMATION);
    public static Alert dialogConfirmation = new Alert(Alert.AlertType.CONFIRMATION);
    public static Alert dialogConfirmationAll = new Alert(Alert.AlertType.CONFIRMATION);

    public AlertImportantInformation() {
        dialogInformation.setTitle("Information");
        dialogConfirmation.setTitle("Warning");
        dialogConfirmation.setHeaderText("Are you sure you want to delete this object?");
        dialogConfirmationAll.setTitle("Warning");
        dialogConfirmationAll.setHeaderText("Are you sure you want to delete all exercises?");
    }

    public void informationHasBeenDeleted() {
        dialogInformation.setHeaderText("The object has been deleted.");
    }

    public void informationWasNotDeleted() {
        dialogInformation.setHeaderText("The object was not deleted. Problem with data base.");
    }

    public void newTitleIsEmptyOrItemFromListViewIsNull() {
        dialogInformation.setHeaderText("New title is empty or you don't choose item from list.");
    }

    public void titleHasBeenChanged() {
        dialogInformation.setHeaderText("Title has been changed.");
    }

    public void titleWasNotChanged() {
        dialogInformation.setHeaderText("Title was not changed. Problem with data base.");
    }

    public void newTitleIsAlreadyExist() {
        dialogInformation.setHeaderText("New title is already exist in chosen group.");
    }

    public void newGroupIsNullOrItemFromListViewIsNull() {
        dialogInformation.setHeaderText("You don't choose item or new group from list.");
    }

    public void groupHasBeenChanged() {
        dialogInformation.setHeaderText("Group has been changed.");
    }

    public void groupWasNotChanged() {
        dialogInformation.setHeaderText("Group was not changed. Object with this the same title already exist in chosen group.");
    }

    public void allInformationHasBeenDeleted() {
        dialogInformation.setHeaderText("The objects has been deleted.");
    }

    public void allInformationWasNotDeleted() {
        dialogInformation.setHeaderText("The objects were not deleted. Problem with data base.");
    }
}
