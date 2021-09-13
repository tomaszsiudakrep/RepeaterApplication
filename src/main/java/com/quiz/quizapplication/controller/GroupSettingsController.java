package com.quiz.quizapplication.controller;

import com.quiz.quizapplication.database.GroupToDb;
import com.quiz.quizapplication.scene.settingsScene.GroupSettings;

import java.sql.SQLException;

public class GroupSettingsController {

    GroupToDb groupToDb = new GroupToDb();

    public boolean addGroupToDb() {
        boolean addGroupResult = false;
        String nameOfGroup = GroupSettings.groupTextField.getText().toUpperCase();
        try {
            boolean result = groupToDb.checkNameGroup(nameOfGroup);
            if (!result) {
                groupToDb.addGroup(nameOfGroup);
                GroupSettings.groupTextField.clear();
                addGroupResult = true;
            } else {
                GroupSettings.groupTextField.setText("Group exist!");
            }
        } catch (SQLException e) {
            System.out.println("Wrong: " + e);
        }
        return addGroupResult;
    }

    public boolean deleteGroupFromDb() {
        boolean delGroupResult = false;
        String groupName = GroupSettings.choiceBoxNew.getValue();
        System.out.println(groupName);
        try {
            groupToDb.archiveGroup(groupName);
            delGroupResult = true;
        } catch (SQLException e) {
            System.out.println("Wrong: " + e);
        }
        return delGroupResult;
    }

    public boolean changeGroupName() {
        boolean changeNameResult = false;
        String groupName = GroupSettings.choiceBoxNew.getValue();
        System.out.println(groupName);
        String newGroupName = GroupSettings.newNameOfGroupTextField.getText().toUpperCase();
        boolean newGroupNameExist = false;
        try {
            newGroupNameExist = groupToDb.checkNameGroup(newGroupName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (!newGroupNameExist) {
            try {
                groupToDb.changeGroupName(groupName, newGroupName);
                changeNameResult = true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            GroupSettings.newNameOfGroupTextField.clear();
        } else {
            GroupSettings.newNameOfGroupTextField.setText("New group name is already exist");
        }
        return changeNameResult;
    }
}
