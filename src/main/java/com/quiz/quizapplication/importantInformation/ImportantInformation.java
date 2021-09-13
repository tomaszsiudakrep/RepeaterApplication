package com.quiz.quizapplication.importantInformation;

import com.quiz.quizapplication.Exercises;

public class ImportantInformation extends Exercises {

    private final boolean archivedInformation;

    public ImportantInformation(String titleImportantInfo, String descriptionInformation) {
        super(titleImportantInfo, descriptionInformation);
        archivedInformation = false;
    }

    public boolean isArchivedInformation() {
        return archivedInformation;
    }

}
