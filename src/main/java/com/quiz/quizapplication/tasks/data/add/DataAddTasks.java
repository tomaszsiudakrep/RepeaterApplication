package com.quiz.quizapplication.tasks.data.add;

import com.quiz.quizapplication.database.ConnectToDb;
import com.quiz.quizapplication.tasks.objects.Task;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DataAddTasks {

    DataDownloadValueFromFields dataDownloadValueFromFields = new DataDownloadValueFromFields();

    public boolean addTask(Task task) {
        boolean addResult = false;
        String sqlQuery = "INSERT INTO TASKS (TITLE, DESCRIPTION, LIST, CATEGORY, PRIORITY, START_DATE, START_TIME, END_DATE, END_TIME, REMINDER, COMPLETE_PERCENT, testTime) " +
                "VALUES ( '" + task.getTitle() + "','" + task.getDescription() + "','" + task.getList() + "','" + task.getCategory() + "', '" + task.getPriority() +
                "', '" + task.getStartDate() + "', '" + task.getStartTime() + "', '" + task.getEndDate() + "', '" + task.getEndTime() + "', '" + task.getReminderSelect() + "', " + task.getCompletePercent()  + ")";
        try {
            Statement statement = ConnectToDb.getInstance().getConn().createStatement();
                statement.executeUpdate(sqlQuery);
                statement.close();
                addResult = true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return addResult;
    }

    public LocalDate downloadStartDate() {
        LocalDate startDate = LocalDate.of(1800, 1, 1);
        if (dataDownloadValueFromFields.downloadStartDateCheckBox()) startDate = dataDownloadValueFromFields.downloadStartDate();
        return startDate;
    }

    public LocalTime downloadStartTime() {
        LocalTime startTime = LocalTime.of(0, 0, 0, 0);
        if (dataDownloadValueFromFields.downloadStartDateCheckBox()) startTime = dataDownloadValueFromFields.downloadStartTime();
        return startTime;
    }

    public LocalDateTime downloadStartDateTime() {
        LocalDate localDate = downloadStartDate();
        LocalTime localTime = downloadStartTime();
        return LocalDateTime.of(localDate, localTime);
    }

    public LocalDate downloadEndDate() {
        LocalDate endDate = LocalDate.of(1800, 1, 1);
        if (dataDownloadValueFromFields.downloadEndDateCheckBox()) endDate = dataDownloadValueFromFields.downloadEndDate();
        return endDate;
    }

    public LocalTime downloadEndTime() {
        LocalTime endTime = LocalTime.of(0, 0, 0, 0);
        if (dataDownloadValueFromFields.downloadEndDateCheckBox()) endTime = dataDownloadValueFromFields.downloadEndTime();
        return endTime;
    }

    public LocalDateTime downloadEndDateTime() {
        LocalDate localDate = downloadEndDate();
        LocalTime localTime = downloadEndTime();
        return LocalDateTime.of(localDate, localTime);
    }

}
