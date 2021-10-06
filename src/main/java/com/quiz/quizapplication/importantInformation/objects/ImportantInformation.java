package com.quiz.quizapplication.importantInformation;

import com.quiz.quizapplication.Exercises;

public class ImportantInformation {

    private boolean archivedInformation;
    private String title;
    private String description;

    public ImportantInformation( String title, String description) {
        archivedInformation = false;
        this.title = title;
        this.description = description;
    }

    public boolean isArchivedInformation() {
        return archivedInformation;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
