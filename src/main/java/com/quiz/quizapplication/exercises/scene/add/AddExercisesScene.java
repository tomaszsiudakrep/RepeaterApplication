package com.quiz.quizapplication.exercises.scene.add;

import com.quiz.quizapplication.exercises.controller.add.AddExercisesController;
import com.quiz.quizapplication.exercises.controller.add.AddExercisesGroupController;
import com.quiz.quizapplication.exercises.data.add.BindingsAddExercises;
import com.quiz.quizapplication.scene.background.BackgroundScene;
import com.quiz.quizapplication.scene.add.ChooseAddScene;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class AddExercisesScene extends Application {

    private final BackgroundScene backgroundScene = new BackgroundScene();
    private ChooseAddScene chooseAddScene;
    public static TextField titleTextField;
    public static TextArea descriptionTextArea;
    public static ChoiceBox<String> groupChoiceBox;
    public static Label descriptionLabel;
    public AddGroupExercisesScene addGroupExercisesScene;
    AddExercisesController addExercisesController = new AddExercisesController();
    AddExercisesGroupController addExercisesGroupController = new AddExercisesGroupController();
    BindingsAddExercises bindingsAddExercises;

    public AddExercisesScene() throws SQLException {
        groupChoiceBox = new ChoiceBox<>(addExercisesGroupController.createObservableListToChoiceBox());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        addGroupExercisesScene = new AddGroupExercisesScene();
        chooseAddScene = new ChooseAddScene();
        descriptionLabel = new Label();
        descriptionTextArea = new TextArea();
        bindingsAddExercises = new BindingsAddExercises();

        AnchorPane anchorPane = new AnchorPane();
            anchorPane.setPadding(new Insets(5, 5, 5,5));
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

        Label titleLabel = new Label("Title");
            titleLabel.setPrefWidth(150);
            titleLabel.setPrefHeight(20);
            titleLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true");
        descriptionLabel.setPrefWidth(400);
            descriptionLabel.setPrefHeight(20);
            descriptionLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true");
        Label groupLabel = new Label("Group");
            groupLabel.setPrefWidth(150);
            groupLabel.setPrefHeight(30);
            groupLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true");
        Button addGroupButton = new Button();
            addGroupButton.setPrefHeight(30);
            addGroupButton.setPrefWidth(30);
            addGroupButton.setTooltip(new Tooltip("Add group"));
            addGroupButton.setGraphic(GlyphsDude.createIcon(FontAwesomeIcon.PLUS));
        groupChoiceBox.setPrefHeight(30);
            groupChoiceBox.setPrefWidth(120);
        HBox hBox = new HBox();
            hBox.setPrefWidth(150);
            hBox.setPrefHeight(30);
            hBox.getChildren().add(0, groupChoiceBox);
            hBox.getChildren().add(1, addGroupButton);
        Label fileLabel = new Label("File");
            fileLabel.setPrefWidth(150);
            fileLabel.setPrefHeight(20);
            fileLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false");
        Button createFileButton = new Button("Create file");
            createFileButton.setPrefWidth(150);
            createFileButton.setPrefHeight(30);
            createFileButton.setStyle("-fx-background-color: white; -fx-font-size: 12; -fx-text-fill: black;-fx-underline: false; -fx-border-width:1; -fx-border-color:#8981A7");
        titleTextField = new TextField();
            titleTextField.setPromptText("Write title of exercise");
        descriptionTextArea.setPrefHeight(400);
            descriptionTextArea.setPrefWidth(400);
            descriptionTextArea.setWrapText(true);
            descriptionTextArea.setPromptText("Write description of exercise");
        Button addExercisesButton = new Button("Add exercises to db");
            addExercisesButton.setPrefWidth(150);
            addExercisesButton.setPrefHeight(50);
            addExercisesButton.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981A7");
        Button backButton = new Button("Back");
            backButton.setPrefWidth(150);
            backButton.setPrefHeight(50);
            backButton.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981A7");
        Button loadFileButton = new Button("Load file..     <filePath>");
            loadFileButton.setPrefWidth(400);
            loadFileButton.setPrefHeight(15);
            loadFileButton.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981A7");

        vBoxBottom.getChildren().add(backButton);
        vBoxTop.getChildren().add(titleLabel);
        vBoxTop.getChildren().add(titleTextField);
        vBoxTop.getChildren().add(groupLabel);
        vBoxTop.getChildren().add(hBox);
        vBoxTop.getChildren().add(fileLabel);
        vBoxTop.getChildren().add(createFileButton);
        vBoxTop.getChildren().add(addExercisesButton);

        GridPane gridPane = new GridPane();
            gridPane.setAlignment(Pos.CENTER_RIGHT);
            gridPane.setPrefWidth(703);
            gridPane.setPrefHeight(569);
                anchorPane.getChildren().add(0, gridPane);

            gridPane.add(loadFileButton, 0, 0);
            gridPane.add(descriptionLabel, 0, 1);
            gridPane.add(descriptionTextArea, 0 ,2);

        Scene addExercisesScene = new Scene(anchorPane, 853, 569, Color.BLACK);
        primaryStage.setScene(addExercisesScene);

        backButton.setOnAction(e ->
        {
            try {
                chooseAddScene.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        addExercisesButton.setOnAction(event -> addExercisesController.addExercises());

        addGroupButton.setOnAction(event -> {
            try {
                addGroupExercisesScene.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        createFileButton.setOnAction(event -> {
            try {
                addExercisesController.createFile();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });
    }

}
