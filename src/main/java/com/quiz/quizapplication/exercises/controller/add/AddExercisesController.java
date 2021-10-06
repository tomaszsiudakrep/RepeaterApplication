package com.quiz.quizapplication.exercises.controller;

import com.quiz.quizapplication.data.LoadSolution;
import com.quiz.quizapplication.exercises.data.add.DataAddExercises;
import com.quiz.quizapplication.exercises.data.add.DataAddExercisesGroup;
import com.quiz.quizapplication.exercises.data.sqlQuery.SqlQueryAddExercises;
import com.quiz.quizapplication.exercises.data.sqlQuery.SqlQueryAddExercisesGroup;
import com.quiz.quizapplication.exercises.objects.Exercises;
import com.quiz.quizapplication.exercises.data.DataFromDb;
import com.quiz.quizapplication.exercises.data.GroupExToDb;
import com.quiz.quizapplication.exercises.scene.add.AddExercisesScene;
import com.quiz.quizapplication.data.alerts.AlertAddInformation;
import java.io.IOException;
import java.sql.SQLException;

public class AddExercisesController {

    Exercises exercises;
    GroupExToDb groupExToDb = new GroupExToDb();
    DataFromDb dataFromDb = new DataFromDb();

    AlertAddInformation alertAddInformation = new AlertAddInformation();
    DataAddExercises dataAddExercises = new DataAddExercises();
    DataAddExercisesGroup dataAddExercisesGroup = new DataAddExercisesGroup();
    SqlQueryAddExercises sqlQueryAddExercises = new SqlQueryAddExercises();
    SqlQueryAddExercisesGroup sqlQueryAddExercisesGroup = new SqlQueryAddExercisesGroup();
    LoadSolution loadSolution = new LoadSolution();

    public void addExercise2() {
        int id =  0;
        String varTitle = AddExercisesScene.titleTextField.getText();
        String varDesc = AddExercisesScene.descriptionTextArea.getText();
        exercises = new Exercises(varTitle, varDesc);
        String name = AddExercisesScene.groupChoiceBox.getValue();

        try {
            id = groupExToDb.checkId(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (id == 0) {
            System.out.println("Exercises not added because the group not exist");
        } else {
            dataFromDb.saveExercisesToDb(exercises, id);
            AddExercisesScene.titleTextField.clear();
            AddExercisesScene.descriptionTextArea.clear();
        }
    }

    public void addExercises() {
        String title = dataAddExercises.downloadTitle();
        String description = dataAddExercises.downloadDescription();
        String groupName = dataAddExercises.downloadGroupFromChoiceBox();
        String sqlQuery2 = sqlQueryAddExercisesGroup.sqlQuerySelectAllFromGroupWhereName(groupName);
        int groupId = dataAddExercisesGroup.checkGroupId(sqlQuery2);
        String sqlQueryCheckIfInformationExist = sqlQueryAddExercises.sqlQueryCheckIfExercisesAlreadyExist(title, groupId);
        boolean resultCheckExist = dataAddExercises.checkIfObjectAlreadyExistInGroup(sqlQueryCheckIfInformationExist);
        if (!resultCheckExist) {
            exercises = sqlQueryAddExercises.createExercisesObject(title, description);
            String sqlQuery = sqlQueryAddExercises.sqlQueryAddExercises(groupId);
            if (!title.equals("") && groupName != null && !description.equals("")) {
                boolean result = dataAddExercises.addObject(sqlQuery);
                if (result) alertAddInformation.informationHasBeenAdded();
                else alertAddInformation.informationWasNotAdded();
                dataAddExercises.clearTextField();
            } else {
                alertAddInformation.informationTextFieldOrGroupIsEmpty();
            }
        } else {
            alertAddInformation.informationAlreadyExist();
        }
        AlertAddInformation.dialogInformation.show();
    }

    public void createFile() throws IOException {
        String title = dataAddExercises.downloadTitle();
        String groupName = dataAddExercises.downloadGroupFromChoiceBox();
        if (!title.equals("") && groupName != null) loadSolution.loadExampleSolution(groupName, title);
    }


}
