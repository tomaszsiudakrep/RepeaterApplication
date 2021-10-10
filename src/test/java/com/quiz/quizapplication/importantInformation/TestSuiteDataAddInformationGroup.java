package com.quiz.quizapplication.importantInformation;

import com.quiz.quizapplication.database.ConnectToDb;
import com.quiz.quizapplication.importantInformation.data.add.DataAddInformationGroup;
import com.quiz.quizapplication.importantInformation.objects.GroupInformation;
import org.junit.jupiter.api.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestSuiteDataAddInformationGroup {

    DataAddInformationGroup dataAddInformationGroup;
    int counter = 0;

    @BeforeEach
    public void initialize() {
        dataAddInformationGroup = new DataAddInformationGroup();
    }

    public int countOfGroup() throws SQLException {
        String sqlQuery = "SELECT * FROM GROUP_IMPORTANT_INFORMATION";
        Statement statement = ConnectToDb.getInstance().getConn().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                counter++;
            }
            resultSet.close();
            statement.close();
        return counter;
    }

    @BeforeEach
    void clean() throws SQLException {
        String sqlQuery = "DELETE FROM IMPORTANT_INFORMATION; DELETE FROM GROUP_IMPORTANT_INFORMATION; DELETE FROM EXERCISES; DELETE FROM GROUP_EXERCISES";
        Statement statement = ConnectToDb.getInstance().getConn().createStatement();
            statement.executeUpdate(sqlQuery);
            statement.close();
    }

    @Test
    void test_checkIfGroupNameIsNotNull() {
        //Given
        String groupName = "Math";
        String groupName2 = "";
        //When
        boolean result = dataAddInformationGroup.checkIfGroupNameIsNotNull(groupName);
        boolean result2 = dataAddInformationGroup.checkIfGroupNameIsNotNull(groupName2);
        //Then
        Assertions.assertTrue(result);
        Assertions.assertFalse(result2);
    }

    @Test
    void test_checkIfGroupNameNotExist() throws SQLException {
        //Given
        GroupInformation groupInformation = new GroupInformation("Code");
        dataAddInformationGroup.addGroup(groupInformation);
        String groupNameNotExist = "Math";
        String groupNameExist = "Code";
        //When
        boolean result = dataAddInformationGroup.checkIfGroupNameNotExist(groupNameNotExist);
        boolean result2 = dataAddInformationGroup.checkIfGroupNameNotExist(groupNameExist);
        int size = countOfGroup();
        //Then
        Assertions.assertTrue(result);
        Assertions.assertFalse(result2);
        Assertions.assertEquals(1, size);
    }

    @Test
    void test_addGroup() throws SQLException {
        //Given
        GroupInformation groupInformation = new GroupInformation("Code");
        GroupInformation groupInformation2 = new GroupInformation("");
        //When
        boolean result = dataAddInformationGroup.addGroup(groupInformation);
        boolean result2 = dataAddInformationGroup.addGroup(groupInformation2);
        int size = countOfGroup();
        //Then
        Assertions.assertTrue(result);
        Assertions.assertTrue(result2);
        Assertions.assertEquals(2, size);
    }

    @Test
    void test_changeGroupName() throws SQLException {
        //Given
        GroupInformation groupInformation = new GroupInformation("Code");
        dataAddInformationGroup.addGroup(groupInformation);
        String newGroupName = "Math";
        //When
        boolean result = dataAddInformationGroup.changeGroupName(newGroupName, "Code");
        //Then
        Assertions.assertTrue(result);
    }

    @Test
    void test_createGroupList() throws SQLException {
        //Given
        List<String> expectedList = new ArrayList<>();
        expectedList.add("Math");
        expectedList.add("Code");
        GroupInformation groupInformation = new GroupInformation("Math");
        GroupInformation groupInformation2 = new GroupInformation("Code");
        dataAddInformationGroup.addGroup(groupInformation);
        dataAddInformationGroup.addGroup(groupInformation2);
        int size = countOfGroup();
        //When
        List<String> resultList = dataAddInformationGroup.createGroupList();
        //Then
        Assertions.assertEquals(expectedList, resultList);
        Assertions.assertEquals(2, size);
    }

    @Test
    void test_deleteGroup() throws SQLException {
        //Given
        GroupInformation groupInformation = new GroupInformation("Math");
        GroupInformation groupInformation2 = new GroupInformation("Code");
        dataAddInformationGroup.addGroup(groupInformation);
        dataAddInformationGroup.addGroup(groupInformation2);
        //When
        boolean result = dataAddInformationGroup.deleteGroup("Math");
        int size = countOfGroup();
        //Then
        Assertions.assertTrue(result);
        Assertions.assertEquals(1, size);

    }

    @Test
    void test_checkGroupId() throws SQLException {
        //Given
        GroupInformation groupInformation = new GroupInformation("Code");
        dataAddInformationGroup.addGroup(groupInformation);
        //When
        int id = dataAddInformationGroup.checkGroupId("Code");
        int size = countOfGroup();
        //Then
        Assertions.assertEquals(1, size);
        Assertions.assertNotEquals(0, id);
    }

    @Test
    void test_createGroupObject() {
        //Given
        GroupInformation groupInformation = new GroupInformation("Code");
        //When
        GroupInformation groupInformation1 = dataAddInformationGroup.createGroupObject("Code");
        //Then
        Assertions.assertEquals(groupInformation1, groupInformation);
    }
}
