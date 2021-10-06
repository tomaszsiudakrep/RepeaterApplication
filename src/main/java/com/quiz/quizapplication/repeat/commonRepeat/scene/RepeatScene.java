package com.quiz.quizapplication.repeat.commonRepeat.scene;

import com.quiz.quizapplication.data.music.Music;
import com.quiz.quizapplication.data.timers.TimerCommon;
import com.quiz.quizapplication.DataFromDb;
import com.quiz.quizapplication.repeat.ChooseRepeatScene;
import com.quiz.quizapplication.repeat.commonRepeat.controller.CommonRepeatController;
import com.quiz.quizapplication.scene.background.BackgroundScene;
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

import java.sql.SQLException;

public class RepeatScene extends Application {

    private DataFromDb dataFromDb;
    private ChooseRepeatScene chooseRepeatScene;
    private final BackgroundScene backgroundScene = new BackgroundScene();
    CommonRepeatController commonRepeatController = new CommonRepeatController();
    public static TimerCommon timerCommon = new TimerCommon();

    public static int id;
    public static int getElementFromList = 0;
    public static VBox vBoxBottom;
    public static VBox vBoxTop;
    public static HBox bestResultHBox;
    public static HBox startTimerImmediatelyBox;
    public static HBox shuffleExercisesBox;
    public static Label idLabel;
    public static Label titleLabel;
    public static Label groupLabel;
    public static Label descriptionLabel;
    public static TextField titleTextField;
    public static TextField groupTextField;
    public static TextArea descriptionAreaText;
    public static TextField idTextField;
    public static Button nextExercisesButton;
    public static Button archiveExercisesButton;
    public static Button backButton;
    public static Button exampleSolutionButton;
    public static GridPane gridPane;
    public static Label timeLabel;
    public static RadioButton startTimerImmediatelyRadioButton;
    public static Label startTimerImmediatelyLabel;
    public static Button shuffleExercisesButton;
    public static Label shuffleExercisesLabel;
    public static Label bestResultLabel;
    public static Button saveTimeButton;


