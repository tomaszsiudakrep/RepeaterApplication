package com.quiz.quizapplication;

import com.quiz.quizapplication.database.ConnectToDb;
import com.quiz.quizapplication.exercises.objects.Exercises;
import org.junit.jupiter.api.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class TestSuiteDataFromDb {

    private DataFromDb dataFromDb;
    private GroupExToDb groupExToDb;
    private Exercises exercises;
    private int counter = 0;

    @BeforeEach
     public void initializeObject() throws SQLException {
        dataFromDb = new DataFromDb();
        groupExToDb = new GroupExToDb();
        exercises = new Exercises("Test", "Test");
    }

    @BeforeEach
    @AfterEach
    public void cleanUp() throws SQLException {
        String sqlDel = "DELETE FROM EXERCISES";
        String sqlDel2 = "DELETE FROM GROUP_EXERCISES";
        ConnectToDb connectToDb = ConnectToDb.getInstance();
        Statement statement = connectToDb.getConn().createStatement();
        statement.executeUpdate(sqlDel);
        statement.executeUpdate(sqlDel2);
        statement.close();
    }

    @DisplayName("Save exercise")
    @Test
    void testSaveExToDb() throws SQLException {
        //Given
        ConnectToDb connectToDb = ConnectToDb.getInstance();
        Statement statement = connectToDb.getConn().createStatement();
        String sqlQuery = "SELECT * FROM EXERCISES";
        String groupName = "loop";
        groupExToDb.addGroup(groupName);
        int id = groupExToDb.checkId(groupName);
        //When
        dataFromDb.saveExercisesToDb(exercises, id);

        //Then
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("ID") + ", " +  resultSet.getString("TITLE") + ", " + resultSet.getString("DESCRIPTION") + ", " + id);
            counter++;
        }
        resultSet.close();
        Assertions.assertEquals(1, counter);
        //Clean up
    }

    @DisplayName("Archive exercise")
    @Test
    void testArchiveExercises() throws SQLException{
        //Given
        String groupName = "loop";
        groupExToDb.addGroup(groupName);
        int id = groupExToDb.checkId(groupName);
        dataFromDb.saveExercisesToDb(exercises, id);
        ConnectToDb connectToDb = ConnectToDb.getInstance();
        Statement statement = connectToDb.getConn().createStatement();
        String sql = "SELECT ID FROM EXERCISES";
        ResultSet resultSet = statement.executeQuery(sql);
        //When
            resultSet.next();
            int exp = resultSet.getInt("ID");
            String expectedId = String.valueOf(exp);
            dataFromDb.archiveExercises(expectedId);

        //Then
        String sql2 = "SELECT * FROM EXERCISES WHERE ARCHIVED = 1";
        ResultSet resultSet1 = statement.executeQuery(sql2);
        while (resultSet1.next()) {
            System.out.println(resultSet1.getInt("ID") + ", " +  resultSet1.getString("TITLE") + ", " + resultSet1.getString("DESCRIPTION") + ", " +  ", " + resultSet1.getByte("ARCHIVED") + ", " + id);
            counter++;
        }
        Assertions.assertEquals(1, counter);
        //Clean up
        resultSet.close();
        resultSet1.close();
        statement.close();

    }

    @DisplayName("Select min id")
    @Test
    void testFirstElementFromDb() throws SQLException {
        //Given
        int idEx = 0;
        String groupName = "loop";
        groupExToDb.addGroup(groupName);
        int id = groupExToDb.checkId(groupName);
        dataFromDb.saveExercisesToDb(exercises, id);
        String sql = "SELECT * FROM EXERCISES";
        ConnectToDb connectToDb = ConnectToDb.getInstance();
        Statement statement = connectToDb.getConn().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        //When
        int expected = dataFromDb.firstElementFromDb();
        while (resultSet.next()) {
            idEx = resultSet.getInt(1);
        }
        //Then
        Assertions.assertEquals(idEx, expected);
    }

    @DisplayName("Count all exercises")
    @Test
    void testCountAllExercises() throws SQLException {
        //Given
        String groupName = "loop";
        groupExToDb.addGroup(groupName);
        int id = groupExToDb.checkId(groupName);
        dataFromDb.saveExercisesToDb(exercises, id);
        dataFromDb.saveExercisesToDb(exercises, id);
        dataFromDb.saveExercisesToDb(exercises, id);
        //When
        int expected = dataFromDb.allExercises();
        //Then
        Assertions.assertEquals(3, expected);
    }

    @DisplayName("Exercises list with id")
    @Test
    void testListWithExercisesId() throws SQLException {
        //Given
        String groupName = "loop";
        groupExToDb.addGroup(groupName);
        int group = groupExToDb.checkId(groupName);
        dataFromDb.saveExercisesToDb(new Exercises("Test", "Test"), group);
        dataFromDb.saveExercisesToDb(new Exercises("Test", "Test"), group);
        dataFromDb.saveExercisesToDb(new Exercises("Test", "Test"), group);
        //When
        List<Integer> result = dataFromDb.loadListWithExercisesId();
        System.out.println(result);
        //Then
        Assertions.assertEquals(3, result.size());
        //Clean up
    }

    @DisplayName("Shuffle list")
    @Test
    void  testShuffleList() throws SQLException {
        //Given
        groupExToDb.addGroup("Test");
        int idGroup = groupExToDb.checkId("Test");
        dataFromDb.saveExercisesToDb(new Exercises("Test", "Test"), idGroup);
        dataFromDb.saveExercisesToDb(new Exercises("Test", "Test"), idGroup);
        dataFromDb.saveExercisesToDb(new Exercises("Test", "Test"), idGroup);
        //When
        List<Integer> resultList = dataFromDb.shuffleList();
        //Then
        Assertions.assertEquals(3, resultList.size());

    }

}
