package com.quiz.quizapplication.importantInformation;

import com.quiz.quizapplication.database.ConnectToDb;
import com.quiz.quizapplication.importantInformation.data.add.DataAddImportantInformation;
import com.quiz.quizapplication.importantInformation.data.add.DataAddInformationGroup;
import com.quiz.quizapplication.importantInformation.objects.GroupInformation;
import com.quiz.quizapplication.importantInformation.objects.ImportantInformation;
import org.junit.jupiter.api.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSuiteDataAddImportantInformation {

    DataAddInformationGroup dataAddInformationGroup;
    DataAddImportantInformation dataAddImportantInformation;
    static int groupId;
    static int counter;

    @BeforeEach
    public void initialize() {
        dataAddInformationGroup = new DataAddInformationGroup();
        dataAddImportantInformation = new DataAddImportantInformation();
    }

    @BeforeAll
    @AfterAll
    static void clean() throws SQLException {
        String sqlQuery = "DELETE FROM IMPORTANT_INFORMATION; DELETE FROM GROUP_IMPORTANT_INFORMATION";
        Statement statement = ConnectToDb.getInstance().getConn().createStatement();
            statement.executeUpdate(sqlQuery);
            statement.close();
    }


    public void addGroup() {
        GroupInformation groupInformation = new GroupInformation("Math");
        dataAddInformationGroup.addGroup(groupInformation);
        groupId = dataAddInformationGroup.checkGroupId("Math");
    }

    public void size() throws SQLException {
        String sqlQuery = "SELECT * FROM IMPORTANT_INFORMATION";
        Statement statement = ConnectToDb.getInstance().getConn().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                counter++;
            }
            resultSet.close();
            statement.close();
    }

    @Test
    void test_addImportantInformation() throws SQLException {
        //Given
        addGroup();
        ImportantInformation importantInformation = new ImportantInformation("test", "test");
        //When
        boolean resultTrue = dataAddImportantInformation.addImportantInformation(groupId ,importantInformation);
        boolean resultFalse = dataAddImportantInformation.addImportantInformation(0 ,importantInformation);
        //Then
        size();
        Assertions.assertTrue(resultTrue);
        Assertions.assertFalse(resultFalse);
        Assertions.assertEquals(1, counter);
    }

    @Test
    void test_checkIfObjectAlreadyExistInGroup() {
        //Given
        addGroup();
        ImportantInformation importantInformation = new ImportantInformation("test", "test");
        ImportantInformation importantInformation2 = new ImportantInformation("test2", "test2");
        dataAddImportantInformation.addImportantInformation(groupId, importantInformation);
        //When
        boolean resultTrue = dataAddImportantInformation.checkIfObjectAlreadyExistInGroup(importantInformation.getTitle(), groupId);
        boolean resultFalse = dataAddImportantInformation.checkIfObjectAlreadyExistInGroup(importantInformation2.getTitle(), groupId);
        //Then
        Assertions.assertTrue(resultTrue);
        Assertions.assertFalse(resultFalse);
    }

    @Test
    void test_createImportantInformationObject() {
        //Given
        String title = "test";
        String description = "test";
        ImportantInformation importantInformation = new ImportantInformation(title, description);
        //When
        ImportantInformation importantInformation1 =  dataAddImportantInformation.createImportantInformationObject(title, description);
        //Then
        Assertions.assertEquals(importantInformation, importantInformation1);
    }

}
