package com.quiz.quizapplication.repeat.testKnowledge.data.sqlQuery;

public class SqlQuerySelectAllFromExercises {

    public String sqlQuerySelectExercises(int idExercises) {
        return "SELECT * FROM EXERCISES WHERE ID = " + idExercises + " and archived = 0";
    }

    public String sqlQueryCheckIfGroupIsNotEmpty(int groupId) {
        return "SELECT * FROM EXERCISES WHERE GROUP_ID = " + groupId;
    }

    public String sqlQueryReturnGroupIdByNameOfGroup(String groupName) {
        return "SELECT ID FROM GROUP_EXERCISES WHERE NAME = '" + groupName + "'";
    }
}
