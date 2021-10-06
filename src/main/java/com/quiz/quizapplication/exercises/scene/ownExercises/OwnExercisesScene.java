package com.quiz.quizapplication.exercises.scene.ownExercises;

import com.quiz.quizapplication.exercises.controller.add.AddExercisesGroupController;
import com.quiz.quizapplication.exercises.controller.exercises.ExercisesController;
import com.quiz.quizapplication.exercises.scene.ChooseExercisesScene;
import com.quiz.quizapplication.scene.background.BackgroundScene;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.SQLException;

public class OwnExercisesScene extends Application {

    BackgroundScene backgroundScene = new BackgroundScene();
    ExercisesController exercisesController = new ExercisesController();
    AddExercisesGroupController addExercisesGroupController = new AddExercisesGroupController();
    OwnExercisesScene ownExercisesScene;
    public static ChoiceBox<String> groupChoiceBox;
    public static ChoiceBox<String> changeGroupChoiceBox;
    public static ListView<String> listView;
    public static TextField changeTitleTextField = new TextField();

    public OwnExercisesScene() throws SQLException {
        groupChoiceBox = new ChoiceBox<>(addExercisesGroupController.createObservableListToChoiceBox());
        changeGroupChoiceBox = new ChoiceBox<>(addExercisesGroupController.createObservableListToChoiceBox());
        listView = new ListView<>(exercisesController.createObservableListToListView());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();
            anchorPane.setPadding(new Insets(5, 5, 5, 5));
            anchorPane.setBackground(backgroundScene.defaultBackground());

        GridPane gridPane = new GridPane();
            gridPane.setPrefWidth(631);
            gridPane.setPrefHeight(400);
            gridPane.setAlignment(Pos.TOP_RIGHT);

        anchorPane.getChildren().add(gridPane);
        anchorPane.getChildren().add(ChooseExercisesScene.vBoxBottom);
        anchorPane.getChildren().add(ChooseExercisesScene.vBoxTop);

        Label listViewLabel = new Label();
            listViewLabel.setPrefWidth(300);
            listViewLabel.setPrefHeight(15);
            listViewLabel.setText("List of exercises (" + exercisesController.sizeOfListView() + ")");
            listViewLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white");
        groupChoiceBox.setPrefWidth(270);
            groupChoiceBox.setPrefHeight(20);
            groupChoiceBox.setStyle("-fx-alignment: center-left");
        Button showExercisesByGroupButton = new Button();
            showExercisesByGroupButton.setPrefHeight(20);
            showExercisesByGroupButton.setPrefWidth(30);
            showExercisesByGroupButton.setGraphic(GlyphsDude.createIcon(FontAwesomeIcon.DOWNLOAD, "15px"));
        HBox hBoxChoiceGroup = new HBox();
            hBoxChoiceGroup.setAlignment(Pos.TOP_RIGHT);
            hBoxChoiceGroup.getChildren().add(groupChoiceBox);
            hBoxChoiceGroup.getChildren().add(showExercisesByGroupButton);
        listView.setPrefWidth(270);
            listView.setPrefHeight(300);
            listView.setStyle("-fx-alignment: center-left");
        Label archiveLabel = new Label("Delete");
            archiveLabel.setPrefHeight(15);
            archiveLabel.setPrefWidth(300);
            archiveLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white");
        Button deleteChosenExercisesButton = new Button("Delete chosen exercise");
            deleteChosenExercisesButton.setPrefHeight(20);
            deleteChosenExercisesButton.setPrefWidth(200);
        Button deleteAllExercisesButton = new Button("Delete all");
            deleteAllExercisesButton.setPrefHeight(20);
            deleteAllExercisesButton.setPrefWidth(100);
        HBox hBoxArchive = new HBox();
            hBoxArchive.getChildren().add(deleteChosenExercisesButton);
            hBoxArchive.getChildren().add(deleteAllExercisesButton);
        Label changeTitleLabel = new Label("Change title");
            changeTitleLabel.setPrefHeight(15);
            changeTitleLabel.setPrefWidth(300);
            changeTitleLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true");
        changeTitleTextField.setPrefHeight(20);
            changeTitleTextField.setPrefWidth(200);
            changeTitleTextField.setPromptText("Choose ex and write new title");
        Button changeTitleButton = new Button("Change title");
            changeTitleButton.setPrefWidth(100);
            changeTitleButton.setPrefHeight(20);
        HBox hBoxChangeTitle = new HBox();
            hBoxChangeTitle.getChildren().add(changeTitleTextField);
            hBoxChangeTitle.getChildren().add(changeTitleButton);
        Label changeGroupLabel = new Label("Change group");
            changeGroupLabel.setPrefHeight(15);
            changeGroupLabel.setPrefWidth(300);
            changeGroupLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white");
        Button changeGroupButton = new Button("Change group");
            changeGroupButton.setPrefHeight(20);
            changeGroupButton.setPrefWidth(100);
        changeGroupChoiceBox.setPrefHeight(20);
            changeGroupChoiceBox.setPrefWidth(200);
        HBox hBoxChangeGroup = new HBox();
            hBoxChangeGroup.getChildren().add(changeGroupChoiceBox);
            hBoxChangeGroup.getChildren().add(changeGroupButton);
        Label exampleSolution = new Label("Example solution");
            exampleSolution.setPrefHeight(15);
            exampleSolution.setPrefWidth(300);
            exampleSolution.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true");
        Button exampleSolutionButton = new Button("Example solution");
            exampleSolutionButton.setPrefHeight(20);
            exampleSolutionButton.setPrefWidth(300);

        gridPane.add(listViewLabel, 0, 0);
        gridPane.add(hBoxChoiceGroup, 0, 1);
        gridPane.add(listView, 0, 2);
        gridPane.add(archiveLabel, 0, 3);
        gridPane.add(hBoxArchive, 0, 4);
        gridPane.add(changeTitleLabel, 0, 5);
        gridPane.add(hBoxChangeTitle, 0, 6);
        gridPane.add(changeGroupLabel, 0, 7);
        gridPane.add(hBoxChangeGroup, 0, 8);
        gridPane.add(exampleSolution, 0, 9);
        gridPane.add(exampleSolutionButton, 0, 10);

        Scene mainScene = new Scene(anchorPane, 853, 569, Color.BLACK);
        primaryStage.setScene(mainScene);

        deleteAllExercisesButton.setOnAction(event -> {
            try {
                exercisesController.deleteAllExercises();
                ownExercisesScene = new OwnExercisesScene();
                ownExercisesScene.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        deleteChosenExercisesButton.setOnAction(event -> {
            try {
                exercisesController.deleteChosenExercises();
                exercisesController.downloadGroupFromChoiceBox();
                ownExercisesScene = new OwnExercisesScene();
                exercisesController.createListViewByGroup();
                ownExercisesScene.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        changeTitleButton.setOnAction(event -> {
            try {
                exercisesController.changeTitleExercises();
                exercisesController.downloadGroupFromChoiceBox();
                ownExercisesScene = new OwnExercisesScene();
                exercisesController.createListViewByGroup();
                ownExercisesScene.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

//        exampleSolutionButton.setOnAction(event -> exercisesControllerOld.loadExampleSolution());

        showExercisesByGroupButton.setOnAction(event -> {
            try {
                exercisesController.downloadGroupFromChoiceBox();
                ownExercisesScene = new OwnExercisesScene();
                exercisesController.createListViewByGroup();
                ownExercisesScene.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        changeGroupButton.setOnAction(event -> {
            try {
                exercisesController.changeGroupExercises();
                exercisesController.downloadGroupFromChoiceBox();
                ownExercisesScene = new OwnExercisesScene();
                exercisesController.createListViewByGroup();
                ownExercisesScene.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


}