    @Override
    public void start(Stage primaryStage) throws Exception {
        dataFromDb = new DataFromDb();
        chooseRepeatScene = new ChooseRepeatScene();

        AnchorPane anchorPane = new AnchorPane();
            anchorPane.setPadding(new Insets(5, 5, 5, 5));
            anchorPane.setBackground(backgroundScene.defaultBackground());

        gridPane = new GridPane();
            gridPane.setAlignment(Pos.CENTER_RIGHT);
            gridPane.setPrefWidth(703);
            gridPane.setPrefHeight(500);

        vBoxBottom = new VBox();
            vBoxBottom.setAlignment(Pos.BOTTOM_CENTER);
            vBoxBottom.setPrefHeight(569);
            vBoxBottom.setPrefWidth(150);
            vBoxBottom.setStyle("-fx-background-color: #7961BE");

        vBoxTop = new VBox();
            vBoxTop.setPrefHeight(300);
            vBoxTop.setPrefWidth(150);
            vBoxTop.setStyle("-fx-background-color: #7961BE");

        anchorPane.getChildren().add(0, Music.audioHBox);
        anchorPane.getChildren().add(1, gridPane);
        anchorPane.getChildren().add(2, vBoxBottom);
        anchorPane.getChildren().add(3, vBoxTop);

        idLabel = new Label("Id");
            idLabel.setPrefWidth(150);
            idLabel.setPrefHeight(30);
            idLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false");
        idTextField = new TextField();
            idTextField.setPrefWidth(150);
            idTextField.setPrefHeight(30);
        titleLabel = new Label("Title");
            titleLabel.setPrefWidth(150);
            titleLabel.setPrefHeight(30);
            titleLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false");
        titleTextField = new TextField();
            titleTextField.setPrefWidth(150);
            titleTextField.setPrefHeight(30);
        groupLabel = new Label("Group");
            groupLabel.setPrefWidth(150);
            groupLabel.setPrefHeight(30);
            groupLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false");
        groupTextField = new TextField();
            groupTextField.setPrefWidth(150);
            groupTextField.setPrefHeight(30);
        timeLabel = new Label("Time");
            timeLabel.setPrefWidth(150);
            timeLabel.setPrefHeight(30);
            timeLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 10; -fx-text-fill: white;-fx-underline: false");
        startTimerImmediatelyRadioButton = new RadioButton();
            startTimerImmediatelyRadioButton.setPrefHeight(20);
            startTimerImmediatelyRadioButton.setPrefWidth(40);
        startTimerImmediatelyLabel = new Label();
            startTimerImmediatelyLabel.setTooltip(new Tooltip("if checked, the timer will start when the task is displayed"));
            startTimerImmediatelyLabel.setPrefWidth(110);
            startTimerImmediatelyLabel.setPrefHeight(20);
            startTimerImmediatelyLabel.setWrapText(true);
            startTimerImmediatelyLabel.setStyle("-fx-alignment: center; -fx-font-size: 12");
            startTimerImmediatelyLabel.setText("start timer imm.");
        shuffleExercisesButton = new Button("Shuffle");
            shuffleExercisesButton.setStyle("-fx-font-size: 10");
            shuffleExercisesButton.setPrefHeight(20);
            shuffleExercisesButton.setPrefWidth(50);
        shuffleExercisesLabel = new Label();
            shuffleExercisesLabel.setTooltip(new Tooltip("if clicked, list of exercises will be shuffle"));
            shuffleExercisesLabel.setPrefWidth(100);
            shuffleExercisesLabel.setPrefHeight(20);
            shuffleExercisesLabel.setWrapText(true);
            shuffleExercisesLabel.setStyle("-fx-alignment: center; -fx-font-size: 12");
            shuffleExercisesLabel.setText("shuffle");
        descriptionLabel = new Label("Description");
            descriptionLabel.setPrefHeight(20);
            descriptionLabel.setPrefWidth(400);
            descriptionLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false");
        descriptionAreaText = new TextArea();
            descriptionAreaText.setWrapText(true);
            descriptionAreaText.setPrefHeight(400);
            descriptionAreaText.setPrefWidth(400);
        nextExercisesButton = new Button("Next exercises");
            nextExercisesButton.setPrefWidth(400);
            nextExercisesButton.setPrefHeight(30);
            nextExercisesButton.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981a7");
        archiveExercisesButton = new Button("Archive");
            archiveExercisesButton.setPrefWidth(150);
            archiveExercisesButton.setPrefHeight(50);
            archiveExercisesButton.setStyle("-fx-background-color: #6857a5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981a7");
        backButton = new Button("Back");
            backButton.setPrefWidth(150);
            backButton.setPrefHeight(50);
            backButton.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981a7");
        exampleSolutionButton = new Button("Example solution");
            exampleSolutionButton.setPrefWidth(150);
            exampleSolutionButton.setPrefHeight(50);
            exampleSolutionButton.setStyle("-fx-background-color: #6857a5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981a7");
        bestResultHBox = new HBox();
            bestResultHBox.setAlignment(Pos.CENTER);
            bestResultHBox.setPrefWidth(150);
            bestResultHBox.setPrefHeight(30);
        bestResultLabel = new Label("BEST TIME");
            bestResultLabel.setStyle("-fx-font-size:10; -fx-text-fill:white ");
            bestResultLabel.setPrefHeight(30);
            bestResultLabel.setPrefWidth(100);
            bestResultLabel.setWrapText(true);
        saveTimeButton = new Button("Save");
            saveTimeButton.setPrefHeight(30);
            saveTimeButton.setPrefWidth(50);
            saveTimeButton.setWrapText(true);

        bestResultHBox.getChildren().add(0, bestResultLabel);
        bestResultHBox.getChildren().add(1, saveTimeButton);

        startTimerImmediatelyBox = new HBox();
            startTimerImmediatelyBox.getChildren().add(0, startTimerImmediatelyRadioButton);
            startTimerImmediatelyBox.getChildren().add(1, startTimerImmediatelyLabel);
        shuffleExercisesBox = new HBox();
            shuffleExercisesBox.getChildren().add(0, shuffleExercisesButton);
            shuffleExercisesBox.getChildren().add(1, shuffleExercisesLabel);

        vBoxBottom.getChildren().add(0, backButton);

        vBoxTop.getChildren().add(0, idLabel);
        vBoxTop.getChildren().add(1, idTextField);
        vBoxTop.getChildren().add(2, titleLabel);
        vBoxTop.getChildren().add(3, titleTextField);
        vBoxTop.getChildren().add(4, groupLabel);
        vBoxTop.getChildren().add(5, groupTextField);
        vBoxTop.getChildren().add(6, timeLabel);
        vBoxTop.getChildren().add(7, bestResultHBox);
        vBoxTop.getChildren().add(8, TimerCommon.vBoxTime);
        vBoxTop.getChildren().add(9, archiveExercisesButton);
        vBoxTop.getChildren().add(10, exampleSolutionButton);
        vBoxTop.getChildren().add(11, startTimerImmediatelyBox);
        vBoxTop.getChildren().add(12, shuffleExercisesBox);

        gridPane.add(descriptionLabel, 1, 0);
        gridPane.add(descriptionAreaText, 1 ,1);
        gridPane.add(nextExercisesButton, 1, 2);

        Scene sceneRepeat = new Scene(anchorPane, 853, 569, Color.BLACK);
        primaryStage.setScene(sceneRepeat);

        shuffleExercisesButton.setOnAction(event -> commonRepeatController.shuffleListToCommonRepeat());

        saveTimeButton.setOnAction(event -> {
            try {
                commonRepeatController.saveTime();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        backButton.setOnAction(e -> {
            try {
                chooseRepeatScene.start(primaryStage);
                TimerCommon.reset();
                commonRepeatController.initializeCounter();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

//        archiveExercisesButton.setOnAction(e -> {
//            try {
//                repeatSceneController.archiveExercise();
//            } catch (IOException exception) {
//                exception.printStackTrace();
//            }
//        });

//        exampleSolutionButton.setOnAction(e -> repeatSceneController.exampleSolution());

        nextExercisesButton.setOnAction(event ->
        {
            try {
                commonRepeatController.nextExercises();
//
//                    int timeToShow = saveAndLoadBestResultTime.loadTimeResult(idTextField.getText());
//                    String resultToShow = saveAndLoadBestResultTime.convertElapsedTimeToString(timeToShow);
//                    bestResultLabel.setText("BEST RESULT " + resultToShow);
            } catch (SQLException e) {
                System.out.println("ups wrong: " + e);
            }
        });
    }

}
