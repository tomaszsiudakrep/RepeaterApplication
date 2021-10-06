package com.quiz.quizapplication.importantInformation;

import com.quiz.quizapplication.importantInformation.data.importantInformation.ImportantInformationDataBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class TestSuiteImportantInformationDataBase {

    private ImportantInformationDataBase importantInformationDataBase;

    private String sqlCountOfImportantInfo = "SELECT * FROM IMPORTANT_INFORMATION";
    private int counter = 0;

    @BeforeEach
    public void initialize() throws SQLException {
        importantInformationDataBase = new ImportantInformationDataBase();
    }

//    @AfterEach
//    @BeforeEach
//    public void cleanAll() throws SQLException {
//        String delSql = "DELETE FROM IMPORTANT_INFORMATION";
//        Statement statement = ConnectToDb.getInstance().getConn().createStatement();
//        statement.executeUpdate(delSql);
//        statement.close();
//    }

    @Test
    void test_returnIdInformationFromListViewItem() {
        //Given
        String listViewItem = "26/Test4";
        //When
        int result = importantInformationDataBase.returnIdInformationFromListViewItem(listViewItem);
        //Then
        Assertions.assertEquals(26, result);
    }

    @Test
    void test_returnTitleInformationFromListViewItem() {
        //Given
        String listViewItem = "26/Test4";
        //When
        String result = importantInformationDataBase.returnTitleInformationFromListViewItem(listViewItem);
        //Then
        Assertions.assertEquals("Test4", result);
    }


}
