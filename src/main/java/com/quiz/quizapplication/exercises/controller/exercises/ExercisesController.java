package com.quiz.quizapplication.exercises.controller.exercises;

import com.quiz.quizapplication.exercises.data.exercises.DataExercises;
import com.quiz.quizapplication.exercises.scene.ownExercises.OwnExercisesScene;
import com.quiz.quizapplication.data.alerts.AlertObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import java.sql.SQLException;
import java.util.List;

public class ExercisesController {

    DataExercises dataExercises = new DataExercises();
    AlertObject alertObject = new AlertObject();
    public static String groupNameFromChoiceBox;

    public ObservableList<String> createObservableListToListView() throws SQLException {
        String sqlQuery = "SELECT * FROM EXERCISES WHERE ARCHIVED = 0 ORDER BY GROUP_ID";
        List<String> list = dataExercises.createList(sqlQuery);
        return dataExercises.observableList(list);
    }

    public ObservableList<String> createObservableListToListViewByGroup(String groupName) throws SQLException {
        String sqlQuery = "SELECT * FROM EXERCISES WHERE ARCHIVED = 0 AND GROUP_ID = " +
                "(SELECT ID FROM GROUP_EXERCISES WHERE NAME = '" + groupName + "')";
        List<String> list = dataExercises.createList(sqlQuery);
        return dataExercises.observableList(list);
    }

    public void createListViewByGroup() throws SQLException {
        ObservableList<String> fullListToListView = createObservableListToListView();
        ObservableList<String> emptyList = FXCollections.emptyObservableList();
        String groupName = groupNameFromChoiceBox;
        ObservableList<String> observableList = createObservableListToListViewByGroup(groupName);
        if (groupName != null && observableList.size() > 0) {
            OwnExercisesScene.listView = new ListView<>(observableList);
            OwnExercisesScene.groupChoiceBox.setValue(groupNameFromChoiceBox);
        } else if (groupName == null){
            OwnExercisesScene.listView = new ListView<>(fullListToListView);
        } else {
            OwnExercisesScene.listView = new ListView<>(emptyList);
            OwnExercisesScene.groupChoiceBox.setValue(groupNameFromChoiceBox);
        }
    }

    public void downloadGroupFromChoiceBox() {
        groupNameFromChoiceBox = OwnExercisesScene.groupChoiceBox.getValue();
    }

    public void deleteChosenExercises() {
        String listViewItem = dataExercises.downloadChosenElementFromListView();
        if (listViewItem != null) {
            int exerciseId = dataExercises.returnIdInformationFromListViewItem(listViewItem);
            AlertObject.dialogConfirmation.showAndWait();
            if (AlertObject.dialogConfirmation.getResult() == ButtonType.OK) {
                boolean resultDelete = dataExercises.deleteExercise(exerciseId);
                if (resultDelete) alertObject.informationHasBeenDeleted();
                else alertObject.informationWasNotDeleted();
                AlertObject.dialogInformation.show();
            }
        }
    }

    public void deleteAllExercises() {
        AlertObject.dialogConfirmationAll.showAndWait();
        if (AlertObject.dialogConfirmationAll.getResult() == ButtonType.OK) {
            boolean resultDeleteAll = dataExercises.deleteAllExercises();
            if (resultDeleteAll) alertObject.allInformationHasBeenDeleted();
            else alertObject.allInformationWasNotDeleted();
            AlertObject.dialogInformation.show();
        }
    }

    public void changeTitleExercises() {
        String listViewItem = dataExercises.downloadChosenElementFromListView();
        String newTitle = dataExercises.downloadTitleFromChangeTitleTextField();
        if (!newTitle.equals("") && listViewItem != null) {
            int informationId = dataExercises.returnIdInformationFromListViewItem(listViewItem);
            int groupId = dataExercises.returnGroupIdFromTableInformation(informationId);
            boolean result = dataExercises.checkIfNewTitleExist(groupId, newTitle);
            if (!result) {
                boolean resultUpdate = dataExercises.updateTitle(newTitle, informationId);
                if (resultUpdate) {
                    alertObject.titleHasBeenChanged();
                    OwnExercisesScene.changeTitleTextField.clear();
                }
                else alertObject.titleWasNotChanged();
            } else {
                alertObject.newTitleIsAlreadyExist();
            }
        } else {
            alertObject.newTitleIsEmptyOrItemFromListViewIsNull();
        }
        AlertObject.dialogInformation.show();
    }

    public void changeGroupExercises() {
        String groupName = dataExercises.downloadNewGroupFromChoiceBox();
        String chosenItemList = dataExercises.downloadChosenElementFromListView();
        if (groupName != null && chosenItemList != null) {
            int chosenGroupId = dataExercises.returnGroupIdFromTableGroup(groupName);
            String titleOfInformation = dataExercises.returnTitleInformationFromListViewItem(chosenItemList);
            boolean result = dataExercises.checkIfNewTitleExist(chosenGroupId, titleOfInformation);
            if (!result) {
                int informationId = dataExercises.returnIdInformationFromListViewItem(chosenItemList);
                dataExercises.changeGroup(chosenGroupId, informationId);
                alertObject.groupHasBeenChanged();
            } else {
                alertObject.groupWasNotChanged();
            }
        } else {
            alertObject.newGroupIsNullOrItemFromListViewIsNull();
        }
        AlertObject.dialogInformation.show();
    }

    public long sizeOfListView() {
        return dataExercises.sizeOfListView();
    }
}
