package com.quiz.quizapplication.exercises;

import com.quiz.quizapplication.database.ConnectToDb;
import com.quiz.quizapplication.exercises.data.add.DataAddExercisesGroup;
import com.quiz.quizapplication.exercises.objects.GroupExercises;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.sql.SQLException;
import java.sql.Statement;

public class TestSuiteDataAddExercises {

//    DataAddExercisesGroup dataAddExercisesGroup;
//    GroupExercises groupExercises = new GroupExercises("Math");
//
//    String sqlQueryAddGroup = "INSERT INTO GROUP_EXERCISES(NAME, ARCHIVED) " +
//            "VALUES ('" + groupExercises.getGroupName() + "','" + groupExercises.isArchived() + "')";
//
//    @BeforeEach
//    @AfterEach
//    public void cleanUp() throws SQLException {
//        String sqlDel = "DELETE FROM EXERCISES;\nDELETE FROM GROUP_EXERCISES;";
//        Statement statement = ConnectToDb.getInstance().getConn().createStatement();
//        statement.executeUpdate(sqlDel);
//        statement.close();
//    }
//
//    @BeforeEach
//    public void initialize() throws SQLException {
//        dataAddExercisesGroup = new DataAddExercisesGroup();
//    }

//    @Test
//    void test_addExercisesGroup() {
//        //Given
//        dataAddExercisesGroup.addGroup(sqlQueryAddGroup);
//        //When
//        String result = AddExercisesScene.groupChoiceBox.getValue();
//        //Then
//        Assertions.assertNull(result);
//    }
}
