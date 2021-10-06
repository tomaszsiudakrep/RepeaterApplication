package com.quiz.quizapplication.repeat.commonRepeat.data.sqlQuery;

public class SqlQueryCommonRepeat {

    public String sqlQuerySelectAllFromExercises() {
        return "SELECT * FROM EXERCISES";
    }

    public String sqlQuerySelectAllFromExercisesWhereGroupIs(int groupId) {
        return "SELECT * FROM EXERCISES WHERE GROUP_ID = " + groupId;
    }

    public String sqlQueryNextExercises(int exercisesId) {
        return "SELECT * FROM EXERCISES WHERE ID = " + exercisesId;
    }
}
