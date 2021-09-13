package com.quiz.quizapplication;

public class Exercises {

    private static int id;
    private String titleTask;
    private String descriptionTask;
    private boolean archivedTask;
    private int bestResultTime;

    public Exercises(String titleTask, String descriptionTask) {
        this.titleTask = titleTask;
        this.descriptionTask = descriptionTask;
        archivedTask = false;
        bestResultTime = 0;
    }

    public int getId() {
        return id;
    }

    public String getTitleTask() {
        return titleTask;
    }

    public String getDescriptionTask() {
        return descriptionTask;
    }

    public boolean isArchivedTask() {
        return archivedTask;
    }

    public int getBestResultTime() {
        return bestResultTime;
    }

    @Override
    public String toString() {
        return "Exercises{" +
                "titleTask='" + titleTask + '\'' +
                ", descriptionTask='" + descriptionTask + '\'' +
                ", archivedTask=" + archivedTask +
                ", groupId=" + '}';
    }
}
