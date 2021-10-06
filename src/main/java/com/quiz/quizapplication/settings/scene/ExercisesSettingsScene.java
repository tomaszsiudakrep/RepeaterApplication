package com.quiz.quizapplication.settings.scene;

import com.quiz.quizapplication.scene.background.BackgroundScene;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ExercisesSettingsScene extends Application {

    private final BackgroundScene backgroundScene = new BackgroundScene();

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();
            anchorPane.setPadding(new Insets(5, 5, 5, 5));
            anchorPane.setBackground(backgroundScene.defaultBackground());

        anchorPane.getChildren().add(0, MainSettingsScene.vBoxBottom);
        anchorPane.getChildren().add(1, MainSettingsScene.vBoxTop);

        GridPane gridPane = new GridPane();
            gridPane.setAlignment(Pos.TOP_RIGHT);
            gridPane.setPrefWidth(703);
            gridPane.setPrefHeight(569);
        anchorPane.getChildren().add(0, gridPane);

        Scene exSettScene = new Scene(anchorPane, 853, 569, Color.BLACK);
        primaryStage.setScene(exSettScene);
    }

}
