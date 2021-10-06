package com.quiz.quizapplication.exercises.controller.add;

import com.quiz.quizapplication.exercises.data.add.DataAddExercisesGroup;
import com.quiz.quizapplication.exercises.objects.GroupExercises;
import com.quiz.quizapplication.exercises.scene.add.AddGroupExercisesScene;
import com.quiz.quizapplication.data.alerts.AlertAddGroup;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ButtonType;
import java.sql.SQLException;

public class AddExercisesGroupController {

    GroupExercises groupExercises;
    DataAddExercisesGroup dataAddExercisesGroup = new DataAddExercisesGroup();
    AlertAddGroup alertAddGroup = new AlertAddGroup();

    public void addGroupExercises() throws SQLException {
        String groupName = dataAddExercisesGroup.downloadGroupNameToAdd().toUpperCase();
        groupExercises =  dataAddExercisesGroup.createGroupExercisesObject(groupName);
        if (dataAddExercisesGroup.checkIfGroupNameIsNotNull(groupName) && dataAddExercisesGroup.checkIfGroupNameNotExist(groupName)) {
            boolean result = dataAddExercisesGroup.addGroup(groupExercises);
            if (result) alertAddGroup.groupHasBeenAdded();
            else alertAddGroup.groupWasNotAdded();
        } else {
            alertAddGroup.groupNameIsNullOrAlreadyExists();
        }
        AlertAddGroup.dialogInformation.show();
        AddGroupExercisesScene.groupTextField.clear();
    }

    public void changeGroupName() throws SQLException {
        String groupName = dataAddExercisesGroup.downloadGroupNameFromChoiceBox();
        String newGroupName = dataAddExercisesGroup.downloadNewGroupNameToChangeTitle().toUpperCase();
        boolean groupNotExist = dataAddExercisesGroup.checkIfGroupNameNotExist(newGroupName);
        if (groupNotExist && !newGroupName.equals("") && groupName != null) {
            boolean result = dataAddExercisesGroup.changeGroupName(newGroupName, groupName);
            if (result) alertAddGroup.groupNameHasBeenChanged();
            else alertAddGroup.groupNameWasNotChanged();
        }
        else {
            alertAddGroup.groupNameIsNullOrAlreadyExists();
        }
        AlertAddGroup.dialogInformation.show();
        AddGroupExercisesScene.newNameOfGroupTextField.clear();
    }

    public void deleteGroup() throws SQLException {
        String groupName = dataAddExercisesGroup.downloadGroupNameFromChoiceBox();
        if (groupName != null) {
            AlertAddGroup.dialogConfirmation.showAndWait();
            if (AlertAddGroup.dialogConfirmation.getResult() == ButtonType.OK) {
                boolean result = dataAddExercisesGroup.deleteGroup(groupName);
                if (result) alertAddGroup.groupHasBeenDeleted();
                else alertAddGroup.groupWasNotDeleted();
                AlertAddGroup.dialogInformation.show();
            }
        }
    }

    public ObservableList<String> createObservableListToChoiceBox() throws SQLException {
        String sqlQuery = "SELECT * FROM GROUP_EXERCISES WHERE ARCHIVED = 0";
        return FXCollections.observableList(dataAddExercisesGroup.createGroupList(sqlQuery));
    }
}
