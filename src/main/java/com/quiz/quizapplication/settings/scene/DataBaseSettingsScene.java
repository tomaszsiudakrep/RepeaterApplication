package com.quiz.quizapplication.settings.scene;

import com.quiz.quizapplication.settings.controller.DataBaseSettingsController;
import com.quiz.quizapplication.database.ConnectToDb;
import com.quiz.quizapplication.scene.background.BackgroundScene;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.sql.SQLException;

public class DataBaseSettingsScene extends Application {

    private final BackgroundScene backgroundScene = new BackgroundScene();
    DataBaseSettingsController dataBaseSettingsController = new DataBaseSettingsController();
    public static Label cleanLabel;

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();
            anchorPane.setBackground(backgroundScene.defaultBackground());
            anchorPane.setPadding(new Insets(5, 5, 5, 5));

        anchorPane.getChildren().add(0, MainSettingsScene.vBoxBottom);
        anchorPane.getChildren().add(1, MainSettingsScene.vBoxTop);

        GridPane gridPane = new GridPane();
            gridPane.setAlignment(Pos.TOP_RIGHT);
            gridPane.setPrefWidth(703);
            gridPane.setPrefHeight(569);
        anchorPane.getChildren().add(0, gridPane);

        Label dataTestGeneratorLabel = new Label("Data generator");
            dataTestGeneratorLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false");
            dataTestGeneratorLabel.setPrefHeight(20);
            dataTestGeneratorLabel.setPrefWidth(400);
        Button testDataGeneratorButton = new Button("Generate test data");
            testDataGeneratorButton.setPrefHeight(20);
            testDataGeneratorButton.setPrefWidth(400);
        cleanLabel = new Label("Clean all");
            cleanLabel.setStyle("-fx-background-color: #6857a5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false");
            cleanLabel.setPrefHeight(20);
            cleanLabel.setPrefWidth(400);
        Button cleanButton = new Button("Clean");
            cleanButton.setPrefHeight(20);
            cleanButton.setPrefWidth(400);
        Label instanceNameLabel = new Label("Instance");
            instanceNameLabel.setPrefWidth(400);
            instanceNameLabel.setPrefHeight(15);
            instanceNameLabel.setStyle("-fx-background-color: #6857A5; -fx-alignment: center; -fx-text-fill: white");
        TextField instanceTextField = new TextField();
            instanceTextField.setPrefHeight(20);
            instanceTextField.setPrefWidth(400);
            instanceTextField.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 1");
        Label nameDataBaseLabel = new Label("Database");
            nameDataBaseLabel.setPrefWidth(400);
            nameDataBaseLabel.setPrefHeight(15);
            nameDataBaseLabel.setStyle("-fx-background-color: #6857A5; -fx-alignment: center; -fx-text-fill: white");
        TextField nameDataBaseTextField = new TextField();
            nameDataBaseTextField.setPrefHeight(20);
            nameDataBaseTextField.setPrefWidth(400);
            nameDataBaseTextField.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 1");
        Label userDatabaseLabel = new Label("User");
            userDatabaseLabel.setPrefWidth(400);
            userDatabaseLabel.setPrefHeight(15);
            userDatabaseLabel.setStyle("-fx-background-color: #6857A5; -fx-alignment: center; -fx-text-fill: white");
        TextField userDatabaseTextField = new TextField();
            userDatabaseTextField.setPrefHeight(20);
            userDatabaseTextField.setPrefWidth(400);
            userDatabaseTextField.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 1");
        Label passwordUserDatabaseLabel = new Label("Password");
            passwordUserDatabaseLabel.setPrefWidth(400);
            passwordUserDatabaseLabel.setPrefHeight(15);
            passwordUserDatabaseLabel.setStyle("-fx-background-color: #6857A5; -fx-alignment: center; -fx-text-fill: white");
        PasswordField passwordUserDatabaseTextField = new PasswordField();
            passwordUserDatabaseTextField.setPrefHeight(20);
            passwordUserDatabaseTextField.setPrefWidth(400);
            passwordUserDatabaseTextField.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 1");

        gridPane.add(dataTestGeneratorLabel, 0, 0);
        gridPane.add(testDataGeneratorButton, 0, 1);
        gridPane.add(cleanLabel, 0, 2);
        gridPane.add(cleanButton, 0, 3);
        gridPane.add(instanceNameLabel, 0, 4);
        gridPane.add(instanceTextField, 0, 5);
        gridPane.add(nameDataBaseLabel, 0, 6);
        gridPane.add(nameDataBaseTextField, 0, 7);
        gridPane.add(userDatabaseLabel, 0, 8);
        gridPane.add(userDatabaseTextField, 0, 9);
        gridPane.add(passwordUserDatabaseLabel, 0, 10);
        gridPane.add(passwordUserDatabaseTextField, 0, 11);

        Scene databaseScene = new Scene(anchorPane, 853, 569, Color.BLACK);
        primaryStage.setScene(databaseScene);

        cleanButton.setOnAction(event -> {
            try {
                dataBaseSettingsController.cleanAllExercisesAndGroups();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        testDataGeneratorButton.setOnAction(event -> {
            try {
                dataBaseSettingsController.createTestData();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}
