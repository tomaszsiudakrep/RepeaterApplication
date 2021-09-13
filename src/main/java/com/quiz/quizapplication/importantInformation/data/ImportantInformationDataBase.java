package com.quiz.quizapplication.importantInformation.data;

import com.quiz.quizapplication.database.ConnectToDb;
import com.quiz.quizapplication.importantInformation.ImportantInformation;
import java.sql.SQLException;
import java.sql.Statement;

public class ImportantInformationDataBase {

    public boolean addInformation(ImportantInformation importantInformation, Integer groupId) throws SQLException {
        boolean addResult = false;
        String sqlAddInfo = "INSERT INTO IMPORTANT_INFORMATION (TITLE, DESCRIPTION, GROUP_ID, ARCHIVED) VALUES " +
                            "('" + importantInformation.getTitleTask() + "', '" + importantInformation.getDescriptionTask() + "', "
                            + groupId + ",'"
                            + importantInformation.isArchivedInformation() + "')";
        try {
            Statement statement = ConnectToDb.getInstance().getConn().createStatement();
            statement.executeUpdate(sqlAddInfo);
            statement.close();
            addResult = true;
        } catch (SQLException e) {
            System.out.println("Wrong: " + e);
        }
        return addResult;
    }
}
