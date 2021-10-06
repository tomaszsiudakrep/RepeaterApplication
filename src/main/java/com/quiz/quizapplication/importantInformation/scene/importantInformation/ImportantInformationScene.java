package com.quiz.quizapplication.importantInformation.scene.importantInformation;

import com.quiz.quizapplication.LauncherApplication;
import com.quiz.quizapplication.importantInformation.controller.add.AddInformationGroupController;
import com.quiz.quizapplication.importantInformation.controller.information.ImportantInformationController;
import com.quiz.quizapplication.scene.background.BackgroundScene;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
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

import java.sql.SQLException;

public class ImportantInformationScene extends Application {

    BackgroundScene backgroundScene = new BackgroundScene();
    AddInformationGroupController addInformationGroupController = new AddInformationGroupController();
    ImportantInformationController importantInformationController = new ImportantInformationController();
    LauncherApplication launcherApplication = new LauncherApplication();
    ImportantInformationScene importantInformationScene;
    public static ChoiceBox<String> groupChoiceBox;
    public static ChoiceBox<String> changeGroupChoiceBox;
    public static ListView<String> listView;
    public static TextField changeTitleTextField = new TextField();
    public static TextField searchingTextField = new TextField();

    public ImportantInformationScene() throws SQLException {
        groupChoiceBox = new ChoiceBox<>(addInformationGroupController.createObservableListToChoiceBox());
        changeGroupChoiceBox = new ChoiceBox<>(addInformationGroupController.createObservableListToChoiceBox());
        listView = new ListView<>(importantInformationController.createObservableListToListView());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
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

        GridPane gridPane = new GridPane();
            gridPane.setPrefWidth(631);
            gridPane.setPrefHeight(400);
            gridPane.setAlignment(Pos.TOP_RIGHT);

        anchorPane.getChildren().add(gridPane);
        anchorPane.getChildren().add(vBoxBottom);
        anchorPane.getChildren().add(vBoxTop);

        Label listViewInformationLabel = new Label();
            listViewInformationLabel.setPrefWidth(400);
            listViewInformationLabel.setPrefHeight(15);
            listViewInformationLabel.setText("Important information (" + importantInformationController.sizeOfImportantInformation() + ")" );
            listViewInformationLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white; -fx-alignment: center");
        groupChoiceBox.setPrefWidth(370);
            groupChoiceBox.setPrefHeight(20);
            groupChoiceBox.setStyle("-fx-alignment: center-left");
        Button showInformationByGroupButton = new Button();
            showInformationByGroupButton.setPrefHeight(20);
            showInformationByGroupButton.setPrefWidth(30);
            showInformationByGroupButton.setGraphic(GlyphsDude.createIcon(FontAwesomeIcon.DOWNLOAD, "15px"));
        HBox hBoxChoiceGroup = new HBox();
            hBoxChoiceGroup.setAlignment(Pos.TOP_RIGHT);
            hBoxChoiceGroup.getChildren().add(groupChoiceBox);
            hBoxChoiceGroup.getChildren().add(showInformationByGroupButton);
        searchingTextField.setPrefHeight(20);
            searchingTextField.setPrefWidth(370);
            searchingTextField.setPromptText("Search");
        Button searchingButton = new Button();
            searchingButton.setPrefHeight(20);
            searchingButton.setPrefWidth(30);
            searchingButton.setGraphic(GlyphsDude.createIcon(FontAwesomeIcon.SEARCH, "15px"));
        HBox hBoxSearchingInformation = new HBox();
            hBoxSearchingInformation.setAlignment(Pos.TOP_RIGHT);
            hBoxSearchingInformation.getChildren().add(searchingTextField);
            hBoxSearchingInformation.getChildren().add(searchingButton);
        listView.setPrefWidth(370);
            listView.setPrefHeight(200);
            listView.setStyle("-fx-alignment: center-left");
        Label deleteInformationLabel = new Label("Delete information");
            deleteInformationLabel.setPrefHeight(20);
            deleteInformationLabel.setPrefWidth(150);
            deleteInformationLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-alignment: center");
        Button deleteChosenInformation = new Button("Delete chosen information");
            deleteChosenInformation.setPrefHeight(20);
            deleteChosenInformation.setPrefWidth(150);
            deleteChosenInformation.setStyle("-fx-background-color: white; -fx-border-color: black;-fx-border-width: 1");
        Label changeTitleLabel = new Label("Change title");
            changeTitleLabel.setPrefHeight(20);
            changeTitleLabel.setPrefWidth(150);
            changeTitleLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false;-fx-alignment: center");
        changeTitleTextField.setPrefHeight(20);
            changeTitleTextField.setPrefWidth(150);
            changeTitleTextField.setStyle("-fx-font-size: 12;-fx-background-color: white;-fx-text-fill: black");
            changeTitleTextField.setPromptText("Write new title");
        Button changeTitleButton = new Button("Change title");
            changeTitleButton.setPrefWidth(150);
            changeTitleButton.setPrefHeight(20);
            changeTitleButton.setStyle("-fx-background-color: white; -fx-border-color: black;-fx-border-width: 1");
        Label changeGroupLabel = new Label("Change group");
            changeGroupLabel.setPrefHeight(20);
            changeGroupLabel.setPrefWidth(150);
            changeGroupLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-alignment: center");
        Button changeGroupButton = new Button("Change group");
            changeGroupButton.setPrefHeight(20);
            changeGroupButton.setPrefWidth(150);
            changeGroupButton.setStyle("-fx-background-color: white; -fx-border-color: black;-fx-border-width: 1");
        changeGroupChoiceBox.setPrefHeight(20);
            changeGroupChoiceBox.setPrefWidth(150);
        Label loadFileLabel = new Label("File");
            loadFileLabel.setPrefHeight(20);
            loadFileLabel.setPrefWidth(150);
            loadFileLabel.setStyle("-fx-background-color: #6857A5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false;-fx-alignment: center");
        Button loadFileInformationButton = new Button("Load file");
            loadFileInformationButton.setPrefHeight(20);
            loadFileInformationButton.setPrefWidth(300);
            loadFileInformationButton.setStyle("-fx-background-color: white; -fx-border-color: black;-fx-border-width: 1");

        Button backToMenuButton = new Button("Back to menu");
            backToMenuButton.setPrefWidth(150);
            backToMenuButton.setPrefHeight(50);
            backToMenuButton.setStyle("-fx-background-color: #6857a5; -fx-font-size: 12; -fx-text-fill: white;-fx-underline: false; -fx-border-width:1; -fx-border-color:#8981A7");
            backToMenuButton.setGraphic(GlyphsDude.createIcon(FontAwesomeIcon.ARROW_RIGHT, "15px"));

        vBoxBottom.getChildren().add(backToMenuButton);
        vBoxTop.getChildren().add(changeTitleLabel);
        vBoxTop.getChildren().add(changeTitleTextField);
        vBoxTop.getChildren().add(changeTitleButton);
        vBoxTop.getChildren().add(deleteInformationLabel);
        vBoxTop.getChildren().add(deleteChosenInformation);
        vBoxTop.getChildren().add(changeGroupLabel);
        vBoxTop.getChildren().add(changeGroupChoiceBox);
        vBoxTop.getChildren().add(changeGroupButton);
        vBoxTop.getChildren().add(loadFileLabel);
        vBoxTop.getChildren().add(loadFileInformationButton);

        gridPane.add(listViewInformationLabel, 0, 0);
        gridPane.add(hBoxSearchingInformation, 0, 1);
        gridPane.add(hBoxChoiceGroup, 0, 2);
        gridPane.add(listView, 0, 3);

        Scene mainScene = new Scene(anchorPane, 853, 569, Color.BLACK);
        primaryStage.setScene(mainScene);

        backToMenuButton.setOnAction(event -> {
            try {
                launcherApplication.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        showInformationByGroupButton.setOnAction(event -> {
            try {
                importantInformationController.downloadGroupFromChoiceBox();
                importantInformationScene = new ImportantInformationScene();
                importantInformationController.createListViewByGroup();
                importantInformationScene.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        deleteChosenInformation.setOnAction(event -> {
            try {
                importantInformationController.deleteImportantInformation();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        changeTitleButton.setOnAction(event -> importantInformationController.changeTitleInformation());

        changeGroupButton.setOnAction(event -> importantInformationController.changeGroup());



    }
}
