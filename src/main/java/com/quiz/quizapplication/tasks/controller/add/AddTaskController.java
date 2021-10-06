package com.quiz.quizapplication.tasks.controller.add;

import com.quiz.quizapplication.tasks.data.add.DataAddTasks;
import com.quiz.quizapplication.tasks.data.add.DataDownloadValueFromFields;
import com.quiz.quizapplication.tasks.objects.Task;
import com.quiz.quizapplication.tasks.scene.AddTasksScene;
import java.text.ParseException;
import java.time.LocalDateTime;

public class AddTaskController {

    DataDownloadValueFromFields dataDownloadValueFromFields = new DataDownloadValueFromFields();
    DataAddTasks dataAddTasks = new DataAddTasks();
    Task task;

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

    public void addTask() throws ParseException {
        String title = dataDownloadValueFromFields.downloadTitle();
        String desc = dataDownloadValueFromFields.downloadDescription();
        String list = dataDownloadValueFromFields.downloadList();
        String category = dataDownloadValueFromFields.downloadCategory();
        String priority = dataDownloadValueFromFields.downloadPriority();
        LocalDateTime localStartDateTime = dataAddTasks.downloadStartDateTime();
        LocalDateTime localEndDateTime = dataAddTasks.downloadEndDateTime();
        String reminderSelect = dataDownloadValueFromFields.downloadReminderSelect();
        LocalDateTime localDateTime2 = LocalDateTime.now();
        task = new Task(title, desc, list, category, priority, localStartDateTime.toLocalDate(),localStartDateTime.toLocalTime(), localEndDateTime.toLocalDate(), localEndDateTime.toLocalTime(), reminderSelect);
        dataAddTasks.addTask(task);
        clear();
    }
}
