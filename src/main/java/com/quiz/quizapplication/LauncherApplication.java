package com.quiz.quizapplication;

import com.quiz.quizapplication.controller.Exit;
import com.quiz.quizapplication.importantInformation.scene.importantInformation.ImportantInformationScene;
import com.quiz.quizapplication.scene.*;
import com.quiz.quizapplication.scene.addScene.AddExercisesScene;
import com.quiz.quizapplication.scene.addScene.ChooseAddScene;
import com.quiz.quizapplication.scene.exercisesScene.ExercisesScene;
import com.quiz.quizapplication.scene.repeatScene.ChooseRepeatScene;
import com.quiz.quizapplication.settings.scene.MainSettingsScene;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class RepeatExercisesApplication extends Application {

    Exit exit = new Exit();
    BackgroundScene backgroundScene = new BackgroundScene();
    private final ContextMenu addButton = new ContextMenu();
    private final MenuItem addExMenuItem = new MenuItem("Add exercises");
    private final MenuItem addImportantMenuItem = new MenuItem("Add important info..");
    public static MainSettingsScene mainSettingsScene;
    private AddExercisesScene addExercisesScene;
    private ChooseRepeatScene chooseRepeatScene;
    private ChooseAddScene chooseAddScene;
    private ImportantInformationScene importantInformationScene;
    public static ExercisesScene exercisesScene;
    public static Music music = new Music();

    PdfCreator pdfCreator = new PdfCreator();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        chooseRepeatScene = new ChooseRepeatScene();
        mainSettingsScene = new MainSettingsScene();
        addExercisesScene = new AddExercisesScene();
        chooseAddScene = new ChooseAddScene();
        exercisesScene = new ExercisesScene();
        importantInformationScene = new ImportantInformationScene();

        AnchorPane anchorPane = new AnchorPane();
            anchorPane.setPadding(new Insets(5, 5, 5, 5));
            anchorPane.setBackground(backgroundScene.defaultBackground());

        VBox vBoxBottom = new VBox();
            vBoxBottom.setPrefHeight(569);
            vBoxBottom.setPrefWidth(150);
            vBoxBottom.setStyle("-fx-background-color: #7961be");
            vBoxBottom.setAlignment(Pos.BOTTOM_LEFT);
        VBox vBoxTop = new VBox();
            vBoxTop.setPrefHeight(300);
            vBoxTop.setPrefWidth(150);
            vBoxTop.setStyle("-fx-background-color: #7961BE");

        anchorPane.getChildren().add(0, Music.audioHBox);
        anchorPane.getChildren().add(1, vBoxBottom);
        anchorPane.getChildren().add(2, vBoxTop);

        Button moveToChooseAddSceneButton = new Button("Add");
            moveToChooseAddSceneButton.setGraphic(GlyphsDude.createIcon(FontAwesomeIcon.EDIT, "20px"));
            moveToChooseAddSceneButton.setTooltip(new Tooltip("go to the add option"));
            moveToChooseAddSceneButton.setPrefWidth(150);
            moveToChooseAddSceneButton.setPrefHeight(50);
            moveToChooseAddSceneButton.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false; -fx-border-width:1; -fx-border-color:#8981A7");
            moveToChooseAddSceneButton.setContextMenu(addButton);
                addButton.getItems().add(0, addExMenuItem);
                addButton.getItems().add(1, addImportantMenuItem);

        Button buttonExit = new Button("Exit");
            buttonExit.setTooltip(new Tooltip("exit"));
            buttonExit.setGraphic(GlyphsDude.createIcon(FontAwesomeIcon.ARROW_RIGHT, "20px"));
            buttonExit.setPrefWidth(150);
            buttonExit.setPrefHeight(50);
            buttonExit.setStyle("-fx-background-color: #6857a5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false; -fx-border-width:1; -fx-border-color:#8981A7");
        Button buttonSettings = new Button("Settings");
            buttonSettings.setTooltip(new Tooltip("go to the settings"));
            buttonSettings.setGraphic(GlyphsDude.createIcon(FontAwesomeIcon.INFO, "20px"));
            buttonSettings.setPrefWidth(150);
            buttonSettings.setPrefHeight(50);
            buttonSettings.setStyle("-fx-background-color: #6857a5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false; -fx-border-width:1; -fx-border-color:#8981A7");
        Button buttonChooseRepeat = new Button("Repeat");
            buttonChooseRepeat.setTooltip(new Tooltip("go to the repeat"));
            buttonChooseRepeat.setGraphic(GlyphsDude.createIcon(FontAwesomeIcon.REPEAT, "20px"));
            buttonChooseRepeat.setPrefWidth(150);
            buttonChooseRepeat.setPrefHeight(50);
            buttonChooseRepeat.setStyle("-fx-background-color: #6857a5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false; -fx-border-width:1; -fx-border-color:#8981A7");
        Button importantInformationButton = new Button("Important information");
            importantInformationButton.setTooltip(new Tooltip("go to the important information"));
            importantInformationButton.setGraphic(GlyphsDude.createIcon(FontAwesomeIcon.STACK_OVERFLOW, "20px"));
            importantInformationButton.setPrefWidth(150);
            importantInformationButton.setPrefHeight(50);
            importantInformationButton.setStyle("-fx-background-color: #6857a5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false; -fx-border-width:1; -fx-border-color:#8981A7");
        Button tasksButton = new Button("Tasks");
            tasksButton.setTooltip(new Tooltip("go to the important information"));
            tasksButton.setGraphic(GlyphsDude.createIcon(FontAwesomeIcon.TASKS, "20px"));
            tasksButton.setPrefWidth(150);
            tasksButton.setPrefHeight(50);
            tasksButton.setStyle("-fx-background-color: #6857a5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false; -fx-border-width:1; -fx-border-color:#8981A7");
        Button exercisesButton = new Button("Exercises");
            exercisesButton.setTooltip(new Tooltip("go to the exercises"));
            exercisesButton.setGraphic(GlyphsDude.createIcon(FontAwesomeIcon.BOOK, "20px"));
            exercisesButton.setWrapText(true);
            exercisesButton.setPrefWidth(150);
            exercisesButton.setPrefHeight(50);
            exercisesButton.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false; -fx-border-width:1; -fx-border-color:#8981A7");

        vBoxBottom.getChildren().add(0, buttonExit);

        vBoxTop.getChildren().add(0, buttonChooseRepeat);
        vBoxTop.getChildren().add(1, exercisesButton);
        vBoxTop.getChildren().add(2, importantInformationButton);
        vBoxTop.getChildren().add(3, tasksButton);
        vBoxTop.getChildren().add(4, moveToChooseAddSceneButton);
        vBoxTop.getChildren().add(5, buttonSettings);

        Scene mainScene = new Scene(anchorPane, 853, 569, Color.BLACK);

        primaryStage.setScene(mainScene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Repeat Your Knowledge");
        primaryStage.show();

        addExMenuItem.setOnAction(event ->
        {
            try {
                addExercisesScene.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        exercisesButton.setOnAction(event -> {
            try {
                exercisesScene.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        buttonSettings.setOnAction(e ->
        {
            try {
                mainSettingsScene.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        buttonChooseRepeat.setOnAction(event -> {
            try {
                pdfCreator.createPdfFile();
                chooseRepeatScene.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        buttonExit.setOnAction(e -> exit.endApplication());

        moveToChooseAddSceneButton.setOnAction(e ->
        {
            try {
                chooseAddScene.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        importantInformationButton.setOnAction(event -> {
            try {
                importantInformationScene.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


    }

}
