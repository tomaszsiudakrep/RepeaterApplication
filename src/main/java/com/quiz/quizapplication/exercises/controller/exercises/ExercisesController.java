package com.quiz.quizapplication.exercises.controller;

import com.quiz.quizapplication.exercises.data.exercises.DataExercises;
import com.quiz.quizapplication.exercises.data.sqlQuery.SqlQueryExercises;
import com.quiz.quizapplication.importantInformation.data.importantInformation.ImportantInformationAlert;
import com.quiz.quizapplication.importantInformation.scene.importantInformation.ImportantInformationScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import java.sql.SQLException;
import java.util.List;

public class ExercisesController {

    DataExercises dataExercises = new DataExercises();
    ImportantInformationAlert importantInformationAlert = new ImportantInformationAlert();
    SqlQueryExercises sqlQueryExercises = new SqlQueryExercises();
    public static String groupNameFromChoiceBox;

    public ObservableList<String> createObservableListToListView() throws SQLException {
        String sqlQuery = sqlQueryExercises.sqlQuerySelectAllFromExercises();
        List<String> list = dataExercises.createList(sqlQuery);
        return dataExercises.observableList(list);
    }

    public ObservableList<String> createObservableListToListViewByGroup(String groupName) throws SQLException {
        String sqlQuery = sqlQueryExercises.sqlQuerySelectAllFromExercisesWhereGroup(groupName);
        List<String> list = dataExercises.createList(sqlQuery);
        return dataExercises.observableList(list);
    }

    public void createListViewByGroup() throws SQLException {
        ObservableList<String> fullListToListView = createObservableListToListView();
        ObservableList<String> emptyList = FXCollections.emptyObservableList();
        String groupName = groupNameFromChoiceBox;
        ObservableList<String> observableList = createObservableListToListViewByGroup(groupName);
        if (groupName != null && observableList.size() > 0) {
            ImportantInformationScene.listView = new ListView<>(observableList);
            ImportantInformationScene.groupChoiceBox.setValue(groupNameFromChoiceBox);
        } else if (groupName == null){
            ImportantInformationScene.listView = new ListView<>(fullListToListView);
        } else {
            ImportantInformationScene.listView = new ListView<>(emptyList);
            ImportantInformationScene.groupChoiceBox.setValue(groupNameFromChoiceBox);
        }
    }

    public String downloadGroupFromChoiceBox() {
        return groupNameFromChoiceBox = ImportantInformationScene.groupChoiceBox.getValue();
    }

    public void deleteImportantInformation() throws SQLException {
        String listViewItem = dataExercises.downloadChosenElementFromListView();
        if (listViewItem != null) {
            int informationId = dataExercises.returnIdInformationFromListViewItem(listViewItem);
            String sqlQuery = sqlQueryExercises.sqlQueryDeleteExercises(informationId);
            ImportantInformationAlert.dialogConfirmation.showAndWait();
            if (ImportantInformationAlert.dialogConfirmation.getResult() == ButtonType.OK) {
                boolean resultDelete = dataExercises.deleteInformation(sqlQuery);
                if (resultDelete) importantInformationAlert.informationHasBeenDeleted();
                else importantInformationAlert.informationWasNotDeleted();
                ImportantInformationAlert.dialogInformation.show();
            }
        }
    }

    public void changeTitleInformation() {
        String listViewItem = dataExercises.downloadChosenElementFromListView();
        String newTitle = dataExercises.downloadTitleFromChangeTitleTextField();
        if (!newTitle.equals("") && listViewItem != null) {
            int informationId = dataExercises.returnIdInformationFromListViewItem(listViewItem);
            String sqlQueryReturnGroupId = sqlQueryExercises.sqlQueryReturnGroupIdByExercisesId(informationId);
            int groupId = dataExercises.returnGroupIdFromTableInformation(sqlQueryReturnGroupId);
            String sqlQueryCheckIfNewTitleExist = sqlQueryExercises.sqlQueryCheckIfNewTitleIsExistInGroup(groupId, newTitle);
            boolean result = dataExercises.checkIfNewTitleExist(sqlQueryCheckIfNewTitleExist);
            if (!result) {
                String sqlQueryUpdate = sqlQueryExercises.sqlQueryUpdateTitle(informationId, newTitle);
                boolean resultUpdate = dataExercises.updateTitle(sqlQueryUpdate);
                if (resultUpdate) {
                    importantInformationAlert.titleHasBeenChanged();
                    ImportantInformationScene.changeTitleTextField.clear();
                }
                else importantInformationAlert.titleWasNotChanged();
            } else {
                importantInformationAlert.newTitleIsAlreadyExist();
            }
        } else {
            importantInformationAlert.newTitleIsEmptyOrItemFromListViewIsNull();
        }
        ImportantInformationAlert.dialogInformation.show();
    }

    public void changeGroup() {
        String groupName = dataExercises.downloadNewGroupFromChoiceBox();
        String chosenItemList = dataExercises.downloadChosenElementFromListView();
        if (groupName != null && chosenItemList != null) {
            String sqlQueryReturnId = sqlQueryExercises.sqlQueryReturnGroupIdByNameOfGroup(groupName);
            int chosenGroupId = dataExercises.returnGroupIdFromTableGroup(sqlQueryReturnId);
            String titleOfInformation = dataExercises.returnTitleInformationFromListViewItem(chosenItemList);
            String sqlQueryCheckIfTitleExist = sqlQueryExercises.sqlQueryCheckIfNewTitleIsExistInGroup(chosenGroupId, titleOfInformation);
            boolean result = dataExercises.checkIfNewTitleExist(sqlQueryCheckIfTitleExist);
            if (!result) {
                int informationId = dataExercises.returnIdInformationFromListViewItem(chosenItemList);
                String sqlQueryChangeGroup = sqlQueryExercises.sqlQueryUpdateGroup(chosenGroupId, informationId);
                dataExercises.changeGroup(sqlQueryChangeGroup);
                importantInformationAlert.groupHasBeenChanged();
            } else {
                importantInformationAlert.groupWasNotChanged();
            }
        } else {
            importantInformationAlert.newGroupIsNullOrItemFromListViewIsNull();
        }
        ImportantInformationAlert.dialogInformation.show();
    }
}
