package com.quiz.quizapplication.exercises.scene.add;

import com.quiz.quizapplication.exercises.controller.add.AddExercisesGroupController;
import com.quiz.quizapplication.scene.background.BackgroundScene;
import com.quiz.quizapplication.scene.add.ChooseAddScene;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.SQLException;

public class AddGroupExercisesScene extends Application {

    private final BackgroundScene backgroundScene = new BackgroundScene();
    public static TextField groupTextField;
    public static TextField newNameOfGroupTextField;
    public static ChoiceBox<String> choiceBoxNew;
    ChooseAddScene chooseAddScene = new ChooseAddScene();
    AddExercisesGroupController addExercisesGroupController = new AddExercisesGroupController();

    public AddGroupExercisesScene() throws SQLException {
        choiceBoxNew = new ChoiceBox<>(addExercisesGroupController.createObservableListToChoiceBox());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
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
        Button backButton = new Button("Back");
            backButton.setPrefWidth(150);
            backButton.setPrefHeight(50);
            backButton.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981A7");

        vBoxBottom.getChildren().add(0, backButton);

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

//        addGroupButton.setOnAction(event -> groupSettingsController.addGroupToDb());
//
//        deleteGroupButton.setOnAction(event -> groupSettingsController.deleteGroupFromDb());
//
//        changeNameButton.setOnAction(event -> groupSettingsController.changeGroupName());
//
//        backButton.setOnAction(event -> {
//            try {
//                chooseAddScene.start(primaryStage);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });

        addGroupButton.setOnAction(event -> {
            try {
                addExercisesGroupController.addGroupExercises();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        deleteGroupButton.setOnAction(event -> {
            try {
                addExercisesGroupController.deleteGroup();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        changeNameButton.setOnAction(event -> {
            try {
                addExercisesGroupController.changeGroupName();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        backButton.setOnAction(event -> {
            try {
                chooseAddScene.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}


