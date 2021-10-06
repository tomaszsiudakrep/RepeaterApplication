package com.quiz.quizapplication.importantInformation.add;

import com.quiz.quizapplication.importantInformation.controller.AddGroupController;
import com.quiz.quizapplication.scene.BackgroundScene;
import com.quiz.quizapplication.scene.addScene.ChooseAddScene;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.SQLException;

public class AddGroupInformationScene extends Application {

    BackgroundScene backgroundScene = new BackgroundScene();
    AddGroupController addGroupController = new AddGroupController();
    ChooseAddScene chooseAddScene;
    public static TextField groupTextField;
    public static TextField newNameOfGroupTextField;
    public static ChoiceBox<String> choiceBox;

    public AddGroupInformationScene() throws SQLException {
        choiceBox = new ChoiceBox<>(addGroupController.createObservableListToChoiceBox());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        chooseAddScene = new ChooseAddScene();

        AnchorPane anchorPane = new AnchorPane();
            anchorPane.setPadding(new Insets(5, 5, 5, 5));
            anchorPane.setBackground(backgroundScene.defaultBackground());

        VBox vBoxBottom = new VBox();
            vBoxBottom.setAlignment(Pos.BOTTOM_CENTER);
            vBoxBottom.setPrefHeight(569);
            vBoxBottom.setPrefWidth(150);
            vBoxBottom.setStyle("-fx-background-color: #7961BE");

        anchorPane.getChildren().add(vBoxBottom);

        GridPane gridPane = new GridPane();
            gridPane.setAlignment(Pos.TOP_RIGHT);
            gridPane.setPrefWidth(703);
            gridPane.setPrefHeight(569);
        anchorPane.getChildren().add(0, gridPane);

        Label importantInformationGroupLabel = new Label("Important information group");
            importantInformationGroupLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false; -fx-alignment: center; -fx-border-width:1; -fx-border-color:white");
            importantInformationGroupLabel.setPrefWidth(300);
            importantInformationGroupLabel.setPrefHeight(20);
        Label addGroupLabel = new Label("Add group");
            addGroupLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false");
            addGroupLabel.setPrefWidth(300);
            addGroupLabel.setPrefHeight(20);
        groupTextField = new TextField("");
            groupTextField.setPromptText("Write title name");
            groupTextField.setPrefWidth(300);
            groupTextField.setPrefHeight(20);
        Button addGroupButton = new Button("Add group");
            addGroupButton.setPrefWidth(100);
        Label deleteGroupLabel = new Label("Delete group");
            deleteGroupLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false");
            deleteGroupLabel.setPrefWidth(300);
            deleteGroupLabel.setPrefHeight(20);
        Button deleteGroupButton = new Button("Delete group");
            deleteGroupButton.setPrefWidth(100);
        choiceBox.getItems();
            choiceBox.setPrefHeight(20);
            choiceBox.setPrefWidth(300);
        Label changeNameOfGroupLabel = new Label("Change group name");
            changeNameOfGroupLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false");
            changeNameOfGroupLabel.setPrefWidth(300);
            changeNameOfGroupLabel.setPrefHeight(20);
        newNameOfGroupTextField = new TextField();
            newNameOfGroupTextField.setPrefHeight(20);
            newNameOfGroupTextField.setPrefWidth(300);
            newNameOfGroupTextField.setPromptText("Choose group above and write here new group name");
        Button changeNameButton = new Button("Change name");
            changeNameButton.setPrefWidth(100);
        Button backButton = new Button("Back");
            backButton.setPrefWidth(150);
            backButton.setPrefHeight(50);
            backButton.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981A7");

        vBoxBottom.getChildren().add(0, backButton);

        gridPane.add(importantInformationGroupLabel, 1, 0);
        gridPane.add(addGroupLabel, 1, 1);
        gridPane.add(groupTextField, 1, 2);
        gridPane.add(addGroupButton, 2, 2);
        gridPane.add(deleteGroupLabel, 1, 3);
        gridPane.add(choiceBox, 1, 4);
        gridPane.add(deleteGroupButton, 2, 4);
        gridPane.add(changeNameOfGroupLabel, 1, 5);
        gridPane.add(newNameOfGroupTextField, 1, 6);
        gridPane.add(changeNameButton, 2, 6);

        Scene xx = new Scene(anchorPane, 853, 569, Color.BLACK);

        primaryStage.setScene(xx);

        backButton.setOnAction(event -> {
            try {
                chooseAddScene.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        addGroupButton.setOnAction(event -> {
            try {
                addGroupController.addGroupImportantInformation();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        changeNameButton.setOnAction(event -> {
            try {
                addGroupController.changeGroupName();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        deleteGroupButton.setOnAction(event -> {
            try {
                addGroupController.deleteGroup();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

}
