package com.quiz.quizapplication.scene.addScene;

import com.quiz.quizapplication.RepeatExercisesApplication;
import com.quiz.quizapplication.controller.AddExercisesController;
import com.quiz.quizapplication.controller.GroupChoiceBoxController;
import com.quiz.quizapplication.scene.BackgroundScene;
import com.quiz.quizapplication.scene.settingsScene.DataBaseSettingsScene;
import com.quiz.quizapplication.scene.settingsScene.ExercisesSettings;
import com.quiz.quizapplication.scene.settingsScene.GroupSettings;
import com.quiz.quizapplication.scene.settingsScene.MainSettingsScene;
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

public class AddExercisesScene extends Application {

    private final BackgroundScene backgroundScene = new BackgroundScene();
    private AddExercisesController addExercisesController;
    private ChooseAddScene chooseAddScene;
    public static TextField titleTextField;
    public static TextArea descriptionTextArea;
    public static ChoiceBox<String> groupChoiceBox;
    GroupChoiceBoxController groupChoiceBoxController = new GroupChoiceBoxController();
    public GroupSettings groupSettings;
    public MainSettingsScene mainSettingsScene;

    public AddExercisesScene() {
        groupChoiceBox = new ChoiceBox<>(groupChoiceBoxController.create());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        groupSettings = new GroupSettings();
        chooseAddScene = new ChooseAddScene();
        addExercisesController = new AddExercisesController();

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

        Label title = new Label("Title");
            title.setPrefWidth(150);
            title.setPrefHeight(30);
            title.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true");
        Label description = new Label("Description");
            description.setPrefWidth(400);
            description.setPrefHeight(20);
            description.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true");
        Label group = new Label("Group");
            group.setPrefWidth(150);
            group.setPrefHeight(30);
            group.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true");
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
        titleTextField = new TextField();
            titleTextField.setPromptText("Write title of exercise");
        descriptionTextArea = new TextArea();
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
        Button descriptionLengthButton = new Button("Check desc length");
            descriptionLengthButton.setPrefWidth(400);
            descriptionLengthButton.setPrefHeight(30);
            descriptionLengthButton.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981A7");
        Button loadFileButton = new Button("Load file..     <filePath>");
            loadFileButton.setPrefWidth(400);
            loadFileButton.setPrefHeight(15);
            loadFileButton.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981A7");

        vBoxBottom.getChildren().add(0, backButton);
        vBoxTop.getChildren().add(0, title);
        vBoxTop.getChildren().add(1, titleTextField);
        vBoxTop.getChildren().add(2, group);
        vBoxTop.getChildren().add(3, hBox);
        vBoxTop.getChildren().add(4, addExercisesButton);

        GridPane gridPane = new GridPane();
            gridPane.setAlignment(Pos.CENTER_RIGHT);
            gridPane.setPrefWidth(703);
            gridPane.setPrefHeight(569);
                anchorPane.getChildren().add(0, gridPane);

            gridPane.add(loadFileButton, 0, 0);
            gridPane.add(description, 0, 1);
            gridPane.add(descriptionTextArea, 0 ,2);
            gridPane.add(descriptionLengthButton, 0, 3);

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

        descriptionLengthButton.setOnAction(e ->
        {
            int count = descriptionTextArea.getLength();
            description.setText("Description (" + count + " / 8000)");
        });

        addExercisesButton.setOnAction(event -> addExercisesController.addExercise());

        addGroupButton.setOnAction(event -> {
            try {
                groupSettings.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
