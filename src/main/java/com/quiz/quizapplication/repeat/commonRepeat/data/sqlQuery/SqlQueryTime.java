package com.quiz.quizapplication.repeat.commonRepeat.data.sqlQuery;

public class SqlQueryTime {

    public String sqlQuerySaveTime(int elapsedTime, int id) {
        return "UPDATE EXERCISES SET TIME_DONE = " + elapsedTime + " WHERE ID = " + id;
    }
}
