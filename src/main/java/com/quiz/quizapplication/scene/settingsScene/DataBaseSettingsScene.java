package com.quiz.quizapplication.scene.settingsScene;

import com.quiz.quizapplication.controller.DataBaseSettingsController;
import com.quiz.quizapplication.database.ConnectToDb;
import com.quiz.quizapplication.database.DataFromDb;
import com.quiz.quizapplication.scene.BackgroundScene;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.SQLException;

public class DataBaseSettingsScene extends Application {

    private final BackgroundScene backgroundScene = new BackgroundScene();
    private DataBaseSettingsController dataBaseSettingsController = new DataBaseSettingsController();
    private MainSettingsScene mainSettingsScene = new MainSettingsScene();
    public static Label cleanLabel;
    public static AlertBox alertBox;

    public DataBaseSettingsScene() throws SQLException {
    }

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

        Label databaseLabel = new Label("Data base");
            databaseLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false");
            databaseLabel.setPrefHeight(20);
            databaseLabel.setPrefWidth(400);
        Label dataTestGeneratorLabel = new Label("Data generator");
            dataTestGeneratorLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false");
            dataTestGeneratorLabel.setPrefHeight(20);
            dataTestGeneratorLabel.setPrefWidth(400);
        Button dataTestGeneratorButton = new Button("Generate test data");
            dataTestGeneratorButton.setPrefHeight(20);
            dataTestGeneratorButton.setPrefWidth(400);

        cleanLabel = new Label("Clean all");
            cleanLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false");
            cleanLabel.setPrefHeight(20);
            cleanLabel.setPrefWidth(400);
        Button cleanButton = new Button("Clean");
            cleanButton.setPrefHeight(20);
            cleanButton.setPrefWidth(400);
        TextField pathDbTextField = new TextField();
            pathDbTextField.setPrefWidth(400);
            pathDbTextField.setPrefHeight(20);
            pathDbTextField.setText(ConnectToDb.getInstance().getClass().getProtectionDomain().getCodeSource().getLocation().toString());

        gridPane.add(databaseLabel, 0, 0);
        gridPane.add(pathDbTextField, 0, 1);
        gridPane.add(dataTestGeneratorLabel, 0, 2);
        gridPane.add(dataTestGeneratorButton, 0, 3);
        gridPane.add(cleanLabel, 0, 4);
        gridPane.add(cleanButton, 0, 5);

        Scene databaseScene = new Scene(anchorPane, 853, 569, Color.BLACK);
        primaryStage.setScene(databaseScene);

        cleanButton.setOnAction(event -> AlertBox.alertBoxCleanAll());

        dataTestGeneratorButton.setOnAction(event -> {
            try {
                dataBaseSettingsController.create();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}
