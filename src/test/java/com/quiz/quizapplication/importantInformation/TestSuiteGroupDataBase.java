package com.quiz.quizapplication.importantInformation;

import com.quiz.quizapplication.database.ConnectToDb;
import com.quiz.quizapplication.importantInformation.data.GroupDataBase;
import org.junit.jupiter.api.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSuiteGroupDataBase {

    private GroupDataBase groupDataBase;
    private Statement statement;

    private final String sqlCountOfGroup = "SELECT * FROM GROUP_IMPORTANTINFORMATION";
    private int counter = 0;

    @BeforeEach
    public void initialize() throws SQLException {
        groupDataBase = new GroupDataBase();
        statement = ConnectToDb.getInstance().getConn().createStatement();
    }

    @AfterEach
    @BeforeEach
    public void cleanAll() throws SQLException {
        String delSql = "DELETE FROM IMPORTANT_INFORMATION;\n" +
                "DELETE FROM GROUP_IMPORTANTINFORMATION;";
        ConnectToDb connectToDb = ConnectToDb.getInstance();
        Statement statement = connectToDb.getConn().createStatement();
        statement.executeUpdate(delSql);
    }

    @DisplayName("Test Add New Group")
    @Test
    void testAddGroup() throws SQLException {
        //Given
            GroupInformation groupInformation = new GroupInformation("Code");
        //When
            groupDataBase.addGroup(groupInformation);
        //Then
            ResultSet resultSet = statement.executeQuery(sqlCountOfGroup);
            while (resultSet.next()) {
                counter++;
            }
            Assertions.assertEquals(1, counter);
        //Clean Up
            statement.close();
    }

    @DisplayName("Test Check Group Id")
    @Test
    void testCheckGroupId() throws SQLException {
        //Given
            String name = "Code";
            String sqlQuery = "SELECT * FROM GROUP_IMPORTANTINFORMATION";
            GroupInformation groupInformation = new GroupInformation(name);
            groupDataBase.addGroup(groupInformation);
        //When
            int result = groupDataBase.checkGroupId(name);
        //Then
            Statement statement = ConnectToDb.getInstance().getConn().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            resultSet.next();
            int expected = resultSet.getInt(1);
            Assertions.assertEquals(result, expected);
        //Clean Up
            resultSet.close();
            statement.close();
    }

    @DisplayName("Test Check Duplicate Group")
    @Test
    void testDuplicateGroup() {
        //Given
            String name = "Code";
            String name2 = "xxx";
            String name3 = "code";
            GroupInformation groupInformation = new GroupInformation(name);
            groupDataBase.addGroup(groupInformation);
        //When
            boolean resultTrue = groupDataBase.checkIfGroupExist(name);
            boolean resultFalse = groupDataBase.checkIfGroupExist(name2);
            boolean resultTrue2 = groupDataBase.checkIfGroupExist(name3);
        //Then
            Assertions.assertTrue(resultTrue);
            Assertions.assertFalse(resultFalse);
            Assertions.assertTrue(resultTrue2);
        //Clean up
    }
}
