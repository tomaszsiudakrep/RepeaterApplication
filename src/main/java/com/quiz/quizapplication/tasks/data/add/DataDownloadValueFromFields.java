package com.quiz.quizapplication.tasks.data;

import com.quiz.quizapplication.tasks.scene.AddTasksScene;

import java.time.LocalDate;

public class DataDownloadValueFromFields {

    public String downloadTitle() {
        return AddTasksScene.titleTextField.getText();
    }

    public String downloadDescription() {
        return AddTasksScene.descriptionTextField.getText();
    }

    public String downloadList() {
        return AddTasksScene.choiceBoxList.getValue();
    }

    public String downloadCategory() {
        return AddTasksScene.categoryTextField.getText();
    }
    public String downloadPriority() {
        return AddTasksScene.choiceBoxPriority.getValue();
    }

    public LocalDate downloadStartDate() {
        return AddTasksScene.startDatePicker.getValue();
    }

    public LocalDate downloadEndDate() {
        return AddTasksScene.endDatePicker.getValue();
    }

    public LocalDate downloadReminderDate() {
        return AddTasksScene.reminderDatePicker.getValue();
    }
}
