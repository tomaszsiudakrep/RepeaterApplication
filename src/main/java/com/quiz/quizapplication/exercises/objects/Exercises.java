package com.quiz.quizapplication.exercises.objects;

public class Exercises {

    private static int id;
    private String title;
    private String description;
    private boolean archived;
    private int bestResultTime;

    public Exercises(String title, String description) {
        this.title = title;
        this.description = description;
        archived = false;
        bestResultTime = 0;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isArchived() {
        return archived;
    }

    public int getBestResultTime() {
        return bestResultTime;
    }

    @Override
    public String toString() {
        return "Exercises{" +
                "titleTask='" + title + '\'' +
                ", descriptionTask='" + description + '\'' +
                ", archivedTask=" + archived +
                ", groupId=" + '}';
    }
}
