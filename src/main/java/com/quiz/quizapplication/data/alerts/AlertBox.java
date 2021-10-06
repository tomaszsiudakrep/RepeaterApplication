package com.quiz.quizapplication.data;

import com.quiz.quizapplication.settings.data.DataDataBaseSettings;
import com.quiz.quizapplication.exercises.data.DataFromDb;
import com.quiz.quizapplication.settings.scene.DataBaseSettingsScene;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.sql.SQLException;

public class AlertBox {

    public static Button yesButton;
    public static Stage window;
    private DataDataBaseSettings dataDataBaseSettings = new DataDataBaseSettings();

    public static void alertBoxCleanAll() {
        window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("WARNING");
            window.setMinWidth(250);
            window.setMinHeight(150);
            window.setResizable(false);

        Label titleLabel = new Label("All groups and tasks will be deleted.\n" +
                "Do you want to continue?\n");
            titleLabel.setStyle("-fx-alignment: center ;-fx-text-fill: white; -fx-font-size: 13");
            titleLabel.setAlignment(Pos.CENTER);
        yesButton = new Button("YES");
            yesButton.setPrefWidth(80);
            yesButton.setPrefHeight(40);
        Button noButton = new Button("NO");
            noButton.setPrefWidth(80);
            noButton.setPrefHeight(40);

        HBox hBox = new HBox();
            hBox.setPrefWidth(180);
            hBox.setPrefHeight(115);
            hBox.setAlignment(Pos.CENTER);
            hBox.getChildren().add(0, yesButton);
            hBox.getChildren().add(1, noButton);

        VBox vBox = new VBox();
            vBox.setStyle("-fx-background-color: #6857A5");
            vBox.getChildren().add(0, titleLabel);
            vBox.getChildren().add(1, hBox);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();

        yesButton.setOnAction(event -> {
            try {
                DataFromDb.deleteAllGroupAndTasks();
                window.close();
                DataBaseSettingsScene.cleanLabel.setText("Clean all <true>");
            } catch (SQLException e) {
                e.printStackTrace();
                DataBaseSettingsScene.cleanLabel.setText("Clean all <false>");
            }
        });

        noButton.setOnAction(event -> window.close());
    }
}



