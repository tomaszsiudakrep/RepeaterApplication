package com.quiz.quizapplication.importantInformation.controller.information;

import com.quiz.quizapplication.data.alerts.AlertObject;
import com.quiz.quizapplication.importantInformation.data.importantInformation.DataImportantInformation;
import com.quiz.quizapplication.importantInformation.scene.importantInformation.ImportantInformationScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import java.sql.SQLException;
import java.util.List;

public class ImportantInformationController {

    DataImportantInformation dataImportantInformation = new DataImportantInformation();
    AlertObject alertObject = new AlertObject();
    public static String groupNameFromChoiceBox;

    public ObservableList<String> createObservableListToListView() throws SQLException {
        String sqlQuery = "SELECT * FROM IMPORTANT_INFORMATION WHERE ARCHIVED = 0 ORDER BY GROUP_ID";
        List<String> list = dataImportantInformation.createList(sqlQuery);
        return dataImportantInformation.observableList(list);
    }

    public ObservableList<String> createObservableListToListViewByGroup(String groupName) throws SQLException {
        String sqlQuery = "SELECT * FROM IMPORTANT_INFORMATION WHERE ARCHIVED = 0 AND GROUP_ID = " +
                "(SELECT ID FROM GROUP_IMPORTANT_INFORMATION WHERE NAME = '" + groupName + "')";
        List<String> list = dataImportantInformation.createList(sqlQuery);
        return dataImportantInformation.observableList(list);
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
        String listViewItem = dataImportantInformation.downloadChosenElementFromListView();
        if (listViewItem != null) {
            int informationId = dataImportantInformation.returnIdInformationFromListViewItem(listViewItem);
            AlertObject.dialogConfirmation.showAndWait();
            if (AlertObject.dialogConfirmation.getResult() == ButtonType.OK) {
                boolean resultDelete = dataImportantInformation.deleteInformation(informationId);
                if (resultDelete) alertObject.informationHasBeenDeleted();
                else alertObject.informationWasNotDeleted();
                AlertObject.dialogInformation.show();
            }
        }
    }

    public void changeTitleInformation() {
        String listViewItem = dataImportantInformation.downloadChosenElementFromListView();
        String newTitle = dataImportantInformation.downloadTitleFromChangeTitleTextField();
        if (!newTitle.equals("") && listViewItem != null) {
            int informationId = dataImportantInformation.returnIdInformationFromListViewItem(listViewItem);
            int groupId = dataImportantInformation.returnGroupIdFromTableInformation(informationId);
            boolean result = dataImportantInformation.checkIfNewTitleExist(groupId, newTitle);
                if (!result) {
                    boolean resultUpdate = dataImportantInformation.updateTitle(newTitle, informationId);
                        if (resultUpdate) {
                            alertObject.titleHasBeenChanged();
                            ImportantInformationScene.changeTitleTextField.clear();
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

    public void changeGroup() {
        String groupName = dataImportantInformation.downloadNewGroupFromChoiceBox();
        String chosenItemList = dataImportantInformation.downloadChosenElementFromListView();
        if (groupName != null && chosenItemList != null) {
            int chosenGroupId = dataImportantInformation.returnGroupIdFromTableGroup(groupName);
            String titleOfInformation = dataImportantInformation.returnTitleInformationFromListViewItem(chosenItemList);
            boolean result = dataImportantInformation.checkIfNewTitleExist(chosenGroupId, titleOfInformation);
                if (!result) {
                    int informationId = dataImportantInformation.returnIdInformationFromListViewItem(chosenItemList);
                    dataImportantInformation.changeGroup(chosenGroupId, informationId);
                    alertObject.groupHasBeenChanged();
                } else {
                    alertObject.groupWasNotChanged();
                }
        } else {
            alertObject.newGroupIsNullOrItemFromListViewIsNull();
        }
        AlertObject.dialogInformation.show();
    }

    public long sizeOfImportantInformation() {
        return dataImportantInformation.sizeOfListView();
    }

}
