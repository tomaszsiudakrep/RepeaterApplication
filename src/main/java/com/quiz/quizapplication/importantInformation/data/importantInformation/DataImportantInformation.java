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

public class DataImportantInformation {

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

    public boolean deleteInformation(int informationId) {
        boolean result = false;
        String sqlQuery = "DELETE FROM IMPORTANT_INFORMATION WHERE ID = " + informationId;
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

    public int returnGroupIdFromTableInformation(int informationId) {
        int groupId = 0;
        String sqlQuery = "SELECT GROUP_ID FROM IMPORTANT_INFORMATION WHERE ID = " + informationId;
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

    public boolean checkIfNewTitleExist(int groupId, String newTitle) {
        boolean result = false;
        int counter = 0;
        String sqlQuery = "SELECT * FROM IMPORTANT_INFORMATION WHERE TITLE = '" + newTitle + "' AND GROUP_ID = " + groupId;
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

    public boolean updateTitle(String newTitle, int informationId) {
        boolean result = false;
        String sqlQuery = "UPDATE IMPORTANT_INFORMATION SET TITLE = '" + newTitle + "' WHERE ID = " + informationId;
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

    public boolean changeGroup(int newGroupId, int informationId) {
        boolean result = false;
        String sqlQuery = "UPDATE IMPORTANT_INFORMATION SET GROUP_ID = " + newGroupId + " WHERE ID = " + informationId;
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

    public int returnGroupIdFromTableGroup(String groupName) {
        int groupId = 0;
        String sqlQuery = "SELECT ID FROM GROUP_IMPORTANT_INFORMATION WHERE NAME = '" + groupName + "'";
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

    public long sizeOfListView() {
        return ImportantInformationScene.listView.getItems().size();
    }


}
