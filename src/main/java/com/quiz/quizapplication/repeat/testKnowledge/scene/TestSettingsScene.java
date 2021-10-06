package com.quiz.quizapplication.repeat.testKnowledge.scene;

import com.quiz.quizapplication.data.timers.CountdownTimer;
import com.quiz.quizapplication.exercises.controller.add.AddExercisesGroupController;
import com.quiz.quizapplication.repeat.testKnowledge.controller.TestRepeaterController;
import com.quiz.quizapplication.repeat.ChooseRepeatScene;
import com.quiz.quizapplication.repeat.testKnowledge.data.DataTestSettings;
import com.quiz.quizapplication.scene.background.BackgroundScene;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestSettingsScene extends Application {

    BackgroundScene backgroundScene = new BackgroundScene();
    TestRepeaterController testRepeaterController = new TestRepeaterController();
    AddExercisesGroupController addExercisesGroupController = new AddExercisesGroupController();
    DataTestSettings dataTestSettings = new DataTestSettings();
    TestScene testScene;
    ChooseRepeatScene chooseRepeatScene;

    public static int countOfExercises = 1;
    public static int time = 30;
    public static Label countOfExercisesToTestLabel;
    public static Button plusOneExButton;
    public static Button minusOneExButton;
    public static ChoiceBox<String> choiceBoxGroup;
    public static Button plusOneMinButton;
    public static Button minusOneMinButton;
    public static Label countOfTimeToTestLabel;
    public static String groupName = null;
    public static List<Integer> listOfExercises = new ArrayList<>();

    public TestSettingsScene() throws SQLException {
        choiceBoxGroup = new ChoiceBox<>(addExercisesGroupController.createObservableListToChoiceBox());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        chooseRepeatScene = new ChooseRepeatScene();
        testScene = new TestScene();

        AnchorPane anchorPane = new AnchorPane();
            anchorPane.setPadding(new Insets(5, 5, 5, 5));
            anchorPane.setBackground(backgroundScene.defaultBackground());

        VBox vBoxTop = new VBox();
            vBoxTop.setPrefHeight(300);
            vBoxTop.setPrefWidth(150);
            vBoxTop.setStyle("-fx-background-color: #7961be");

        VBox vBoxBottom = new VBox();
            vBoxBottom.setPrefHeight(569);
            vBoxBottom.setPrefWidth(150);
            vBoxBottom.setStyle("-fx-background-color: #7961BE");
            vBoxBottom.setAlignment(Pos.BOTTOM_CENTER);

        HBox hBoxTest = new HBox();
        HBox hBoxTime = new HBox();

        Button backButton = new Button("Back");
            backButton.setPrefWidth(150);
            backButton.setPrefHeight(50);
            backButton.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981A7");
        Label countOfExercisesLabel = new Label("Count of exercises");
            countOfExercisesLabel.setPrefHeight(15);
            countOfExercisesLabel.setPrefWidth(150);
            countOfExercisesLabel.setStyle("-fx-border-width: 1; -fx-background-color: #513BA2; -fx-text-fill: white; -fx-font-size: 12; -fx-alignment: center");
        plusOneExButton = new Button();
            plusOneExButton.setGraphic(GlyphsDude.createIcon(FontAwesomeIcon.PLUS));
            plusOneExButton.setPrefHeight(30);
            plusOneExButton.setPrefWidth(50);
        minusOneExButton = new Button();
            minusOneExButton.setGraphic(GlyphsDude.createIcon(FontAwesomeIcon.MINUS));
            minusOneExButton.setPrefHeight(30);
            minusOneExButton.setPrefWidth(50);
        countOfExercisesToTestLabel = new Label(countOfExercises + "");
            countOfExercisesToTestLabel.setPrefHeight(30);
            countOfExercisesToTestLabel.setPrefWidth(50);
            countOfExercisesToTestLabel.setStyle("-fx-font-size: 20; -fx-text-fill: white; -fx-alignment: center");
        Label selectGroupLabel = new Label("Select a group");
            selectGroupLabel.setPrefHeight(15);
            selectGroupLabel.setPrefWidth(150);
            selectGroupLabel.setStyle("-fx-border-width: 1; -fx-background-color: #513BA2; -fx-text-fill: white; -fx-font-size: 12; -fx-alignment: center");
        choiceBoxGroup.setPrefWidth(150);
            choiceBoxGroup.setPrefHeight(30);
            choiceBoxGroup.setStyle("-fx-background-color: white; -fx-font-size: 12; -fx-text-fill: #8981A7;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981a7; -fx-alignment: center");
        Label countOfTimeLabel = new Label("Time [min]");
            countOfTimeLabel.setPrefHeight(15);
            countOfTimeLabel.setPrefWidth(150);
            countOfTimeLabel.setStyle("-fx-border-width: 1; -fx-background-color: #513BA2; -fx-text-fill: white; -fx-font-size: 12; -fx-alignment: center");
        plusOneMinButton = new Button();
            plusOneMinButton.setGraphic(GlyphsDude.createIcon(FontAwesomeIcon.PLUS));
            plusOneMinButton.setPrefHeight(30);
            plusOneMinButton.setPrefWidth(50);
        minusOneMinButton = new Button();
            minusOneMinButton.setGraphic(GlyphsDude.createIcon(FontAwesomeIcon.MINUS));
            minusOneMinButton.setPrefHeight(30);
            minusOneMinButton.setPrefWidth(50);
        countOfTimeToTestLabel = new Label(time + "");
            countOfTimeToTestLabel.setPrefHeight(30);
            countOfTimeToTestLabel.setPrefWidth(50);
            countOfTimeToTestLabel.setStyle("-fx-font-size: 20; -fx-text-fill: white; -fx-alignment: center");
        Button startTestButton = new Button("START TEST");
            startTestButton.setPrefHeight(30);
            startTestButton.setPrefWidth(150);
            startTestButton.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white; -fx-border-width:1; -fx-border-color:#8981A7");

        hBoxTest.getChildren().add(0, minusOneExButton);
        hBoxTest.getChildren().add(1, countOfExercisesToTestLabel);
        hBoxTest.getChildren().add(2, plusOneExButton);

        hBoxTime.getChildren().add(0, minusOneMinButton);
        hBoxTime.getChildren().add(1, countOfTimeToTestLabel);
        hBoxTime.getChildren().add(2, plusOneMinButton);

        anchorPane.getChildren().add(0, vBoxBottom);
        anchorPane.getChildren().add(1, vBoxTop);

        vBoxBottom.getChildren().add(backButton);

        vBoxTop.getChildren().add(countOfExercisesLabel);
        vBoxTop.getChildren().add(hBoxTest);
        vBoxTop.getChildren().add(selectGroupLabel);
        vBoxTop.getChildren().add(choiceBoxGroup);
        vBoxTop.getChildren().add(countOfTimeLabel);
        vBoxTop.getChildren().add(hBoxTime);
        vBoxTop.getChildren().add(startTestButton);

        Scene testSettingsScene = new Scene(anchorPane, 853, 569, Color.BLACK);
        primaryStage.setScene(testSettingsScene);

        plusOneExButton.setOnAction(event -> DataTestSettings.plusOne());

        minusOneExButton.setOnAction(event -> DataTestSettings.minusOne());

        plusOneMinButton.setOnAction(event -> CountdownTimer.plusOneMinute());

        minusOneMinButton.setOnAction(event -> CountdownTimer.minusOneMinute());

        backButton.setOnAction(event -> {
            try {
                chooseRepeatScene.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        startTestButton.setOnAction(event -> {
            try {
                dataTestSettings.downloadGroupName();
                if (groupName == null || testRepeaterController.checkIfGroupIsEmpty()) {
                    primaryStage.setScene(testSettingsScene);
                } else {
                    testRepeaterController.startTest();
                    testScene.start(primaryStage);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
