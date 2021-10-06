package com.quiz.quizapplication.importantInformation.controller.add;

import com.quiz.quizapplication.data.file.LoadFileTxt;
import com.quiz.quizapplication.importantInformation.objects.ImportantInformation;
import com.quiz.quizapplication.data.alerts.AlertAddObject;
import com.quiz.quizapplication.importantInformation.data.add.DataAddInformationGroup;
import com.quiz.quizapplication.importantInformation.data.add.DataAddImportantInformation;
import java.io.IOException;
import java.sql.SQLException;

public class AddInformationController {

    ImportantInformation importantInformation;
    DataAddInformationGroup dataAddInformationGroup = new DataAddInformationGroup();
    DataAddImportantInformation dataAddImportantInformation = new DataAddImportantInformation();
    AlertAddObject alertAddObject = new AlertAddObject();
    LoadFileTxt loadFileTxt = new LoadFileTxt();

    public void addInformation() throws SQLException {
        String title = dataAddImportantInformation.downloadTitle();
        String description = dataAddImportantInformation.downloadDescription();
        String groupName = dataAddImportantInformation.downloadGroupFromChoiceBox();
        int groupId = dataAddInformationGroup.checkGroupId(groupName);
        boolean resultCheckExist = dataAddImportantInformation.checkIfObjectAlreadyExistInGroup(title, groupId);
        if (!resultCheckExist) {
            importantInformation = dataAddImportantInformation.createImportantInformationObject(title, description);
            if (!title.equals("") && groupName != null && !description.equals("")) {
                boolean result = dataAddImportantInformation.addImportantInformation(groupId, importantInformation);
                if (result) alertAddObject.informationHasBeenAdded();
                else alertAddObject.informationWasNotAdded();
                dataAddImportantInformation.clearTextField();
            } else {
                alertAddObject.informationTextFieldOrGroupIsEmpty();
            }
        } else {
            alertAddObject.informationAlreadyExist();
        }
        AlertAddObject.dialogInformation.show();

    }

    public void createFile() throws IOException {
        String title = dataAddImportantInformation.downloadTitle();
        String groupName = dataAddImportantInformation.downloadGroupFromChoiceBox();
        if (!title.equals("") && groupName != null) loadFileTxt.loadImportantInformation(groupName, title);
    }

}
