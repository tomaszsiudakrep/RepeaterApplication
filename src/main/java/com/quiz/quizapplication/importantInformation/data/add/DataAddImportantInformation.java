package com.quiz.quizapplication.importantInformation.data.add;

import com.quiz.quizapplication.database.ConnectToDb;
import com.quiz.quizapplication.importantInformation.objects.ImportantInformation;
import com.quiz.quizapplication.importantInformation.scene.add.AddInformationScene;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseAddImportantInformation {

    ImportantInformation importantInformation;

    public String sqlQueryAddInformation(int groupId) {
        return "INSERT INTO IMPORTANT_INFORMATION (TITLE, DESCRIPTION, GROUP_ID, ARCHIVED) VALUES "+
                "('" + importantInformation.getTitle()   + "', '" + importantInformation.getDescription() + "', "
                + groupId + ",'"
                + importantInformation.isArchivedInformation() + "')";
    }

    public String sqlQueryCheckIfInformationAlreadyExist(String title, String group) {
        return "SELECT * FROM IMPORTANT_INFORMATION WHERE TITLE = '" + title + "' AND GROUP_ID " +
                "= (SELECT ID FROM GROUP_IMPORTANT_INFORMATION WHERE NAME = '" + group + "')";
    }

    public String sqlQueryCheckIfInformationAlreadyExist(String title, int groupId) {
        return "SELECT * FROM IMPORTANT_INFORMATION WHERE TITLE = '" + title + "' AND GROUP_ID =" + groupId;
    }

    public ImportantInformation createImportantInformationObject(String title, String description) {
        return importantInformation = new ImportantInformation(title, description);
    }

    public String downloadTitleInformation() {
        return AddInformationScene.titleTextField.getText();
    }

    public String downloadGroupFromChoiceBox() {
        return AddInformationScene.groupChoiceBox.getValue();
    }

    public String downloadInformationDescription() {
        return AddInformationScene.descriptionTextArea.getText();
    }

    public boolean addInformation(String sqlQuery) throws SQLException {
        boolean addResult = false;
        try {
            Statement statement = ConnectToDb.getInstance().getConn().createStatement();
                statement.executeUpdate(sqlQuery);
                statement.close();
            addResult = true;
        } catch (SQLException e) {
            System.out.println("Wrong: " + e);
        }
        return addResult;
    }

    public void clearTextField() {
        AddInformationScene.titleTextField.clear();
        AddInformationScene.descriptionTextArea.clear();
    }

    public boolean checkIfInformationAlreadyExistInGroup(String sqlQuery) {
        boolean result = false;
        int counter = 0;
        try {
            Statement statement = ConnectToDb.getInstance().getConn().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
                while (resultSet.next()) {
                    counter++;
                }
                if (counter > 0) result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
