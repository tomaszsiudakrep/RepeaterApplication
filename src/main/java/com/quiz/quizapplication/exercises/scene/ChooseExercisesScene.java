package com.quiz.quizapplication.exercises.scene;

import com.quiz.quizapplication.LauncherApplication;
import com.quiz.quizapplication.scene.background.BackgroundScene;
import com.quiz.quizapplication.exercises.scene.ownExercises.OwnExercisesScene;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ChooseExercisesScene extends Application {

    BackgroundScene backgroundScene = new BackgroundScene();
    LauncherApplication launcherApplication = new LauncherApplication();
    OwnExercisesScene ownExercisesScene;

    public static VBox vBoxBottom;
    public static VBox vBoxTop;
    public static Button ownExercisesButton;
    public static Button defaultExercisesButton;
    public static Button createTestButton;
    public static Button backToMenuButton;

    @Override
    public void start(Stage primaryStage) throws Exception {
        ownExercisesScene = new OwnExercisesScene();

        AnchorPane anchorPane = new AnchorPane();
            anchorPane.setPadding(new Insets(5, 5, 5, 5));
            anchorPane.setBackground(backgroundScene.defaultBackground());

        vBoxBottom = new VBox();
            vBoxBottom.setPrefHeight(569);
            vBoxBottom.setPrefWidth(150);
            vBoxBottom.setStyle("-fx-background-color: #7961be");
            vBoxBottom.setAlignment(Pos.BOTTOM_LEFT);
        vBoxTop = new VBox();
            vBoxTop.setPrefHeight(300);
            vBoxTop.setPrefWidth(150);
            vBoxTop.setStyle("-fx-background-color: #7961BE");

        anchorPane.getChildren().add(vBoxBottom);
        anchorPane.getChildren().add(vBoxTop);

        ownExercisesButton = new Button("Own exercises");
            ownExercisesButton.setPrefWidth(150);
            ownExercisesButton.setPrefHeight(50);
            ownExercisesButton.setStyle("-fx-background-color: #6857a5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false; -fx-border-width:1; -fx-border-color:#8981A7");
            ownExercisesButton.setTooltip(new Tooltip("Go to your own exercises"));
            ownExercisesButton.setGraphic(GlyphsDude.createIcon(FontAwesomeIcon.TASKS, "15px"));
        defaultExercisesButton = new Button("Default exercises");
            defaultExercisesButton.setPrefWidth(150);
            defaultExercisesButton.setPrefHeight(50);
            defaultExercisesButton.setStyle("-fx-background-color: #6857a5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false; -fx-border-width:1; -fx-border-color:#8981A7");
            defaultExercisesButton.setTooltip(new Tooltip("Go to your own exercises"));
            defaultExercisesButton.setGraphic(GlyphsDude.createIcon(FontAwesomeIcon.DESKTOP, "15px"));
        createTestButton = new Button("Create test");
            createTestButton.setPrefWidth(150);
            createTestButton.setPrefHeight(50);
            createTestButton.setStyle("-fx-background-color: #6857a5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false; -fx-border-width:1; -fx-border-color:#8981A7");
            createTestButton.setTooltip(new Tooltip("Go to your own exercises"));
            createTestButton.setGraphic(GlyphsDude.createIcon(FontAwesomeIcon.FILE_PDF_ALT, "15px"));
        backToMenuButton = new Button("Back to menu");
            backToMenuButton.setPrefWidth(150);
            backToMenuButton.setPrefHeight(50);
            backToMenuButton.setStyle("-fx-background-color: #6857a5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false; -fx-border-width:1; -fx-border-color:#8981A7");
            backToMenuButton.setTooltip(new Tooltip("Go to your own exercises"));
            backToMenuButton.setGraphic(GlyphsDude.createIcon(FontAwesomeIcon.ARROW_RIGHT, "15px"));

        vBoxBottom.getChildren().add(backToMenuButton);
        vBoxTop.getChildren().add(ownExercisesButton);
        vBoxTop.getChildren().add(defaultExercisesButton);
        vBoxTop.getChildren().add(createTestButton);

        Scene mainScene = new Scene(anchorPane, 853,569, Color.BLACK);
        primaryStage.setScene(mainScene);

        backToMenuButton.setOnAction(event -> {
            try {
                launcherApplication.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        ownExercisesButton.setOnAction(event -> {
            try {
                ownExercisesScene.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
}
