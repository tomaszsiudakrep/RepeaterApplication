package com.quiz.quizapplication.tasks.scene;

import com.quiz.quizapplication.LauncherApplication;
import com.quiz.quizapplication.scene.background.BackgroundScene;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainTasksScene extends Application {

    BackgroundScene backgroundScene = new BackgroundScene();
    LauncherApplication launcherApplication = new LauncherApplication();
    AddTasksScene addTasksScene;

    public static Button backToMenuButton;
    public static Button toDoListButton;
    public static Button inProgressListButton;
    public static Button doneListButton;
    public static Button addTaskButton;
    public static VBox vBoxBottom;
    public static VBox vBoxTop;
    public static Label addLabel;
    public static Label listLabel;

    @Override
    public void start(Stage primaryStage) throws Exception {
        addTasksScene = new AddTasksScene();

        AnchorPane anchorPane = new AnchorPane();
            anchorPane.setPadding(new Insets(5, 5, 5, 5));
            anchorPane.setBackground(backgroundScene.defaultBackground());

        addLabel = new Label("Add task");
            addLabel.setPrefWidth(150);
            addLabel.setPrefHeight(25);
            addLabel.setStyle("-fx-background-color: #513ba2; -fx-text-fill: white;-fx-underline: false; -fx-alignment: center; -fx-border-width:1; -fx-border-color:#8981A7");
        listLabel = new Label("Tasks lists");
            listLabel.setPrefWidth(150);
            listLabel.setPrefHeight(25);
            listLabel.setStyle("-fx-background-color: #513ba2; -fx-text-fill: white;-fx-underline: false; -fx-alignment: center; -fx-border-width:1; -fx-border-color:#8981A7");
        addTaskButton = new Button("");
            addTaskButton.setPrefWidth(150);
            addTaskButton.setPrefHeight(50);
            addTaskButton.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false; -fx-border-width:1; -fx-border-color:#8981A7");
            addTaskButton.setGraphic(GlyphsDude.createIcon(FontAwesomeIcon.PLUS, "20px"));
        backToMenuButton = new Button("Back to menu");
            backToMenuButton.setPrefWidth(150);
            backToMenuButton.setPrefHeight(50);
            backToMenuButton.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false; -fx-border-width:1; -fx-border-color:#8981A7");
        toDoListButton = new Button("To do");
            toDoListButton.setPrefWidth(150);
            toDoListButton.setPrefHeight(50);
            toDoListButton.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false; -fx-border-width:1; -fx-border-color:#8981A7");
        inProgressListButton = new Button("In progress");
            inProgressListButton.setPrefWidth(150);
            inProgressListButton.setPrefHeight(50);
            inProgressListButton.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false; -fx-border-width:1; -fx-border-color:#8981A7");
        doneListButton = new Button("Done");
            doneListButton.setPrefWidth(150);
            doneListButton.setPrefHeight(50);
            doneListButton.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false; -fx-border-width:1; -fx-border-color:#8981A7");

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

        vBoxBottom.getChildren().add(0, backToMenuButton);

        vBoxTop.getChildren().add(0, addLabel);
        vBoxTop.getChildren().add(1, addTaskButton);
        vBoxTop.getChildren().add(2, listLabel);
        vBoxTop.getChildren().add(3, toDoListButton);
        vBoxTop.getChildren().add(4, inProgressListButton);
        vBoxTop.getChildren().add(5, doneListButton);

        Scene settingsScene = new Scene(anchorPane, 853, 569, Color.BLACK);
        primaryStage.setScene(settingsScene);

        backToMenuButton.setOnAction(event -> {
            try {
                launcherApplication.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        addTaskButton.setOnAction(event -> {
            try {
                addTasksScene.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
}
