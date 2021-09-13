package com.quiz.quizapplication.controller;

import com.quiz.quizapplication.Exercises;
import com.quiz.quizapplication.database.DataFromDb;
import com.quiz.quizapplication.database.GroupToDb;
import com.quiz.quizapplication.scene.addScene.AddExercisesScene;
import java.sql.SQLException;

public class AddExercisesController {

    Exercises exercises;
    GroupToDb groupToDb = new GroupToDb();
    DataFromDb dataFromDb = new DataFromDb();

    public void addExercise() {
        int id =  0;
        String varTitle = AddExercisesScene.titleTextField.getText();
        String varDesc = AddExercisesScene.descriptionTextArea.getText();
        exercises = new Exercises(varTitle, varDesc);
        String name = AddExercisesScene.groupChoiceBox.getValue();

        try {
            id = groupToDb.checkId(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (id == 0) {
            System.out.println("Exercises not added because the group not exist");
        } else {
            dataFromDb.saveExercisesToDb(exercises, id);
        }
        AddExercisesScene.titleTextField.clear();
        AddExercisesScene.descriptionTextArea.clear();
    }
}
