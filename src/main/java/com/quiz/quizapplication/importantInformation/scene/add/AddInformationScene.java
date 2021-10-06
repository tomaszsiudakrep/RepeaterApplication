package com.quiz.quizapplication.importantInformation.scene.add;

import com.quiz.quizapplication.importantInformation.controller.add.AddInformationGroupController;
import com.quiz.quizapplication.importantInformation.controller.add.AddInformationController;
import com.quiz.quizapplication.importantInformation.data.add.BindingsAddInformation;
import com.quiz.quizapplication.scene.background.BackgroundScene;
import com.quiz.quizapplication.scene.add.ChooseAddScene;
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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;

public class AddInformationScene extends Application {

    BackgroundScene backgroundScene = new BackgroundScene();
    AddInformationGroupController addInformationGroupController = new AddInformationGroupController();
    AddInformationController addInformationController = new AddInformationController();
    ChooseAddScene chooseAddScene;
    AddGroupInformationScene addGroupInformationScene;
    BindingsAddInformation bindingsAddInformation;
    public static TextField titleTextField;
    public static TextArea descriptionTextArea;
    public static ChoiceBox<String> groupChoiceBox;
    public static Label descriptionLabel;


    public AddInformationScene() throws SQLException {
        groupChoiceBox = new ChoiceBox<>(addInformationGroupController.createObservableListToChoiceBox());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        addGroupInformationScene = new AddGroupInformationScene();
        chooseAddScene = new ChooseAddScene();
        descriptionLabel = new Label();
        descriptionTextArea = new TextArea();
        bindingsAddInformation = new BindingsAddInformation();

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
            titleLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false");
        titleTextField = new TextField();
            titleTextField.setPromptText("Write title of information");
        Label group = new Label("Group");
            group.setPrefWidth(150);
            group.setPrefHeight(20);
            group.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false");
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
        Button addInformationButton = new Button("Add information");
            addInformationButton.setPrefWidth(150);
            addInformationButton.setPrefHeight(50);
            addInformationButton.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false; -fx-border-width:1; -fx-border-color:#8981A7");
        descriptionTextArea.setPrefHeight(400);
            descriptionTextArea.setPrefWidth(400);
            descriptionTextArea.setWrapText(true);
            descriptionTextArea.setPromptText("Write description of information");
        descriptionLabel.setPrefWidth(400);
            descriptionLabel.setPrefHeight(20);
            descriptionLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false");
        Button backButton = new Button("Back");
            backButton.setPrefWidth(150);
            backButton.setPrefHeight(50);
            backButton.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: true; -fx-border-width:1; -fx-border-color:#8981A7");

        vBoxBottom.getChildren().add(0, backButton);
        vBoxTop.getChildren().add(0, titleLabel);
        vBoxTop.getChildren().add(1, titleTextField);
        vBoxTop.getChildren().add(2, group);
        vBoxTop.getChildren().add(3, hBox);
        vBoxTop.getChildren().add(4, fileLabel);
        vBoxTop.getChildren().add(5, createFileButton);
        vBoxTop.getChildren().add(6, addInformationButton);

        GridPane gridPane = new GridPane();
            gridPane.setAlignment(Pos.CENTER_RIGHT);
            gridPane.setPrefWidth(703);
            gridPane.setPrefHeight(569);
        anchorPane.getChildren().add(0, gridPane);
            gridPane.add(descriptionLabel, 0, 1);
            gridPane.add(descriptionTextArea, 0 ,2);

        Scene addInformationScene = new Scene(anchorPane, 853, 569, Color.BLACK);
        primaryStage.setScene(addInformationScene);

        backButton.setOnAction(event -> {
            try {
                chooseAddScene.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        addGroupButton.setOnAction(event -> {
            try {
                addGroupInformationScene.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        addInformationButton.setOnAction(event -> {
            try {
                addInformationController.addInformation();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        createFileButton.setOnAction(event -> {
            try {
                addInformationController.createFile();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });
    }
}
