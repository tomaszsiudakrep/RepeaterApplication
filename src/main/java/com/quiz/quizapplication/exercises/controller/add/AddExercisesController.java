package com.quiz.quizapplication.exercises.controller.add;

import com.quiz.quizapplication.data.file.LoadFileTxt;
import com.quiz.quizapplication.exercises.data.add.DataAddExercises;
import com.quiz.quizapplication.exercises.data.add.DataAddExercisesGroup;
import com.quiz.quizapplication.exercises.objects.Exercises;
import com.quiz.quizapplication.data.alerts.AlertAddObject;
import java.io.IOException;

public class AddExercisesController {

    Exercises exercises;
    AlertAddObject alertAddObject = new AlertAddObject();
    DataAddExercises dataAddExercises = new DataAddExercises();
    DataAddExercisesGroup dataAddExercisesGroup = new DataAddExercisesGroup();
    LoadFileTxt loadFileTxt = new LoadFileTxt();

    public void addExercises() {
        String title = dataAddExercises.downloadTitle();
        String description = dataAddExercises.downloadDescription();
        String groupName = dataAddExercises.downloadGroupFromChoiceBox();
        int groupId = dataAddExercisesGroup.checkGroupId(groupName);
        boolean resultCheckExist = dataAddExercises.checkIfObjectAlreadyExistInGroup(title, groupId);
        if (!resultCheckExist) {
            exercises = dataAddExercises.createExercisesObject(title, description);
            if (!title.equals("") && groupName != null && !description.equals("")) {
                boolean result = dataAddExercises.addObject(groupId, exercises);
                if (result) alertAddObject.informationHasBeenAdded();
                else alertAddObject.informationWasNotAdded();
                dataAddExercises.clearTextField();
            } else {
                alertAddObject.informationTextFieldOrGroupIsEmpty();
            }
        } else {
            alertAddObject.informationAlreadyExist();
        }
        AlertAddObject.dialogInformation.show();
    }

    public void createFile() throws IOException {
        String title = dataAddExercises.downloadTitle();
        String groupName = dataAddExercises.downloadGroupFromChoiceBox();
        if (!title.equals("") && groupName != null) loadFileTxt.loadExampleSolution(groupName, title);
    }

}
