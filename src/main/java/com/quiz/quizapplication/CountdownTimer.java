//package com.quiz.quizapplication.scene.settingsScene;
//
//import com.quiz.quizapplication.Timer;
//import com.quiz.quizapplication.RepeatExercisesApplication;
//import com.quiz.quizapplication.database.GroupToDb;
//import com.quiz.quizapplication.scene.BackgroundScene;
//import javafx.application.Application;
//import javafx.application.Platform;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Label;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.GridPane;
//import javafx.scene.paint.Color;
//import javafx.stage.Stage;
//
//import java.awt.event.ActionEvent;
//
//public class CountdownTimer extends Application {
//
//    private AnchorPane anchorPane = new AnchorPane();
//    private BackgroundScene backgroundScene = new BackgroundScene();
//    private GroupToDb groupToDb = new GroupToDb();
//    private GridPane gridPane;
//    private MainSettingsScene mainSettingsScene = new MainSettingsScene();
//    private RepeatExercisesApplication repeatExercisesApplication = new RepeatExercisesApplication();
//    private ExercisesSettings exercisesSettings = new ExercisesSettings();
//
//
//    javafx.scene.control.Button startButton = new javafx.scene.control.Button("START");
//    int elapsedTime;
//    int hours;
//    int minutes;
//    int seconds;
//    boolean started = false;
//    String hours_string = String.format("%02d", hours);
//    String minutes_string = String.format("%02d", minutes);
//    String seconds_string = String.format("%02d", seconds);
//    Label timeLabel = new Label(hours_string + ":" + minutes_string + ":" + seconds_string);
//
//    Timer timer = new Timer(1000, new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            Platform.runLater(new Runnable() {
//                @Override
//                public void run() {
//                    elapsedTime -= 1000;
//                    hours = (elapsedTime / 3600000);
//                    minutes = (elapsedTime / 60000) % 60;
//                    seconds = (elapsedTime / 1000) % 60;
//                    seconds_string = String.format("%02d", seconds);
//                    minutes_string = String.format("%02d", minutes);
//                    hours_string = String.format("%02d", hours);
//                    timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
//                    if (hours == 00 & minutes == 00 & seconds == 00) {
//                        try {
//                            stopTimer();
//                            startButton.setText("END OF TIME");
//                        } catch (Exception exception) {
//                            exception.printStackTrace();
//                        }
//                    }
//                }
//            });
//
//        }
//    });
//
//
//    void stopTimer() throws Exception {
//        timer.stop();
//    }
//
//    void startTimer() {
//        timer.start();
//    }
//
//    void restart() {
//
//    }
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//
//        minutes = min();
//        hours = min();
//        seconds = min();
//        elapsedTime = elaps();
//
//        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
//
//        anchorPane = new AnchorPane();
//            anchorPane.setPadding(new Insets(5, 5, 5, 5));
//            anchorPane.setBackground(backgroundScene.defaultBackground());
//
//        gridPane = new GridPane();
//            gridPane.setAlignment(Pos.TOP_RIGHT);
//            gridPane.setPrefWidth(853);
//            gridPane.setPrefHeight(569);
//            anchorPane.getChildren().add(0, gridPane);
//
//            timeLabel.setPrefWidth(300);
//            timeLabel.setPrefHeight(300);
//            timeLabel.setStyle("-fx-font-size: 20");
//
//            startButton.setPrefWidth(300);
//            startButton.setPrefHeight(300);
//
//            gridPane.add(timeLabel, 1, 1);
//            gridPane.add(startButton, 1, 2);
//
//        Scene importantInfoSettings = new Scene(anchorPane, 853, 569, Color.BLACK);
//
//        primaryStage.setScene(importantInfoSettings);
//
//        startButton.setOnAction(event ->
//        {
//                if (started == false) {
//                    started = true;
//                    startButton.setText("STOP");
//                    startTimer();
//                } else {
//                    started = false;
//                    startButton.setText("START");
//                    stopTimer();
//                }
//        });
//    }
//
//    public int min() {
//        return 2;
//    }
//    public int elaps() {
//        return 81000;
//    }
//}
