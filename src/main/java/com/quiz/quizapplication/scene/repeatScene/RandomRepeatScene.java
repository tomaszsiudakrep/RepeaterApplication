package com.quiz.quizapplication.scene.repeatScene;

import com.quiz.quizapplication.scene.BackgroundScene;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RandomRepeatScene extends Application {

    ChooseRepeatScene chooseRepeatScene;
    AnchorPane anchorPane;
    BackgroundScene backgroundScene = new BackgroundScene();


    @Override
    public void start(Stage primaryStage) throws Exception {
        chooseRepeatScene = new ChooseRepeatScene();
        anchorPane = new AnchorPane();
        anchorPane.setPadding(new Insets(5, 5, 5, 5));
        anchorPane.setBackground(backgroundScene.defaultBackground());
        anchorPane.getChildren().add(0, RepeatScene.vBoxTop);
        anchorPane.getChildren().add(1, RepeatScene.vBoxBottom);
        anchorPane.getChildren().add(0, RepeatScene.gridPane);
    }
}
