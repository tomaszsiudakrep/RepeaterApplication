package com.quiz.quizapplication.importantInformation.controller.add;

import com.quiz.quizapplication.data.alerts.AlertAddGroup;
import com.quiz.quizapplication.importantInformation.objects.GroupInformation;
import com.quiz.quizapplication.importantInformation.scene.add.AddGroupInformationScene;
import com.quiz.quizapplication.importantInformation.data.add.DataAddInformationGroup;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ButtonType;
import java.sql.SQLException;

public class AddInformationGroupController {

    GroupInformation groupInformation;
    DataAddInformationGroup dataAddInformationGroup = new DataAddInformationGroup();
    AlertAddGroup alertAddGroup = new AlertAddGroup();

    public void addGroupImportantInformation() throws SQLException {
        String groupName = dataAddInformationGroup.downloadGroupNameToAdd().toUpperCase();
        groupInformation =  dataAddInformationGroup.createGroupObject(groupName);
        if (dataAddInformationGroup.checkIfGroupNameIsNotNull(groupName) && dataAddInformationGroup.checkIfGroupNameNotExist(groupName)) {
            boolean result = dataAddInformationGroup.addGroup(groupInformation);
                if (result) alertAddGroup.groupHasBeenAdded();
                else alertAddGroup.groupWasNotAdded();
        } else {
            alertAddGroup.groupNameIsNullOrAlreadyExists();
        }
        AlertAddGroup.dialogInformation.show();
        AddGroupInformationScene.groupTextField.clear();
    }

    public void changeGroupName() throws SQLException {
        String groupName = dataAddInformationGroup.downloadGroupNameFromChoiceBox();
        String newGroupName = dataAddInformationGroup.downloadNewGroupNameToChangeTitle().toUpperCase();
        boolean groupNotExist = dataAddInformationGroup.checkIfGroupNameNotExist(groupName);
        if (groupNotExist && !newGroupName.equals("") && groupName != null) {
            boolean result = dataAddInformationGroup.changeGroupName(newGroupName, groupName);
            if (result) alertAddGroup.groupNameHasBeenChanged();
            else alertAddGroup.groupNameWasNotChanged();
        }
        else {
            alertAddGroup.groupNameIsNullOrAlreadyExists();
        }
        AlertAddGroup.dialogInformation.show();
        AddGroupInformationScene.newNameOfGroupTextField.clear();
    }

    public void deleteGroup() throws SQLException {
        String groupName = dataAddInformationGroup.downloadGroupNameFromChoiceBox();
        if (groupName != null) {
            AlertAddGroup.dialogConfirmation.showAndWait();
            if (AlertAddGroup.dialogConfirmation.getResult() == ButtonType.OK) {
                boolean result = dataAddInformationGroup.deleteGroup(groupName);
                if (result) alertAddGroup.groupHasBeenDeleted();
                else alertAddGroup.groupWasNotDeleted();
                AlertAddGroup.dialogInformation.show();
            }
        }
    }

    public ObservableList<String> createObservableListToChoiceBox() throws SQLException {
        return FXCollections.observableList(dataAddInformationGroup.createGroupList());
    }
}
