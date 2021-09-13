package com.quiz.quizapplication.scene.settingsScene;

import com.quiz.quizapplication.controller.GroupChoiceBoxController;
import com.quiz.quizapplication.controller.GroupSettingsController;
import com.quiz.quizapplication.scene.BackgroundScene;
import com.quiz.quizapplication.scene.addScene.AddExercisesScene;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GroupSettings extends Application {

    private final BackgroundScene backgroundScene = new BackgroundScene();
    public static TextField groupTextField;
    public static TextField newNameOfGroupTextField;
    public static ChoiceBox<String> choiceBoxNew;
    GroupSettingsController groupSettingsController = new GroupSettingsController();
    GroupChoiceBoxController groupChoiceBoxController = new GroupChoiceBoxController();

    public GroupSettings() {
        choiceBoxNew = new ChoiceBox<>(groupChoiceBoxController.create());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();
            anchorPane.setPadding(new Insets(5, 5, 5, 5));
            anchorPane.setBackground(backgroundScene.defaultBackground());

            anchorPane.getChildren().add(0, MainSettingsScene.vBoxBottom);
            anchorPane.getChildren().add(1, MainSettingsScene.vBoxTop);

        GridPane gridPane = new GridPane();
            gridPane.setAlignment(Pos.TOP_RIGHT);
            gridPane.setPrefWidth(703);
            gridPane.setPrefHeight(569);
            anchorPane.getChildren().add(0, gridPane);

        Label addGroupLabel = new Label("Add group");
            addGroupLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true");
            addGroupLabel.setPrefWidth(300);
            addGroupLabel.setPrefHeight(20);
        groupTextField = new TextField("");
            groupTextField.setPromptText("Write title name");
            groupTextField.setPrefWidth(300);
            groupTextField.setPrefHeight(20);
        Button addGroupButton = new Button("Add group");
            addGroupButton.setPrefWidth(100);
        Label deleteGroupLabel = new Label("Delete group");
            deleteGroupLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true");
            deleteGroupLabel.setPrefWidth(300);
            deleteGroupLabel.setPrefHeight(20);
        Button deleteGroupButton = new Button("Delete group");
            deleteGroupButton.setPrefWidth(100);
        choiceBoxNew.getItems();
        choiceBoxNew.setPrefHeight(20);
        choiceBoxNew.setPrefWidth(300);
        Label changeNameOfGroupLabel = new Label("Change group name");
            changeNameOfGroupLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true");
            changeNameOfGroupLabel.setPrefWidth(300);
            changeNameOfGroupLabel.setPrefHeight(20);
        newNameOfGroupTextField = new TextField();
            newNameOfGroupTextField.setPrefHeight(20);
            newNameOfGroupTextField.setPrefWidth(300);
            newNameOfGroupTextField.setPromptText("Choose group above and write here new group name");
        Button changeNameButton = new Button("Change name");
            changeNameButton.setPrefWidth(100);

        gridPane.add(addGroupLabel, 1, 0);
        gridPane.add(groupTextField, 1, 1);
        gridPane.add(addGroupButton, 2, 1);
        gridPane.add(deleteGroupLabel, 1, 2);
        gridPane.add(choiceBoxNew, 1, 3);
        gridPane.add(deleteGroupButton, 2, 3);
        gridPane.add(changeNameOfGroupLabel, 1, 4);
        gridPane.add(newNameOfGroupTextField, 1, 5);
        gridPane.add(changeNameButton, 2, 5);

        Scene groupSettScene = new Scene(anchorPane, 853, 569, Color.BLACK);

        primaryStage.setScene(groupSettScene);

        addGroupButton.setOnAction(event -> groupSettingsController.addGroupToDb());

        deleteGroupButton.setOnAction(event -> groupSettingsController.deleteGroupFromDb());

        changeNameButton.setOnAction(event -> groupSettingsController.changeGroupName());
    }
}

