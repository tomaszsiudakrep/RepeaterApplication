package com.quiz.quizapplication.settings.scene;

import com.quiz.quizapplication.settings.controller.MainSettingsController;
import com.quiz.quizapplication.LauncherApplication;
import com.quiz.quizapplication.scene.background.BackgroundScene;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainSettingsScene extends Application {

    LauncherApplication launcherApplication = new LauncherApplication();
    MainSettingsController mainSettingsController = new MainSettingsController();
    private final BackgroundScene backgroundScene = new BackgroundScene();
    private DataBaseSettingsScene dataBaseSettingsScene;
    private GroupSettingsScene groupSettingsScene;
    private ExercisesSettingsScene exercisesSettingsScene;
    private MailSettingsScene mailSettingsScene;
    public static Button backToMenuButton;
    public static Button groupSettingsButton;
    public static Button exercisesSettingsButton;
    public static Button mailSettingsButton;
    public static Button importantInformationSettingsButton;
    public static Button dataBaseSettingsButton;
    public static Button helpButton;
    public static Button musicButton;
    public static VBox vBoxBottom;
    public static VBox vBoxTop;
    public static Label settingsNameLabel;

    @Override
    public void start(Stage primaryStage) throws Exception {
        dataBaseSettingsScene = new DataBaseSettingsScene();
        groupSettingsScene = new GroupSettingsScene();
        exercisesSettingsScene = new ExercisesSettingsScene();
        mailSettingsScene = new MailSettingsScene();

        AnchorPane anchorPane = new AnchorPane();
            anchorPane.setPadding(new Insets(5, 5, 5, 5));
            anchorPane.setBackground(backgroundScene.defaultBackground());

        settingsNameLabel = new Label("Settings");
            settingsNameLabel.setPrefWidth(150);
            settingsNameLabel.setPrefHeight(25);
            settingsNameLabel.setStyle("-fx-background-color: #513ba2; -fx-text-fill: white;-fx-underline: false; -fx-font-size: 15; -fx-alignment: center; -fx-border-width:1; -fx-border-color:#8981A7");
        backToMenuButton = new Button("Back to menu");
            backToMenuButton.setPrefWidth(150);
            backToMenuButton.setPrefHeight(50);
            backToMenuButton.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981A7");
        groupSettingsButton = new Button("Group");
            groupSettingsButton.setPrefWidth(150);
            groupSettingsButton.setPrefHeight(25);
            groupSettingsButton.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981A7");
        exercisesSettingsButton = new Button("Exercises");
            exercisesSettingsButton.setPrefWidth(150);
            exercisesSettingsButton.setPrefHeight(25);
            exercisesSettingsButton.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981A7");
        importantInformationSettingsButton = new Button("Important information");
            importantInformationSettingsButton.setPrefWidth(150);
            importantInformationSettingsButton.setPrefHeight(25);
            importantInformationSettingsButton.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981A7");
        dataBaseSettingsButton = new Button("Data base");
            dataBaseSettingsButton.setPrefWidth(150);
            dataBaseSettingsButton.setPrefHeight(25);
            dataBaseSettingsButton.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981A7");
        helpButton = new Button("Help");
            helpButton.setPrefWidth(150);
            helpButton.setPrefHeight(25);
            helpButton.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981a7");
        musicButton = new Button("Music");
            musicButton.setPrefWidth(150);
            musicButton.setPrefHeight(25);
            musicButton.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981a7");
        mailSettingsButton = new Button("Mail");
            mailSettingsButton.setPrefWidth(150);
            mailSettingsButton.setPrefHeight(25);
            mailSettingsButton.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981A7");
        vBoxBottom = new VBox();
            vBoxBottom.setAlignment(Pos.BOTTOM_CENTER);
            vBoxBottom.setPrefHeight(569);
            vBoxBottom.setPrefWidth(150);
            vBoxBottom.setStyle("-fx-background-color: #7961BE");
        vBoxTop = new VBox();
            vBoxTop.setPrefHeight(300);
            vBoxTop.setPrefWidth(150);
            vBoxTop.setStyle("-fx-background-color: #7961BE");

            anchorPane.getChildren().add(0, vBoxBottom);
            anchorPane.getChildren().add(1, vBoxTop);

        GridPane gridPane = new GridPane();
            gridPane.setAlignment(Pos.CENTER_RIGHT);
            gridPane.setPrefWidth(703);
            gridPane.setPrefHeight(569);
            anchorPane.getChildren().add(0, gridPane);

        vBoxBottom.getChildren().add(0, backToMenuButton);

        vBoxTop.getChildren().add(0, settingsNameLabel);
        vBoxTop.getChildren().add(1, groupSettingsButton);
        vBoxTop.getChildren().add(2, exercisesSettingsButton);
        vBoxTop.getChildren().add(3, importantInformationSettingsButton);
        vBoxTop.getChildren().add(4, dataBaseSettingsButton);
        vBoxTop.getChildren().add(5, helpButton);
        vBoxTop.getChildren().add(6, musicButton);
        vBoxTop.getChildren().add(7, mailSettingsButton);

        Scene settingsScene = new Scene(anchorPane, 853, 569, Color.BLACK);
        primaryStage.setScene(settingsScene);

        groupSettingsButton.setOnAction(e -> {
            try {
                groupSettingsScene.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        exercisesSettingsButton.setOnAction(event -> {
            try {
                exercisesSettingsScene.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        dataBaseSettingsButton.setOnAction(event -> {
            try {
                dataBaseSettingsScene.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        mailSettingsButton.setOnAction(event -> {
            try {
                mailSettingsScene.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        backToMenuButton.setOnAction(e -> {
            try {
                mainSettingsController.saveSettingsToFile();
                launcherApplication.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }

}
