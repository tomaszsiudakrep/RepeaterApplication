package com.quiz.quizapplication.scene.settingsScene;

import com.quiz.quizapplication.controller.ExercisesSettingsController;
import com.quiz.quizapplication.controller.GroupChoiceBoxController;
import com.quiz.quizapplication.controller.ListViewExercisesController;
import com.quiz.quizapplication.database.DataFromDb;
import com.quiz.quizapplication.database.ListOfExercisesListView;
import com.quiz.quizapplication.scene.BackgroundScene;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.sql.SQLException;

public class ExercisesSettings extends Application {

    private final BackgroundScene backgroundScene = new BackgroundScene();
    public static TextField titleTextField;
    ExercisesSettingsController exercisesSettingsController = new ExercisesSettingsController();
    ListOfExercisesListView listOfExercisesListView = new ListOfExercisesListView();
    GroupChoiceBoxController groupChoiceBoxController = new GroupChoiceBoxController();
    ListViewExercisesController listViewExercisesController = new ListViewExercisesController();
    private ListView<String> listView;
    private ChoiceBox<String> choiceBox;

    public ExercisesSettings() throws SQLException {
        listView = new ListView<>(listOfExercisesListView.createList());
        choiceBox = new ChoiceBox<>(groupChoiceBoxController.create());
    }

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

        Label listOfExercisesLabel = new Label("List of exercises ( " + listViewExercisesController.countSizeOfListView() + " )" );
            listOfExercisesLabel.setPrefHeight(20);
            listOfExercisesLabel.setPrefWidth(400);
            listOfExercisesLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true");

        Button archiveExercisesButton = new Button("Archive chosen exercise");
            archiveExercisesButton.setPrefHeight(20);
            archiveExercisesButton.setPrefWidth(400);
        Button archiveAllExercisesButton = new Button("Archive all exercises");
            archiveAllExercisesButton.setPrefHeight(20);
            archiveAllExercisesButton.setPrefWidth(400);
        Label archiveLabel = new Label("Archive");
            archiveLabel.setPrefHeight(20);
            archiveLabel.setPrefWidth(400);
            archiveLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true");
        Label changeTitleLabel = new Label("Change title");
            changeTitleLabel.setPrefHeight(20);
            changeTitleLabel.setPrefWidth(400);
            changeTitleLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true");
        Label changeGroupLabel = new Label("Change group");
            changeGroupLabel.setPrefHeight(20);
            changeGroupLabel.setPrefWidth(400);
            changeGroupLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true");
        choiceBox.setPrefWidth(400);
            choiceBox.setPrefHeight(20);
        Label exampleSolution = new Label("Example solution");
            exampleSolution.setPrefHeight(20);
            exampleSolution.setPrefWidth(400);
            exampleSolution.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true");
        Button changeTitleButton = new Button("Change title");
            changeTitleButton.setPrefHeight(20);
            changeTitleButton.setPrefWidth(400);
        Button changeGroupButton = new Button("Change group");
            changeGroupButton.setPrefHeight(20);
            changeGroupButton.setPrefWidth(400);
        Button exampleSolutionButton = new Button("Example solution");
            exampleSolutionButton.setPrefHeight(20);
            exampleSolutionButton.setPrefWidth(400);
        titleTextField = new TextField();
            titleTextField.setPromptText("Choose exercise above and write here new title of exercise");
        titleTextField.setOnMouseClicked(event -> titleTextField.clear());
            titleTextField.setPrefHeight(20);
            titleTextField.setPrefWidth(400);

        gridPane.add(listOfExercisesLabel, 0, 0);
        gridPane.add(listView, 0, 1);
        gridPane.add(archiveLabel, 0, 2);
        gridPane.add(archiveExercisesButton, 0, 3);
        gridPane.add(archiveAllExercisesButton, 0, 4);
        gridPane.add(changeTitleLabel, 0, 5);
        gridPane.add(titleTextField, 0 , 6);
        gridPane.add(changeTitleButton, 0 , 7);
        gridPane.add(changeGroupLabel, 0 , 8);
        gridPane.add(choiceBox, 0 , 9);
        gridPane.add(changeGroupButton, 0 , 10);
        gridPane.add(exampleSolution, 0, 11);
        gridPane.add(exampleSolutionButton, 0, 12);

        Scene exSettScene = new Scene(anchorPane, 853, 569, Color.BLACK);
        primaryStage.setScene(exSettScene);

        archiveAllExercisesButton.setOnAction(event -> exercisesSettingsController.archiveAllExercises());

        archiveExercisesButton.setOnAction(event -> exercisesSettingsController.archiveChosenExercise());

        changeTitleButton.setOnAction(event -> exercisesSettingsController.changeTitleOfExercise());

        exampleSolutionButton.setOnAction(event -> exercisesSettingsController.loadExampleSolution());
    }

}
