package com.quiz.quizapplication.settings.controller;

import com.quiz.quizapplication.settings.data.SaveSettings;
import java.io.IOException;

public class MainSettingsController {

    SaveSettings saveSettings = new SaveSettings();

    public void saveSettingsToFile() throws IOException {
        saveSettings.saveSettingsToFileTxt();
    }
}
