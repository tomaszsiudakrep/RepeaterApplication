package com.quiz.quizapplication.importantInformation;

import com.quiz.quizapplication.database.ConnectToDb;
import com.quiz.quizapplication.importantInformation.data.add.DataAddImportantInformation;
import com.quiz.quizapplication.importantInformation.data.add.DataAddInformationGroup;
import com.quiz.quizapplication.importantInformation.data.importantInformation.DataImportantInformation;
import com.quiz.quizapplication.importantInformation.objects.GroupInformation;
import com.quiz.quizapplication.importantInformation.objects.ImportantInformation;
import org.junit.jupiter.api.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestSuiteDataImportantInformation {

    DataAddInformationGroup dataAddInformationGroup;
    DataAddImportantInformation dataAddImportantInformation;
    static int groupId;
    static int counter;
    static int informationId;

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

    public void addInformation() {
        ImportantInformation importantInformation = new ImportantInformation("Test", "Test");
            dataAddImportantInformation.addImportantInformation(groupId, importantInformation);
//            informationId =
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
    void test_deleteInformation() {
        //Given
//        addGroup(); addInformation();
        //When

        //Then

    }

    @Test
    void test_returnTitleInformationFromListViewItem() {
        //Given

        //When

        //Then

    }

}
