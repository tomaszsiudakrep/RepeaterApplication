package com.quiz.quizapplication.scene;

import com.quiz.quizapplication.LauncherApplication;
import com.quiz.quizapplication.importantInformation.scene.add.AddGroupInformationScene;
import com.quiz.quizapplication.importantInformation.scene.add.AddInformationScene;
import com.quiz.quizapplication.exercises.scene.add.AddExercisesScene;
import com.quiz.quizapplication.exercises.scene.add.AddGroupScene;
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

public class ChooseAddScene extends Application {

    private final BackgroundScene backgroundScene = new BackgroundScene();
    private final LauncherApplication launcherApplication = new LauncherApplication();
    private AddGroupInformationScene addGroupInformationScene;
    private AddExercisesScene addExercisesScene;
    private AddGroupScene addGroupScene;
    private AddInformationScene addInformationScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        addExercisesScene = new AddExercisesScene();
        addGroupScene = new AddGroupScene();
        addGroupInformationScene = new AddGroupInformationScene();
        addInformationScene = new AddInformationScene();

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

        Label exercisesLabel = new Label("Exercises");
            exercisesLabel.setPrefWidth(150);
            exercisesLabel.setPrefHeight(15);
            exercisesLabel.setStyle("-fx-background-color: #8981A7; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false");
            exercisesLabel.setGraphic(GlyphsDude.createIcon(FontAwesomeIcon.PLUS, "15px"));
        Button addExercise = new Button("Add exercise");
            addExercise.setPrefWidth(150);
            addExercise.setPrefHeight(25);
            addExercise.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false; -fx-border-width:1; -fx-border-color:#8981A7");
        Button addGroup = new Button("Add group exercise");
            addGroup.setPrefWidth(150);
            addGroup.setPrefHeight(25);
            addGroup.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false; -fx-border-width:1; -fx-border-color:#8981A7");
        Label importantInformationLabel = new Label("Important information");
            importantInformationLabel.setPrefWidth(150);
            importantInformationLabel.setPrefHeight(15);
            importantInformationLabel.setStyle("-fx-background-color: #8981A7; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false");
            importantInformationLabel.setGraphic(GlyphsDude.createIcon(FontAwesomeIcon.PLUS, "15px"));
        Button addImportantInfoButton = new Button("Add important information");
            addImportantInfoButton.setPrefWidth(150);
            addImportantInfoButton.setPrefHeight(25);
            addImportantInfoButton.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false; -fx-border-width:1; -fx-border-color:#8981A7");
        Button addGroupImportantInformation = new Button("Add group important");
            addGroupImportantInformation.setPrefWidth(150);
            addGroupImportantInformation.setPrefHeight(25);
            addGroupImportantInformation.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false; -fx-border-width:1; -fx-border-color:#8981A7");
        Label tasksLabel = new Label("Tasks");
            tasksLabel.setPrefWidth(150);
            tasksLabel.setPrefHeight(15);
            tasksLabel.setStyle("-fx-background-color: #8981A7; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false");
            tasksLabel.setGraphic(GlyphsDude.createIcon(FontAwesomeIcon.PLUS, "15px"));
        Button addTaskButton = new Button("Add task");
            addTaskButton.setPrefWidth(150);
            addTaskButton.setPrefHeight(25);
            addTaskButton.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false; -fx-border-width:1; -fx-border-color:#8981a7");
        Button addGroupTaskButton = new Button("Add group task");
            addGroupTaskButton.setPrefWidth(150);
            addGroupTaskButton.setPrefHeight(25);
            addGroupTaskButton.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false; -fx-border-width:1; -fx-border-color:#8981A7");
        Button backToMenu = new Button("Back to menu");
            backToMenu.setPrefWidth(150);
            backToMenu.setPrefHeight(50);
            backToMenu.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981A7");

        vBoxBottom.getChildren().add(backToMenu);

        vBoxTop.getChildren().add(exercisesLabel);
        vBoxTop.getChildren().add(addExercise);
        vBoxTop.getChildren().add(addGroup);
        vBoxTop.getChildren().add(importantInformationLabel);
        vBoxTop.getChildren().add(addImportantInfoButton);
        vBoxTop.getChildren().add(addGroupImportantInformation);
        vBoxTop.getChildren().add(tasksLabel);
        vBoxTop.getChildren().add(addTaskButton);
        vBoxTop.getChildren().add(addGroupTaskButton);

        Scene scene = new Scene(anchorPane, 853, 569, Color.BLACK);
        primaryStage.setScene(scene);


        backToMenu.setOnAction(event -> {
            try {
                launcherApplication.start(primaryStage);
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

        addGroup.setOnAction(event -> {
            try {
                addGroupScene.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        addGroupImportantInformation.setOnAction(event -> {
            try {
                addGroupInformationScene.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        addImportantInfoButton.setOnAction(event -> {
            try {
                addInformationScene.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
}
