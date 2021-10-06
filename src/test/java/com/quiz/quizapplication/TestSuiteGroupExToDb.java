package com.quiz.quizapplication;

import com.quiz.quizapplication.database.ConnectToDb;
import com.quiz.quizapplication.exercises.controller.add.AddExercisesGroupController;
import com.quiz.quizapplication.exercises.objects.Exercises;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSuiteGroupExToDb {

    private GroupExToDb groupExToDb;
    private DataFromDb dataFromDb;
    private Exercises exercises;
    AddExercisesGroupController addExercisesGroupController = new AddExercisesGroupController();
    private static int counter = 0;

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

    @DisplayName("Add new group")
    @Test
    void testAddGroupToDb() throws SQLException {
        //Given
        groupExToDb = new GroupExToDb();
        String name = "STREAM";
        String sql = "SELECT * FROM GROUP_EXERCISES";
        ConnectToDb connectToDb = ConnectToDb.getInstance();
        Statement statement = connectToDb.getConn().createStatement();

        //When
        boolean result = groupExToDb.addGroup(name);

        //Then
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("ID") + ", " + resultSet.getString("NAME"));
            counter++;
        }
        Assertions.assertEquals(1, counter);
        Assertions.assertTrue(result);

        //Clean up
        String sqlDel = "DELETE FROM GROUP_EXERCISES";
        statement.executeUpdate(sqlDel);
        resultSet.close();
        statement.close();
    }

    @DisplayName("Check if group exist")
    @Test
    void testCheckDuplicateNameOfGroup() throws SQLException {
        //Given
        groupExToDb = new GroupExToDb();
        ConnectToDb connectToDb = ConnectToDb.getInstance();
        Statement statement = connectToDb.getConn().createStatement();
        String name1 = "STREAM";
        String name2 = "LOOP";
        groupExToDb.addGroup(name1);

        //When
        boolean result = groupExToDb.checkNameGroup(name1);
        boolean result2 = groupExToDb.checkNameGroup(name2);

        //Then
        Assertions.assertTrue(result);
        Assertions.assertFalse(result2);
        //Clean up
        String sql = "DELETE FROM GROUP_EXERCISES";
        statement.executeUpdate(sql);
        statement.close();
    }

    @DisplayName("Create observableList to ChoiceBox")
    @Test
    void testShowNameOfGroup() throws SQLException {
        //Given
            String sql = "SELECT * FROM GROUP_EXERCISES WHERE ARCHIVED = 0";
            Statement statement = ConnectToDb.getInstance().getConn().createStatement();
            groupExToDb.addGroup("LOOP");
            groupExToDb.addGroup("STREAM");
            groupExToDb.addGroup("AVG");
            ResultSet resultSet = statement.executeQuery(sql);
        //When
            ObservableList<String> list =  addExercisesGroupController.createObservableListToChoiceBox();
        //Then
            Assertions.assertEquals(3, list.size());
        //Clean up
            resultSet.close();
            statement.close();
    }

    @DisplayName("Check group id by name")
    @Test
    void testCheckGroupId() throws SQLException {
        //Given
        groupExToDb = new GroupExToDb();
        ConnectToDb connectToDb = ConnectToDb.getInstance();
        Statement statement = connectToDb.getConn().createStatement();
        String sql = "SELECT * FROM GROUP_EXERCISES";
        String name = "petla";
        groupExToDb.addGroup(name);

        //When
        int result = groupExToDb.checkId(name);

        //Then
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        int id = resultSet.getInt(1);
        Assertions.assertEquals(id, result);

        //Clean up
        resultSet.close();
        String sqlDel = "DELETE FROM GROUP_EXERCISES";
        statement.executeUpdate(sqlDel);
        statement.close();

    }

    @DisplayName("Check group name by id")
    @Test
    void testCheckGroupName() throws SQLException {
        //Given
        String name = "LOOP";
        String name2 = "STREAM";
        groupExToDb.addGroup(name);
        groupExToDb.addGroup(name2);
        int id = groupExToDb.checkId(name);
        int id2 = groupExToDb.checkId(name2);

        //When
        String group = groupExToDb.checkGroupName(id);
        String group2 = groupExToDb.checkGroupName(id2);
        //Then
        Assertions.assertEquals("LOOP", group);
        Assertions.assertEquals("STREAM", group2);
        //Clean up
    }

}
