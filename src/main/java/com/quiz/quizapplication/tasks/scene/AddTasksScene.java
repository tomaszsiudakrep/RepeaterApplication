package com.quiz.quizapplication.tasks.scene;

import com.quiz.quizapplication.scene.background.BackgroundScene;
import com.quiz.quizapplication.tasks.controller.add.AddTaskController;
import com.quiz.quizapplication.tasks.data.add.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;

public class AddTasksScene extends Application {

    BackgroundScene backgroundScene = new BackgroundScene();
    DataCreateChoiceList dataCreateChoiceList = new DataCreateChoiceList();
    DataPriorityChoiceList dataPriorityChoiceList = new DataPriorityChoiceList();
    AddTaskController addTaskController = new AddTaskController();
    DataTimeChoice dataTimeChoice = new DataTimeChoice();
    DataReminderChoiceBox dataReminderChoiceBox = new DataReminderChoiceBox();
    DataDownloadValueFromFields dataDownloadValueFromFields = new DataDownloadValueFromFields();

    public static ChoiceBox<String> choiceBoxList;
    public static ChoiceBox<String> choiceBoxPriority;
    public static TextField titleTextField;
    public static TextField descriptionTextField;
    public static TextField categoryTextField;
    public static DatePicker endDatePicker;
    public static DatePicker startDatePicker;
    public static CheckBox startDateCheckBox;
    public static CheckBox endDateCheckBox;
    public static ChoiceBox<Integer> startHour;
    public static ChoiceBox<Integer> startMinute;
    public static ChoiceBox<Integer> endHour;
    public static ChoiceBox<Integer> endMinute;
    public static ChoiceBox<String> reminderSelect;
    public static CheckBox doNotReminderCheckBox;
    public static Button saveButton;
    public static Label titleLabel;
    BindingTitle bindingTitle;

