package com.quiz.quizapplication.importantInformation;

import com.quiz.quizapplication.database.ConnectToDb;
import com.quiz.quizapplication.importantInformation.data.ImportantInformationDataBase;
import com.quiz.quizapplication.importantInformation.data.StatementDataBase;
import org.junit.jupiter.api.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSuiteImportantInformationDataBase {

    private ImportantInformationDataBase importantInformationDataBase;
    private Statement statement;

    private String sqlCountOfImportantInfo = "SELECT * FROM IMPORTANT_INFORMATION";
    private int counter = 0;

    @BeforeEach
    public void initialize() throws SQLException {
        importantInformationDataBase = new ImportantInformationDataBase();
        statement = ConnectToDb.getInstance().getConn().createStatement();
    }

    @AfterEach
    @BeforeEach
    public void cleanAll() throws SQLException {
        String delSql = "DELETE FROM IMPORTANT_INFORMATION\n" +
                "DELETE FROM GROUP_IMPORTANTINFORMATION";
        ConnectToDb connectToDb = ConnectToDb.getInstance();
        Statement statement = connectToDb.getConn().createStatement();
        statement.executeUpdate(delSql);
    }

    @DisplayName("Test Add Important Information")
    @Test
    void testAddImInfo() throws SQLException {
        //Given
            ImportantInformation imInfo1 = new ImportantInformation("Connect to database MSSQL", "Test");
        //When
            importantInformationDataBase.addInformation(imInfo1, null);
        //Then
            ResultSet resultSet = statement.executeQuery(sqlCountOfImportantInfo);
            while (resultSet.next()) {
                counter++;
            }
            Assertions.assertEquals(1, counter);
        //CleanUp
            statement.close();
    }
}
