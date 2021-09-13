package com.quiz.quizapplication.importantInformation;

public class GroupInformation {

    private int id;
    private String groupName;
    private boolean archived;

    public GroupInformation(String groupName) {
        this.groupName = groupName;
        archived = false;
    }

    public int getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }

    public boolean isArchived() {
        return archived;
    }
}
