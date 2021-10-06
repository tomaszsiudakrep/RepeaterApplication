package com.quiz.quizapplication.tasks.data.add;

import com.quiz.quizapplication.tasks.scene.AddTasksScene;

import java.time.LocalDate;
import java.time.LocalTime;

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


    public Boolean downloadStartDateCheckBox() {
        return AddTasksScene.startDateCheckBox.selectedProperty().getValue();
    }

    public Boolean downloadEndDateCheckBox() {
        return AddTasksScene.endDateCheckBox.selectedProperty().getValue();
    }

    public Boolean downloadReminderDateCheckBox() {
        return AddTasksScene.doNotReminderCheckBox.selectedProperty().getValue();
    }

    public LocalTime downloadStartTime() {
        LocalTime localTime = LocalTime.of(0, 0);
        return localTime = LocalTime.of(AddTasksScene.startHour.getValue(), AddTasksScene.startMinute.getValue());
    }

    public LocalTime downloadEndTime() {
        LocalTime localTime = LocalTime.of(0, 0);
        return localTime = LocalTime.of(AddTasksScene.endHour.getValue(), AddTasksScene.endMinute.getValue());
    }

    public String downloadReminderSelect() {
        return AddTasksScene.reminderSelect.getValue();
    }
}