    public AddTasksScene() {
        choiceBoxList = new ChoiceBox<>(dataCreateChoiceList.createObservableList());
        choiceBoxPriority = new ChoiceBox<>(dataPriorityChoiceList.createObservableList());
        startHour = new ChoiceBox<>(dataTimeChoice.createObservableListOfHours());
        startMinute = new ChoiceBox<>(dataTimeChoice.createObservableListOfMinutes());
        endHour = new ChoiceBox<>(dataTimeChoice.createObservableListOfHours());
        endMinute = new ChoiceBox<>(dataTimeChoice.createObservableListOfMinutes());
        reminderSelect = new ChoiceBox<>(dataReminderChoiceBox.observableList());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();
            anchorPane.setPadding(new Insets(5, 5, 5, 5));
            anchorPane.setBackground(backgroundScene.defaultBackground());

        VBox vBoxMain = new VBox();
            vBoxMain.setPrefHeight(569);
            vBoxMain.setPrefWidth(703);
            vBoxMain.setAlignment(Pos.TOP_RIGHT);

        GridPane gridPane = new GridPane();
            gridPane.setAlignment(Pos.TOP_RIGHT);
            gridPane.setPrefWidth(703);
            gridPane.setPrefHeight(569);

        HBox hBoxButtons = new HBox();
            hBoxButtons.setAlignment(Pos.TOP_RIGHT);

        HBox hBoxStartDateHBox = new HBox();
            hBoxStartDateHBox.setStyle("-fx-border-color: black; -fx-border-width: 1");

        HBox hBoxEndDateHBox = new HBox();
            hBoxEndDateHBox.setStyle("-fx-border-color: black; -fx-border-width: 1");

        HBox hBoxReminder = new HBox();
        hBoxReminder.setStyle("-fx-border-color: black; -fx-border-width: 1");

        saveButton = new Button("Save task");
            saveButton.setPrefHeight(30);
            saveButton.setPrefWidth(100);
            saveButton.setStyle("-fx-text-fill: black; -fx-border-color: white; -fx-border-width: 3");
            saveButton.setDisable(true);
        Button clearButton = new Button("Clear");
            clearButton.setPrefHeight(30);
            clearButton.setPrefWidth(100);
            clearButton.setStyle("-fx-text-fill: black; -fx-border-color: white; -fx-border-width: 3");
        Button closeButton = new Button("Close");
            closeButton.setPrefHeight(30);
            closeButton.setPrefWidth(100);
            closeButton.setStyle("-fx-text-fill: black; -fx-border-color: white; -fx-border-width: 3");
        Button attachmentButton = new Button("Attachment");
            attachmentButton.setPrefHeight(30);
            attachmentButton.setPrefWidth(100);
            attachmentButton.setStyle("-fx-text-fill: black; -fx-border-color: white; -fx-border-width: 3");

        titleLabel = new Label("Title:");
            titleLabel.setPrefHeight(27);
            titleLabel.setPrefWidth(100);
            titleLabel.setStyle("-fx-border-width: 1; -fx-border-color: white; -fx-text-fill: black");
        Label descriptionLabel = new Label("Description:");
            descriptionLabel.setPrefHeight(27);
            descriptionLabel.setPrefWidth(100);
            descriptionLabel.setStyle("-fx-border-width: 1; -fx-border-color: white; -fx-text-fill: black");
        Label listLabel = new Label("List:");
            listLabel.setPrefHeight(27);
            listLabel.setPrefWidth(100);
            listLabel.setStyle("-fx-border-width: 1; -fx-border-color: white; -fx-text-fill: black");
        Label categoryLabel = new Label("Category:");
            categoryLabel.setPrefHeight(27);
            categoryLabel.setPrefWidth(100);
            categoryLabel.setStyle("-fx-border-width: 1; -fx-border-color: white; -fx-text-fill: black");
        Label priorityLabel = new Label("Priority:");
            priorityLabel.setPrefHeight(27);
            priorityLabel.setPrefWidth(100);
            priorityLabel.setStyle("-fx-border-width: 1; -fx-border-color: white; -fx-text-fill: black");
        Label startDateLabel = new Label("Start:");
            startDateLabel.setPrefHeight(30);
            startDateLabel.setPrefWidth(100);
            startDateLabel.setStyle("-fx-border-width: 1; -fx-border-color: white; -fx-text-fill: black");
        Label endDateLabel = new Label("End:");
            endDateLabel.setPrefHeight(30);
            endDateLabel.setPrefWidth(100);
            endDateLabel.setStyle("-fx-border-width: 1; -fx-border-color: white; -fx-text-fill: black");
        Label reminderLabel = new Label("Reminder:");
            reminderLabel.setPrefHeight(27);
            reminderLabel.setPrefWidth(100);
            reminderLabel.setStyle("-fx-border-width: 1; -fx-border-color: white; -fx-text-fill: black");
        Label doNotReminderLabel = new Label("   Not reminder:");
            doNotReminderLabel.setPrefHeight(27);
            doNotReminderLabel.setPrefWidth(100);
            doNotReminderLabel.setStyle("-fx-border-width: 1; -fx-border-color: white; -fx-text-fill: black");
        startHour.setDisable(true);
            startHour.setValue(LocalTime.now().getHour());
        startMinute.setValue(0);
            startMinute.setDisable(true);
        endHour.setDisable(true);
            endHour.setValue(LocalTime.now().getHour());
        endMinute.setValue(0);
            endMinute.setDisable(true);
        reminderSelect.setDisable(true);
            reminderSelect.setValue("1 hour before");
        titleTextField = new TextField();
            titleTextField.setPrefWidth(300);
            titleTextField.setPrefHeight(20);
            titleTextField.setStyle("-fx-background-color: white; -fx-border-width: 1; -fx-border-color: black; -fx-text-fill: black");
            titleTextField.setPromptText("New task");
            bindingTitle = new BindingTitle();
        descriptionTextField = new TextField();
            descriptionTextField.setPrefWidth(300);
            descriptionTextField.setPrefHeight(20);
            descriptionTextField.setPromptText("Description");
            descriptionTextField.setStyle("-fx-background-color: white; -fx-border-width: 1; -fx-border-color: black; -fx-text-fill: black");
        categoryTextField = new TextField();
            categoryTextField.setPrefWidth(300);
            categoryTextField.setPrefHeight(20);
            categoryTextField.setPromptText("Category");
            categoryTextField.setStyle("-fx-background-color: white; -fx-border-width: 1; -fx-border-color: black; -fx-text-fill: black");
        choiceBoxList.setPrefWidth(300);
            choiceBoxList.setPrefHeight(20);
            choiceBoxList.setStyle("-fx-background-color: white; -fx-border-width: 1; -fx-border-color: black; -fx-text-fill: black");
            choiceBoxList.setValue("To do");
        choiceBoxPriority.setPrefWidth(300);
            choiceBoxPriority.setPrefHeight(20);
            choiceBoxPriority.setStyle("-fx-background-color: white; -fx-border-width: 1; -fx-border-color: black; -fx-text-fill: black");
            choiceBoxPriority.setValue("Low");
        startDatePicker = new DatePicker(LocalDate.now());
            startDatePicker.setStyle("-fx-border-color: black; -fx-border-width: 0");
            startDatePicker.setDisable(true);
        endDatePicker = new DatePicker(LocalDate.now());
            endDatePicker.setStyle("-fx-border-color: black; -fx-border-width: 0");
            endDatePicker.setDisable(true);
        startDateCheckBox = new CheckBox();
            startDateCheckBox.setAlignment(Pos.BOTTOM_CENTER);
            startDateCheckBox.setStyle("-fx-alignment: bottom_center; -fx-border-color: white; -fx-border-width: 2");
            startDateCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
                if (startDateCheckBox.isSelected()) {
                    startDatePicker.setDisable(false);
                    reminderSelect.setDisable(false);
                    startHour.setDisable(false);
                    startMinute.setDisable(false);
                }
                else {
                    startDatePicker.setDisable(true);
                    reminderSelect.setDisable(true);
                    startHour.setDisable(true);
                    startMinute.setDisable(true);
                }
            });
        endDateCheckBox = new CheckBox();
            endDateCheckBox.setAlignment(Pos.BOTTOM_CENTER);
            endDateCheckBox.setStyle("-fx-alignment: bottom_center; -fx-border-color: white; -fx-border-width: 2");
            endDateCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
                if (endDateCheckBox.isSelected()) {
                         endDatePicker.setDisable(false);
                         endHour.setDisable(false);
                         endMinute.setDisable(false);
                } else {
                    endDatePicker.setDisable(true);
                    endHour.setDisable(true);
                    endMinute.setDisable(true);
                }
            });
        doNotReminderCheckBox = new CheckBox();
            doNotReminderCheckBox.setAlignment(Pos.BOTTOM_CENTER);
            doNotReminderCheckBox.setStyle("-fx-alignment: bottom_center; -fx-border-color: white; -fx-border-width: 2");
            doNotReminderCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
                if (startDateCheckBox.isSelected()) {
                    reminderSelect.setDisable(doNotReminderCheckBox.isSelected());
                }
            });


        anchorPane.getChildren().add(vBoxMain);
        anchorPane.getChildren().add(MainTasksScene.vBoxBottom);
        anchorPane.getChildren().add(MainTasksScene.vBoxTop);

        hBoxButtons.getChildren().addAll(saveButton, attachmentButton, clearButton, closeButton);
        hBoxStartDateHBox.getChildren().addAll(startDateCheckBox, startDatePicker, startHour, startMinute);
        hBoxEndDateHBox.getChildren().addAll(endDateCheckBox, endDatePicker, endHour, endMinute);
        hBoxReminder.getChildren().addAll(reminderSelect, doNotReminderLabel, doNotReminderCheckBox);

        gridPane.add(titleLabel, 10, 10);
        gridPane.add(descriptionLabel, 10, 20);
        gridPane.add(listLabel, 10, 30);
        gridPane.add(categoryLabel, 10, 40);
        gridPane.add(titleTextField, 20, 10);
        gridPane.add(descriptionTextField, 20, 20);
        gridPane.add(choiceBoxList, 20, 30);
        gridPane.add(categoryTextField, 20, 40);
        gridPane.add(startDateLabel, 10, 50);
        gridPane.add(hBoxStartDateHBox, 20, 50);
        gridPane.add(endDateLabel, 10, 60);
        gridPane.add(hBoxEndDateHBox, 20, 60);
        gridPane.add(reminderLabel, 10, 70);
        gridPane.add(hBoxReminder, 20, 70);
        gridPane.add(priorityLabel, 10, 45);
        gridPane.add(choiceBoxPriority, 20, 45);

        vBoxMain.getChildren().add(hBoxButtons);
        vBoxMain.getChildren().add(gridPane);

        Scene settingsScene = new Scene(anchorPane, 853, 569, Color.BLACK);
        primaryStage.setScene(settingsScene);

        clearButton.setOnAction(event -> addTaskController.clear());

        saveButton.setOnAction(event -> {
            try {
                addTaskController.addTask();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });


    }
}
