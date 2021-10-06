package com.quiz.quizapplication.exercises.objects;

import com.quiz.quizapplication.importantInformation.objects.GroupInformation;

public class GroupExercises extends GroupInformation {

    private boolean archived;

    public GroupExercises(String groupName) {
        super(groupName);
        archived = false;
    }

}
