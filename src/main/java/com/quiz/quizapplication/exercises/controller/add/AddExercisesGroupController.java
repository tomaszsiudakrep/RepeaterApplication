package com.quiz.quizapplication.exercises.controller;

import com.quiz.quizapplication.exercises.data.add.DataAddExercisesGroup;
import com.quiz.quizapplication.exercises.data.sqlQuery.SqlQueryAddExercisesGroup;
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
    SqlQueryAddExercisesGroup sqlQueryAddExercisesGroup = new SqlQueryAddExercisesGroup();

    public void addGroupExercises() throws SQLException {
        String groupName = dataAddExercisesGroup.downloadGroupNameToAdd().toUpperCase();
        String sqlQuery = sqlQueryAddExercisesGroup.sqlQuerySelectAllFromGroupWhereName(groupName);
        groupExercises =  sqlQueryAddExercisesGroup.createGroupExercisesObject(groupName);
        if (dataAddExercisesGroup.checkIfGroupNameIsNotNull(groupName) && dataAddExercisesGroup.checkIfGroupNameNotExist(sqlQuery)) {
            String sqlQueryAddGroup = sqlQueryAddExercisesGroup.sqlQueryAddGroup();
            boolean result = dataAddExercisesGroup.addGroup(sqlQueryAddGroup);
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
        String sqlQuery = sqlQueryAddExercisesGroup.sqlQuerySelectAllFromGroupWhereName(newGroupName);
        boolean groupNotExist = dataAddExercisesGroup.checkIfGroupNameNotExist(sqlQuery);
        if (groupNotExist && !newGroupName.equals("") && groupName != null) {
            String sqlQueryUpdate = sqlQueryAddExercisesGroup.sqlQueryUpdateGroupName(newGroupName, groupName);
            boolean result = dataAddExercisesGroup.changeGroupName(sqlQueryUpdate);
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
        String sqlQuery = sqlQueryAddExercisesGroup.sqlQueryDeleteGroup(groupName);
        if (groupName != null) {
            AlertAddGroup.dialogConfirmation.showAndWait();
            if (AlertAddGroup.dialogConfirmation.getResult() == ButtonType.OK) {
                boolean result = dataAddExercisesGroup.deleteGroup(sqlQuery);
                if (result) alertAddGroup.groupHasBeenDeleted();
                else alertAddGroup.groupWasNotDeleted();
                AlertAddGroup.dialogInformation.show();
            }
        }
    }

    public ObservableList<String> createObservableListToChoiceBox() throws SQLException {
        String sqlQuery = sqlQueryAddExercisesGroup.sqlQuerySelectAllFromGroup();
        return FXCollections.observableList(dataAddExercisesGroup.createGroupList(sqlQuery));
    }
}
