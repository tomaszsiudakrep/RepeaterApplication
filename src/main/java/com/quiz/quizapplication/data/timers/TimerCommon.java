package com.quiz.quizapplication.data.timers;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javax.swing.*;

public class TimerCommon {

    public static VBox vBoxTime;
    public static Label timeLabel = new Label();
    public static Button startButton = new Button("START");
    public static Button resetButton = new Button("RESET");
    public static int elapsedTime = 0;
    public static int hours = 0;
    public static int minutes = 0;
    public static int seconds = 0;
    public static boolean started = false;
    public static String hours_string = String.format("%02d", hours);
    public static String minutes_string = String.format("%02d", minutes);
    public static String seconds_string = String.format("%02d", seconds);

    public static Timer timer = new Timer(1000, e -> Platform.runLater(() -> {
        elapsedTime += 1000;
        hours = (elapsedTime / 3600000);
        minutes = (elapsedTime / 60000) % 60;
        seconds = (elapsedTime / 1000) % 60;
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);
        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
    }));

    public TimerCommon() {
        vBoxTime = new VBox();
            vBoxTime.setPrefWidth(150);
            vBoxTime.setPrefHeight(100);
        timeLabel.setPrefWidth(150);
            timeLabel.setPrefHeight(50);
            timeLabel.setStyle("-fx-background-color: white; -fx-font-size: 20; -fx-text-fill: #6857a5;-fx-underline: false; -fx-text-alignment: right; -fx-alignment: center");
            timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        startButton.setPrefWidth(150);
            startButton.setPrefHeight(25);
        resetButton.setPrefWidth(150);
            resetButton.setPrefHeight(25);

        vBoxTime.getChildren().add(0, timeLabel);
        vBoxTime.getChildren().add(1, startButton);
        vBoxTime.getChildren().add(2, resetButton);

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
        elapsedTime = 0;
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
}
