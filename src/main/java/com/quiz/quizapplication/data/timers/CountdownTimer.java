package com.quiz.quizapplication.data.timers;

import com.quiz.quizapplication.controller.CountdownTimerController;
import com.quiz.quizapplication.repeat.testKnowledge.scene.TestSettingsScene;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javax.swing.*;

public class CountdownTimer {

    CountdownTimerController countdownTimerController = new CountdownTimerController();

    public static VBox vBoxTime;
    public static HBox hBoxTimeButton;
    public static Label timeLabel = new Label();
    public static Button startButton = new Button("START");
    public static Button resetButton = new Button("RESET");
    public static int elapsedTime;
    public static int hours = 0;
    public static int minutes = 0;
    public static int seconds = 0;
    public static boolean started = false;
    public static String hours_string = String.format("%02d", hours);
    public static String minutes_string = String.format("%02d", minutes);
    public static String seconds_string = String.format("%02d", seconds);

    public static Timer timer = new Timer(1000, e -> Platform.runLater(() -> {
        elapsedTime -= 1000;
        hours = (elapsedTime / 3600000);
        minutes = (elapsedTime / 60000) % 60;
        seconds = (elapsedTime / 1000) % 60;
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);
        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        if (elapsedTime == 0) {
            stopTimer();
            started = false;
            startButton.setText("START");
            timeLabel.setText("END OF TIME");
        }
    }));

    public CountdownTimer() {
        elapsedTime = countdownTimerController.convertTime();

        vBoxTime = new VBox();
            vBoxTime.setPrefWidth(400);
            vBoxTime.setPrefHeight(75);
        hBoxTimeButton = new HBox();
            hBoxTimeButton.setPrefHeight(25);
            hBoxTimeButton.setPrefWidth(400);
        timeLabel.setPrefWidth(400);
            timeLabel.setPrefHeight(50);
            timeLabel.setStyle("-fx-background-color: white; -fx-font-size: 30; -fx-text-fill: #6857a5;-fx-underline: false; -fx-text-alignment: right; -fx-alignment: center");
            timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        startButton.setPrefWidth(200);
            startButton.setPrefHeight(25);
        resetButton.setPrefWidth(200);
            resetButton.setPrefHeight(25);

        hBoxTimeButton.getChildren().add(startButton);
        hBoxTimeButton.getChildren().add(resetButton);

        vBoxTime.getChildren().add(0, timeLabel);
        vBoxTime.getChildren().add(1, hBoxTimeButton);

        startButton.setOnAction(event ->  start());
        resetButton.setOnAction(event -> reset());
    }

    public static void start() {
        if (!started) {
            started = true;
            startButton.setText("STOP");
            startTimer();
        } else {
            started = false;
            startButton.setText("START");
            stopTimer();
        }
    }

    public static void reset() {
        stopTimer();
        started = false;
        elapsedTime = elapsedTime;
        seconds = 0;
        minutes = 0;
        hours = 0;
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);
        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        startButton.setText("START");

    }

    public static void startTimer() {
        timer.start();
    }

    public static void stopTimer() {
        timer.stop();
    }

    public static void plusOneMinute() {
        TestSettingsScene.time++;
        TestSettingsScene.countOfTimeToTestLabel.setText(TestSettingsScene.time + "");
    }

    public static void minusOneMinute() {
        TestSettingsScene.time--;
        if (TestSettingsScene.time < 0) TestSettingsScene.time = 0;
        TestSettingsScene.countOfTimeToTestLabel.setText(TestSettingsScene.time + "");
    }

}
