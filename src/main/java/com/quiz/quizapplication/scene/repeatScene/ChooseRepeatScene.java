package com.quiz.quizapplication.scene.repeatScene;

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

public class ChooseRepeatScene extends Application {

    private final BackgroundScene backgroundScene = new BackgroundScene();
    private final RepeatExercisesApplication repeatExercisesApplication = new RepeatExercisesApplication();
    private RepeatScene repeatScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        repeatScene = new RepeatScene();

        AnchorPane anchorPane = new AnchorPane();
            anchorPane.setPadding(new Insets(5, 5, 5, 5));
            anchorPane.setBackground(backgroundScene.defaultBackground());

        VBox vBoxBottom = new VBox();
            vBoxBottom.setPrefHeight(569);
            vBoxBottom.setPrefWidth(150);
            vBoxBottom.setStyle("-fx-background-color: #7961BE");
            vBoxBottom.setAlignment(Pos.BOTTOM_CENTER);

        VBox vBoxTop = new VBox();
            vBoxTop.setPrefHeight(300);
            vBoxTop.setPrefWidth(150);
            vBoxTop.setStyle("-fx-background-color: #7961BE");

        Button testKnowledgeButton = new Button("TEST");
            testKnowledgeButton.setPrefWidth(150);
            testKnowledgeButton.setPrefHeight(50);
            testKnowledgeButton.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981A7");
        Button commonRepeat = new Button("Common repeat");
            commonRepeat.setPrefWidth(150);
            commonRepeat.setPrefHeight(50);
            commonRepeat.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981A7");
        Button randomRepeat =  new Button("Random repeat");
            randomRepeat.setPrefWidth(150);
            randomRepeat.setPrefHeight(50);
            randomRepeat.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981A7");
        Button groupRepeat = new Button("Group repeat");
            groupRepeat.setPrefWidth(150);
            groupRepeat.setPrefHeight(50);
            groupRepeat.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981A7");
        Button randomGroupRepeat = new Button("Random group repeat");
            randomGroupRepeat.setPrefWidth(150);
            randomGroupRepeat.setPrefHeight(50);
            randomGroupRepeat.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981A7");
        Button timeRepeater = new Button("Time repeater");
            timeRepeater.setPrefWidth(150);
            timeRepeater.setPrefHeight(50);
            timeRepeater.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981A7");
        Button backToMenu = new Button("Back to menu");
            backToMenu.setPrefWidth(150);
            backToMenu.setPrefHeight(50);
            backToMenu.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981A7");

        anchorPane.getChildren().add(0, vBoxBottom);
        anchorPane.getChildren().add(1, vBoxTop);

        vBoxBottom.getChildren().add(0, backToMenu);

        vBoxTop.getChildren().add(0, commonRepeat);
        vBoxTop.getChildren().add(1, randomRepeat);
//        vBoxTop.getChildren().add(2, GroupChoiceBox.choiceBox);
        vBoxTop.getChildren().add(2, groupRepeat);
        vBoxTop.getChildren().add(3, randomGroupRepeat);
        vBoxTop.getChildren().add(4, timeRepeater);
        vBoxTop.getChildren().add(5, testKnowledgeButton);

        Scene chooseRepeatScene = new Scene(anchorPane, 853, 569, Color.BLACK);
        primaryStage.setScene(chooseRepeatScene);

        backToMenu.setOnAction(e -> {
            try {
                repeatExercisesApplication.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        commonRepeat.setOnAction(event ->
        {
            try {
                repeatScene.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
