package com.quiz.quizapplication.data.music;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaException;
import java.io.File;

public class Music {

    public static int counter = 0;
    public static double valueDownAndUp = 0.1;
    public static boolean isTurnOn = false;
    public static String resultSong = "test.mp3";
    public static HBox audioHBox = new HBox();
    public static Button previewSongButton = new Button();
    public static Label showTitleOfMusicLabel = new Label(resultSong);
    public static Button nextSongButton = new Button();
    public static Button volumeDownButton = new Button();
    public static Button audioButton = new Button();
    public static Button volumeUpButton = new Button();
    public static AudioClip audioClip;
    public static String MUSIC_PATH = "E:\\gibon\\Desktop\\Repositorium\\QuizApplication\\src\\main\\resources\\music";
    public static final File filePath = new File(MUSIC_PATH);
    public static String [] tab = filePath.list();

    public Music() {
        audioHBox.setPrefWidth(853);
            audioHBox.setPrefHeight(569);
            audioHBox.setAlignment(Pos.BOTTOM_RIGHT);
        audioButton.setPrefWidth(25);
            audioButton.setPrefHeight(25);
            audioButton.setStyle("-fx-background-color: #6857A5; -fx-border-width:1; -fx-border-color: white");
            audioButton.setGraphic(GlyphsDude.createIcon(FontAwesomeIcon.MUSIC));
            audioButton.setTooltip(new Tooltip("Play music"));
        volumeUpButton.setPrefWidth(25);
            volumeUpButton.setPrefHeight(25);
            volumeUpButton.setStyle("-fx-background-color: #6857A5;-fx-border-width:1;  -fx-border-color: white");
            volumeUpButton.setGraphic(GlyphsDude.createIcon(FontAwesomeIcon.VOLUME_UP));
            volumeUpButton.setTooltip(new Tooltip("Volume up"));
        volumeDownButton.setPrefWidth(25);
            volumeDownButton.setPrefHeight(25);
            volumeDownButton.setStyle("-fx-background-color: #6857A5;-fx-border-width:1; -fx-border-color: white");
            volumeDownButton.setGraphic(GlyphsDude.createIcon(FontAwesomeIcon.VOLUME_DOWN));
            volumeDownButton.setTooltip(new Tooltip("Volume down"));
        previewSongButton.setPrefWidth(25);
            previewSongButton.setPrefHeight(25);
            previewSongButton.setStyle("-fx-background-color: #6857A5;-fx-border-width:1; -fx-border-color: white");
            previewSongButton.setGraphic(GlyphsDude.createIcon(FontAwesomeIcon.ARROW_LEFT));
            previewSongButton.setTooltip(new Tooltip("Preview song"));
        showTitleOfMusicLabel.setPrefWidth(150);
            showTitleOfMusicLabel.setPrefHeight(25);
            showTitleOfMusicLabel.setStyle("-fx-alignment: center; -fx-background-color: #6857A5;-fx-border-width:1; -fx-border-color: white");
            showTitleOfMusicLabel.setGraphic(GlyphsDude.createIcon(FontAwesomeIcon.INFO_CIRCLE));
            showTitleOfMusicLabel.setTooltip(new Tooltip("Title of song"));
        nextSongButton.setPrefWidth(25);
            nextSongButton.setPrefHeight(25);
            nextSongButton.setStyle("-fx-background-color: #6857A5;-fx-border-width:1; -fx-border-color: white");
            nextSongButton.setGraphic(GlyphsDude.createIcon(FontAwesomeIcon.ARROW_RIGHT));
            nextSongButton.setTooltip(new Tooltip("Next song"));

        audioHBox.getChildren().add(0, previewSongButton);
        audioHBox.getChildren().add(1, showTitleOfMusicLabel);
        audioHBox.getChildren().add(2, nextSongButton);
        audioHBox.getChildren().add(3, volumeDownButton);
        audioHBox.getChildren().add(4, audioButton);
        audioHBox.getChildren().add(5, volumeUpButton);

        volumeDownButton.setOnAction(event -> volumeDown());
        volumeUpButton.setOnAction(event -> volumeUp());
        audioButton.setOnAction(event -> playMusic());
        nextSongButton.setOnAction(event -> scannerSongUp());
        previewSongButton.setOnAction(event -> scannerSongDown());
    }

    public static void playMusic() {
            try {
                audioClip = new AudioClip("file:src/main/resources/music/" + resultSong);
                if (!isTurnOn) {
                    isTurnOn = true;
                    audioClip.play();
                    showTitleOfMusicLabel.setText(audioClip.getSource().substring(30));
                } else {
                    isTurnOn = false;
                    audioClip.stop();
                    showTitleOfMusicLabel.setText(resultSong);
                }
            } catch (MediaException e) {
                System.out.println("ups: " + e);
                showTitleOfMusicLabel.setText("Please, choose a song");
            }
    }

    public static void volumeDown() {
        double actualVolValue = audioClip.getVolume();
        actualVolValue -= valueDownAndUp;
        if (actualVolValue < 0.1) {
            actualVolValue = 0.1;
        }
        audioClip.setVolume(actualVolValue);
    }

    public static void volumeUp() {
        double actualVolValue = audioClip.getVolume();
        actualVolValue += valueDownAndUp;
        if (actualVolValue > 1.0) {
            actualVolValue = 1.0;
        }
        audioClip.setVolume(actualVolValue);
    }

    public static void scannerSongUp() {
        counter++;
        if (counter < tab.length) {
            resultSong = tab[counter];
        } else {
            counter = tab.length -1;
        }
        showTitleOfMusicLabel.setText(resultSong);
    }

    public static void scannerSongDown() {
        counter--;
        if (counter < 0) {
            counter = 0;
        }
        resultSong = tab[counter];
        showTitleOfMusicLabel.setText(resultSong);
    }

}
