package com.quiz.quizapplication.scene.addScene;

import com.quiz.quizapplication.RepeatExercisesApplication;
import com.quiz.quizapplication.scene.BackgroundScene;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ChooseAddScene extends Application {

    private final BackgroundScene backgroundScene = new BackgroundScene();
    private RepeatExercisesApplication repeatExercisesApplication = new RepeatExercisesApplication();
    private AddExercisesScene addExercisesScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        addExercisesScene = new AddExercisesScene();

        AnchorPane anchorPane = new AnchorPane();
            anchorPane.setPadding(new Insets(5, 5, 5, 5));
            anchorPane.setBackground(backgroundScene.defaultBackground());

        VBox vBoxBottom = new VBox();
            vBoxBottom.setAlignment(Pos.BOTTOM_CENTER);
            vBoxBottom.setPrefHeight(569);
            vBoxBottom.setPrefWidth(150);
            vBoxBottom.setStyle("-fx-background-color: #7961BE");
        VBox vBoxTop = new VBox();
            vBoxTop.setPrefHeight(300);
            vBoxTop.setPrefWidth(150);
            vBoxTop.setStyle("-fx-background-color: #7961BE");

        anchorPane.getChildren().add(0, vBoxBottom);
        anchorPane.getChildren().add(1, vBoxTop);

        Button addExercise = new Button("Add exercises");
            addExercise.setPrefWidth(150);
            addExercise.setPrefHeight(50);
            addExercise.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981A7");
        Button addImportantInfo = new Button("Add important information");
            addImportantInfo.setPrefWidth(150);
            addImportantInfo.setPrefHeight(50);
            addImportantInfo.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981A7");
        Button backToMenu = new Button("Back to menu");
            backToMenu.setPrefWidth(150);
            backToMenu.setPrefHeight(50);
            backToMenu.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981A7");

        vBoxBottom.getChildren().add(0, backToMenu);

        vBoxTop.getChildren().add(0, addExercise);
        vBoxTop.getChildren().add(1, addImportantInfo);

        Scene scene = new Scene(anchorPane, 853, 569, Color.BLACK);
        primaryStage.setScene(scene);


        backToMenu.setOnAction(event -> {
            try {
                repeatExercisesApplication.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        addExercise.setOnAction(event -> {
            try {
                addExercisesScene.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
}
