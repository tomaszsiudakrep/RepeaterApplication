package com.quiz.quizapplication.tasks.objects;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class Task {

    String title;
    String description;
    String list;
    String category;
    String priority;
    LocalDate startDate;
    LocalTime startTime;
    LocalDate endDate;
    LocalTime endTime;
    String reminderSelect;
    int completePercent;


    public Task(String title, String description, String list, String category, String priority, LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime, String reminderSelect) {
        this.title = title;
        this.description = description;
        this.list = list;
        this.category = category;
        this.priority = priority;
        this.startDate = startDate;
        this.startTime = startTime;
        this.endDate = endDate;
        this.endTime = endTime;
        this.reminderSelect = reminderSelect;
        completePercent = 0;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getList() {
        return list;
    }

    public String getCategory() {
        return category;
    }

    public String getPriority() {
        return priority;
    }

    public int getCompletePercent() {
        return completePercent;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getReminderSelect() {
        return reminderSelect;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

}
