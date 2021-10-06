package com.quiz.quizapplication.importantInformation.controller;

import com.quiz.quizapplication.LoadSolution;
import com.quiz.quizapplication.importantInformation.objects.ImportantInformation;
import com.quiz.quizapplication.importantInformation.data.AlertInformation;
import com.quiz.quizapplication.importantInformation.data.GroupDataBase;
import com.quiz.quizapplication.importantInformation.data.ImportantInformationDataBase;

import java.io.IOException;
import java.sql.SQLException;

public class AddInformationController {

    ImportantInformation importantInformation;
    GroupDataBase groupDataBase = new GroupDataBase();
    ImportantInformationDataBase importantInformationDataBase = new ImportantInformationDataBase();
    AlertInformation alertInformation = new AlertInformation();
    LoadSolution loadSolution = new LoadSolution();

    public void addInformation() throws SQLException {
        String title = importantInformationDataBase.downloadTitleInformation();
        String description = importantInformationDataBase.downloadInformationDescription();
        String groupName = importantInformationDataBase.downloadGroupFromChoiceBox();
        int groupId = groupDataBase.checkGroupId(groupName);
        importantInformation = importantInformationDataBase.createImportantInformationObject(title, description);
        String sqlQuery = importantInformationDataBase.sqlQueryAddInformation(groupId);
        if (!title.equals("") && groupName != null && !description.equals("")) {
            boolean result = importantInformationDataBase.addInformation(sqlQuery);
            if (result) alertInformation.informationHasBeenAdded();
            else alertInformation.informationWasNotAdded();
        } else {
            alertInformation.informationTextFieldOrGroupIsEmpty();
        }
        AlertInformation.dialogInformation.show();
        importantInformationDataBase.clearTextField();
    }

    public void createFile() throws IOException {
        String title = importantInformationDataBase.downloadTitleInformation();
        String groupName = importantInformationDataBase.downloadGroupFromChoiceBox();
        if (!title.equals("") && groupName != null) loadSolution.loadImportantInformation(groupName, title);
    }
}
