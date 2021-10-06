package com.quiz.quizapplication.scene.background;

import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class BackgroundScene {

    public static final String IMG_PATH = "file:src/main/resources";

    public Background defaultBackground() {
        ImageView image = new ImageView(IMG_PATH + "/books.jpg");
        image.setPreserveRatio(true);
        BackgroundSize backgroundSize = new BackgroundSize(853, 569, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(image.getImage(), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        return new Background(backgroundImage);
    }
}
