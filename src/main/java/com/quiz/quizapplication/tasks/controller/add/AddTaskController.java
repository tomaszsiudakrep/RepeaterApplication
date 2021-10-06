package com.quiz.quizapplication.tasks.controller;

import com.quiz.quizapplication.tasks.scene.AddTasksScene;

public class ClearFieldsController {

    public void clear() {
        AddTasksScene.titleTextField.clear();
        AddTasksScene.descriptionTextField.clear();
        AddTasksScene.choiceBoxList.setValue("To do");
        AddTasksScene.categoryTextField.clear();
        AddTasksScene.choiceBoxPriority.setValue("Low");
        AddTasksScene.startDateCheckBox.setSelected(false);
        AddTasksScene.endDateCheckBox.setSelected(false);
        AddTasksScene.doNotReminderCheckBox.setSelected(false);
    }
}
