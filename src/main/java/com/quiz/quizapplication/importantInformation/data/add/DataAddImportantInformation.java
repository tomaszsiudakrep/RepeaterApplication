package com.quiz.quizapplication.importantInformation.data.add;

import com.quiz.quizapplication.database.ConnectToDb;
import com.quiz.quizapplication.importantInformation.objects.ImportantInformation;
import com.quiz.quizapplication.importantInformation.scene.add.AddInformationScene;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAddImportantInformation {

    ImportantInformation importantInformation;

    public String downloadTitle() {
        return AddInformationScene.titleTextField.getText();
    }

    public String downloadGroupFromChoiceBox() {
        return AddInformationScene.groupChoiceBox.getValue();
    }

    public String downloadDescription() {
        return AddInformationScene.descriptionTextArea.getText();
    }

    public boolean addImportantInformation(int groupId, ImportantInformation importantInformation) {
        boolean addResult = false;
        String sqlQuery = "INSERT INTO IMPORTANT_INFORMATION (TITLE, DESCRIPTION, GROUP_ID, ARCHIVED) VALUES "+
                "('" + importantInformation.getTitle()   + "', '" + importantInformation.getDescription() + "', "
                + groupId + ",'"
                + importantInformation.isArchivedInformation() + "')";
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

    public boolean checkIfObjectAlreadyExistInGroup(String title, int groupId) {
        boolean result = false;
        String sqlQuery = "SELECT * FROM IMPORTANT_INFORMATION WHERE TITLE = '" + title + "' AND GROUP_ID =" + groupId;
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

    public ImportantInformation createImportantInformationObject(String title, String description) {
        return importantInformation = new ImportantInformation(title, description);
    }
}
