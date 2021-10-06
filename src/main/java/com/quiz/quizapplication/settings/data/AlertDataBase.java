package com.quiz.quizapplication.settings.data;

import javafx.scene.control.Alert;

public class AlertDataBase {

    public static Alert dialogConfirmationClean = new Alert(Alert.AlertType.CONFIRMATION);
    public static Alert dialogConfirmationGenerateTestData = new Alert(Alert.AlertType.CONFIRMATION);
    public static Alert dialogInformationClean = new Alert(Alert.AlertType.INFORMATION);
    public static Alert dialogInformationGenerateTestData = new Alert(Alert.AlertType.INFORMATION);

    public AlertDataBase() {
        dialogConfirmationClean.setTitle("Warning");
        dialogConfirmationClean.setHeaderText("Are you sure you want to delete all groups and exercises?");
        dialogConfirmationGenerateTestData.setTitle("Warning");
        dialogConfirmationGenerateTestData.setHeaderText("Are you sure you want to generate test data?\n" +
                "All groups and own exercises will be deleted.");
    }

    public void allDataHasBeenDeleted() {
        dialogInformationClean.setHeaderText("All data has been deleted.");
    }

    public void allDataWasNotDeleted() {
        dialogInformationClean.setHeaderText("Data was not deleted. Problem with data base.");
    }

    public void testDataHasBeenGenerated() {
        dialogInformationGenerateTestData.setHeaderText("Test date has been generated.");
    }

    public void testDataWasNotGenerated() {
        dialogInformationGenerateTestData.setHeaderText("Data was not generated. Problem with data base.");
    }
}
