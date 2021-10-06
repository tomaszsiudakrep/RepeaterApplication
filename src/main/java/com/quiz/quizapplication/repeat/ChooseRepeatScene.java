package com.quiz.quizapplication.scene.repeatScene;

import com.quiz.quizapplication.LauncherApplication;
import com.quiz.quizapplication.controller.GroupChoiceBoxController;
import com.quiz.quizapplication.controller.RepeatSceneController;
import com.quiz.quizapplication.exercises.data.DataFromDb;
import com.quiz.quizapplication.scene.BackgroundScene;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChooseRepeatScene extends Application {

    private final BackgroundScene backgroundScene = new BackgroundScene();
    DataFromDb dataFromDb = new DataFromDb();
    GroupChoiceBoxController groupChoiceBoxController = new GroupChoiceBoxController();
    RepeatSceneController repeatSceneController = new RepeatSceneController();
    private final LauncherApplication launcherApplication = new LauncherApplication();
    private RepeatScene repeatScene;
    private TestSettingsScene testSettingsScene;
    public static List<Integer> list = new ArrayList<>();
    public static ChoiceBox<String> groupChoiceBox;

    public ChooseRepeatScene() throws SQLException {
        groupChoiceBox = new ChoiceBox<>(groupChoiceBoxController.create());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        repeatScene = new RepeatScene();
        testSettingsScene = new TestSettingsScene();

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
            vBoxTop.setStyle("-fx-background-color: #7961be");



        Label repeatLabel = new Label("Repeat");
            repeatLabel.setPrefHeight(15);
            repeatLabel.setPrefWidth(150);
            repeatLabel.setStyle("-fx-border-width: 1; -fx-background-color: #513BA2; -fx-text-fill: white; -fx-font-size: 12; -fx-alignment: center");
        Button commonRepeat = new Button("Common repeat");
            commonRepeat.setPrefWidth(150);
            commonRepeat.setPrefHeight(50);
            commonRepeat.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981A7");
        groupChoiceBox.setPrefWidth(150);
            groupChoiceBox.setPrefHeight(30);
            groupChoiceBox.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981A7");
        Label timeRepeaterLabel = new Label("Time repeater");
            timeRepeaterLabel.setPrefHeight(15);
            timeRepeaterLabel.setPrefWidth(150);
            timeRepeaterLabel.setStyle("-fx-border-width: 1; -fx-background-color: #513BA2; -fx-text-fill: white; -fx-font-size: 12; -fx-alignment: center");
        Button timeRepeater = new Button("Time repeater");
            timeRepeater.setPrefWidth(150);
            timeRepeater.setPrefHeight(50);
            timeRepeater.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981A7");
        Label testRepeaterLabel = new Label("Test repeater");
            testRepeaterLabel.setPrefHeight(15);
            testRepeaterLabel.setPrefWidth(150);
            testRepeaterLabel.setStyle("-fx-border-width: 1; -fx-background-color: #513BA2; -fx-text-fill: white; -fx-font-size: 12; -fx-alignment: center");
        Button testKnowledgeButton = new Button("TEST");
            testKnowledgeButton.setPrefWidth(150);
            testKnowledgeButton.setPrefHeight(50);
            testKnowledgeButton.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981A7");



        Button backToMenu = new Button("Back to menu");
            backToMenu.setPrefWidth(150);
            backToMenu.setPrefHeight(50);
            backToMenu.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981A7");

        anchorPane.getChildren().add(0, vBoxBottom);
        anchorPane.getChildren().add(1, vBoxTop);



        vBoxBottom.getChildren().add(0, backToMenu);

        vBoxTop.getChildren().add(0, repeatLabel);
        vBoxTop.getChildren().add(1, commonRepeat);
        vBoxTop.getChildren().add(2, groupChoiceBox);
        vBoxTop.getChildren().add(3, timeRepeaterLabel);
        vBoxTop.getChildren().add(4, timeRepeater);
        vBoxTop.getChildren().add(5, testRepeaterLabel);
        vBoxTop.getChildren().add(6, testKnowledgeButton);

        Scene chooseRepeatScene = new Scene(anchorPane, 853, 569, Color.BLACK);
        primaryStage.setScene(chooseRepeatScene);

        backToMenu.setOnAction(e -> {
            try {
                launcherApplication.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        commonRepeat.setOnAction(event ->
        {
            try {
                list = repeatSceneController.createListOfExercises();
                repeatScene.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        testKnowledgeButton.setOnAction(event -> {
            try {
                testSettingsScene.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
