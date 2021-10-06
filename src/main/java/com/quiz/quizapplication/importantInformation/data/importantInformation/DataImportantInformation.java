package com.quiz.quizapplication.importantInformation.data.importantInformation;

import com.quiz.quizapplication.database.ConnectToDb;
import com.quiz.quizapplication.importantInformation.scene.importantInformation.ImportantInformationScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ImportantInformationDataBase {

    public String sqlQuerySelectAllFromInformation() {
        return "SELECT * FROM IMPORTANT_INFORMATION WHERE ARCHIVED = 0 ORDER BY GROUP_ID";
    }

    public String sqlQuerySelectAllFromInformationWhereGroup(String groupName) {
        return "SELECT * FROM IMPORTANT_INFORMATION WHERE ARCHIVED = 0 AND GROUP_ID = " +
                "(SELECT ID FROM GROUP_IMPORTANT_INFORMATION WHERE NAME = '" + groupName + "')";
    }

    public String sqlQueryDeleteInformation(int informationId) {
        return "DELETE FROM IMPORTANT_INFORMATION WHERE ID = " + informationId;
    }

    public String sqlQueryUpdateTitle(int informationId, String newTitle) {
        return "UPDATE IMPORTANT_INFORMATION SET TITLE = '" + newTitle + "' WHERE ID = " + informationId;
    }

    public String sqlQueryReturnGroupIdByInformationId(int informationId) {
        return "SELECT GROUP_ID FROM IMPORTANT_INFORMATION WHERE ID = " + informationId;
    }

    public String sqlQueryCheckIfNewTitleIsExistInGroup(int groupId, String newTitle) {
        return "SELECT * FROM IMPORTANT_INFORMATION WHERE TITLE = '" + newTitle + "' AND GROUP_ID = " + groupId;
    }

    public String sqlQueryReturnGroupIdByNameOfGroup(String groupName) {
        return "SELECT ID FROM GROUP_IMPORTANT_INFORMATION WHERE NAME = '" + groupName + "'";
    }

    public String sqlQueryUpdateGroup(int newGroupId, int informationId) {
        return "UPDATE IMPORTANT_INFORMATION SET GROUP_ID = " + newGroupId + " WHERE ID = " + informationId;
    }

    public List<String> createList(String sqlQuery) throws SQLException {
        List<String> list = new ArrayList<>();
        Statement statement = ConnectToDb.getInstance().getConn().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                String title = resultSet.getString("TITLE");
                int id = resultSet.getInt("ID");
                list.add(id + "/" + title);
            }
            resultSet.close();
            statement.close();
        return list;
    }

    public ObservableList<String> observableList(List<String> list) {
        return FXCollections.observableList(list);
    }

    public boolean deleteInformation(String sqlQuery) {
        boolean result = false;
        try {
            Statement statement = ConnectToDb.getInstance().getConn().createStatement();
                statement.executeUpdate(sqlQuery);
                result = true;
        } catch (SQLException e) {
            System.out.println("Wrong: " + e);
        }
        return result;
    }

    public String downloadChosenElementFromListView() {
        return ImportantInformationScene.listView.getSelectionModel().getSelectedItem();
    }

    public int returnIdInformationFromListViewItem(String listViewItem) {
        String varId = listViewItem.substring(0, listViewItem.indexOf("/"));
        return Integer.parseInt(varId);
    }

    public String returnTitleInformationFromListViewItem(String listViewItem) {
        return listViewItem.substring(listViewItem.indexOf("/")+1);
    }

    public String downloadTitleFromChangeTitleTextField() {
        return ImportantInformationScene.changeTitleTextField.getText();
    }

    public int returnGroupIdFromTableInformation(String sqlQuery) {
        int groupId = 0;
        try {
            Statement statement = ConnectToDb.getInstance().getConn().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
                resultSet.next();
                groupId = resultSet.getInt("GROUP_ID");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groupId;
    }

    public boolean checkIfNewTitleExist(String sqlQuery) {
        boolean result = false;
        int counter = 0;
        try {
            Statement statement = ConnectToDb.getInstance().getConn().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
                while (resultSet.next()) {
                    counter++;
                }
                if (counter > 0) result = true;
                resultSet.close();
                statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean updateTitle(String sqlQuery) {
        boolean result = false;
        try {
            Statement statement = ConnectToDb.getInstance().getConn().createStatement();
                statement.executeUpdate(sqlQuery);
                result = true;
                statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String downloadNewGroupFromChoiceBox() {
        return ImportantInformationScene.changeGroupChoiceBox.getValue();
    }

    public boolean changeGroup(String sqlQuery) {
        boolean result = false;
        try {
            Statement statement = ConnectToDb.getInstance().getConn().createStatement();
                statement.executeUpdate(sqlQuery);
                result = true;
                statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int returnGroupIdFromTableGroup(String sqlQuery) {
        int groupId = 0;
        try {
            Statement statement = ConnectToDb.getInstance().getConn().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            resultSet.next();
            groupId = resultSet.getInt("ID");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groupId;
    }


}
