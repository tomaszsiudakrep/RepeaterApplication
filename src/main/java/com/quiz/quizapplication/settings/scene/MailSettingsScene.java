package com.quiz.quizapplication.settings.scene;

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
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MailSettingsScene extends Application {

    BackgroundScene backgroundScene = new BackgroundScene();

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

        Label addressEmailLabel = new Label("Address mail");
            addressEmailLabel.setPrefWidth(400);
            addressEmailLabel.setPrefHeight(15);
            addressEmailLabel.setStyle("-fx-background-color: #6857A5; -fx-alignment: center; -fx-text-fill: white");
        Label passwordEmailLabel = new Label("Password");
            passwordEmailLabel.setPrefWidth(400);
            passwordEmailLabel.setPrefHeight(15);
            passwordEmailLabel.setStyle("-fx-background-color: #6857A5; -fx-alignment: center; -fx-text-fill: white");
        Label smtpEmailLabel = new Label("Server smtp");
            smtpEmailLabel.setPrefWidth(400);
            smtpEmailLabel.setPrefHeight(15);
            smtpEmailLabel.setStyle("-fx-background-color: #6857A5; -fx-alignment: center; -fx-text-fill: white");
        Label portEmailLabel = new Label("Port");
            portEmailLabel.setPrefWidth(400);
            portEmailLabel.setPrefHeight(15);
            portEmailLabel.setStyle("-fx-background-color: #6857A5; -fx-alignment: center; -fx-text-fill: white");
        TextField addressEmailTextField = new TextField();
            addressEmailTextField.setPrefHeight(20);
            addressEmailTextField.setPrefWidth(400);
            addressEmailTextField.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 1");
        PasswordField passwordEmailPasswordField = new PasswordField();
            passwordEmailPasswordField.setPrefHeight(20);
            passwordEmailPasswordField.setPrefWidth(400);
            passwordEmailPasswordField.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 1");
        TextField smtpEmailTextField = new TextField();
            smtpEmailTextField.setPrefHeight(20);
            smtpEmailTextField.setPrefWidth(400);
            smtpEmailTextField.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 1");
        TextField portEmailTextField = new TextField();
            portEmailTextField.setPrefHeight(20);
            portEmailTextField.setPrefWidth(400);
            portEmailTextField.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 1");
        Button saveMailButton = new Button("Save settings");
            saveMailButton.setPrefWidth(200);
            saveMailButton.setPrefHeight(15);
        Button testConnectionButton = new Button("Test connection");
            testConnectionButton.setPrefWidth(200);
            testConnectionButton.setPrefHeight(15);
        HBox hBox = new HBox();
            hBox.getChildren().add(saveMailButton);
            hBox.getChildren().add(testConnectionButton);

        gridPane.add(addressEmailLabel, 0, 0);
        gridPane.add(addressEmailTextField, 0, 1);
        gridPane.add(passwordEmailLabel, 0, 2);
        gridPane.add(passwordEmailPasswordField, 0, 3);
        gridPane.add(smtpEmailLabel, 0, 4);
        gridPane.add(smtpEmailTextField, 0, 5);
        gridPane.add(portEmailLabel, 0, 6);
        gridPane.add(portEmailTextField, 0, 7);
        gridPane.add(hBox, 0, 8);

        Scene mailScene = new Scene(anchorPane, 853, 569, Color.BLACK);
        primaryStage.setScene(mailScene);
    }
}
