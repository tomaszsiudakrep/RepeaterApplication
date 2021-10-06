package com.quiz.quizapplication.repeat.testKnowledge.scene;

import com.quiz.quizapplication.data.timers.CountdownTimer;
import com.quiz.quizapplication.repeat.testKnowledge.controller.TestRepeaterController;
import com.quiz.quizapplication.scene.background.BackgroundScene;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.sql.SQLException;

public class TestScene extends Application {

    public static int counter = 1;
    BackgroundScene backgroundScene = new BackgroundScene();
    TestRepeaterController testRepeaterController = new TestRepeaterController();
    TestSettingsScene testSettingsScene;
    public static CountdownTimer countdownTimer;
    public static Label idTextField = new Label();
    public static Label titleTextField = new Label();
    public static TextArea descriptionAreaText = new TextArea();
    public static Label exerciseCounterLabel;
    public static int randomNumberIdToDisplay;
    public static Button nextExercisesButton;


    @Override
    public void start(Stage primaryStage) throws Exception {
        testSettingsScene = new TestSettingsScene();
        countdownTimer = new CountdownTimer();

        AnchorPane anchorPane = new AnchorPane();
            anchorPane.setPadding(new Insets(5, 5, 5, 5));
            anchorPane.setBackground(backgroundScene.defaultBackground());

        GridPane gridPane = new GridPane();
            gridPane.setAlignment(Pos.TOP_CENTER);
            gridPane.setPrefWidth(1003);
            gridPane.setPrefHeight(569);

        VBox vBoxBottom = new VBox();
            vBoxBottom.setPrefHeight(569);
            vBoxBottom.setPrefWidth(150);
            vBoxBottom.setStyle("-fx-background-color: #7961BE");
            vBoxBottom.setAlignment(Pos.BOTTOM_CENTER);

        VBox vBoxTop = new VBox();
            vBoxTop.setPrefHeight(300);
            vBoxTop.setPrefWidth(150);
            vBoxTop.setStyle("-fx-background-color: #7961be");

        anchorPane.getChildren().add(gridPane);
        anchorPane.getChildren().add(vBoxBottom);
        anchorPane.getChildren().add(vBoxTop);

        Button backButton = new Button("Back");
            backButton.setPrefWidth(150);
            backButton.setPrefHeight(50);
            backButton.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981A7");
        Label idLabel = new Label("Id");
            idLabel.setPrefWidth(150);
            idLabel.setPrefHeight(20);
            idLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false");
        idTextField.setPrefWidth(150);
            idTextField.setPrefHeight(20);
            idTextField.setStyle("-fx-background-color: white; -fx-font-size: 12; -fx-text-fill: black;-fx-underline: false");
        Label titleLabel = new Label("Title");
            titleLabel.setPrefWidth(150);
            titleLabel.setPrefHeight(20);
            titleLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false");
        titleTextField.setPrefWidth(150);
            titleTextField.setPrefHeight(20);
            titleTextField.setStyle("-fx-background-color: white; -fx-font-size: 12; -fx-text-fill: black;-fx-underline: false");
        Label exerciseLabel = new Label("Exercise");
            exerciseLabel.setPrefWidth(150);
            exerciseLabel.setPrefHeight(20);
            exerciseLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false");
//        Label exerciseCounterLabel = new Label(counter + "/" + TestSettingsScene.countOfExercises);
        exerciseCounterLabel = new Label(counter + "/" + TestSettingsScene.countOfExercises);
            exerciseCounterLabel.setPrefWidth(150);
            exerciseCounterLabel.setPrefHeight(20);
            exerciseCounterLabel.setStyle("-fx-background-color: white; -fx-font-size: 12; -fx-text-fill: black;-fx-underline: false");
        Label descriptionLabel = new Label("Description");
            descriptionLabel.setPrefHeight(20);
            descriptionLabel.setPrefWidth(400);
            descriptionLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false");
        descriptionAreaText.setWrapText(true);
            descriptionAreaText.setPrefHeight(400);
            descriptionAreaText.setPrefWidth(400);
        nextExercisesButton = new Button("Next exercises");
            nextExercisesButton.setPrefWidth(400);
            nextExercisesButton.setPrefHeight(20);
            nextExercisesButton.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white; -fx-border-width:1; -fx-border-color:#8981a7");

        gridPane.add(CountdownTimer.vBoxTime, 1, 0);
        gridPane.add(descriptionLabel, 1, 1);
        gridPane.add(descriptionAreaText, 1, 2);
        gridPane.add(nextExercisesButton, 1, 3);

        vBoxBottom.getChildren().add(backButton);

        vBoxTop.getChildren().add(exerciseLabel);
        vBoxTop.getChildren().add(exerciseCounterLabel);
        vBoxTop.getChildren().add(idLabel);
        vBoxTop.getChildren().add(idTextField);
        vBoxTop.getChildren().add(titleLabel);
        vBoxTop.getChildren().add(titleTextField);

        Scene test = new Scene(anchorPane, 853, 569, Color.BLACK);
        primaryStage.setScene(test);

        backButton.setOnAction(event -> {
            try {
                CountdownTimer.reset();
                testRepeaterController.initializeCounter();
                testSettingsScene.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        nextExercisesButton.setOnAction(event ->
        {
            try {
                testRepeaterController.nextRandomExercise();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}
