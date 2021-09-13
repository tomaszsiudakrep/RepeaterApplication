package com.quiz.quizapplication;

import com.quiz.quizapplication.database.ConnectToDb;
import com.quiz.quizapplication.database.SettingsDb;
import org.junit.jupiter.api.*;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSuiteSettingsDb {

    public SettingsDb settingsDb;

    @BeforeEach
    public void initialize() {
        settingsDb = new SettingsDb();
    }

    @BeforeEach
    @AfterEach
    public void cleanUp() throws SQLException {
        String sqlDel = "DELETE FROM SETTINGS";
        Statement statement = ConnectToDb.getInstance().getConn().createStatement();
        statement.executeUpdate(sqlDel);
        statement.close();
    }

    @DisplayName("Convert boolean to bit")
    @Test
    void testConvertToBit() {
        //Given
        boolean resultTrue = true;
        boolean resultFalse = false;
        //When
        int expTrue = settingsDb.convertToBit(resultTrue);
        int expFalse = settingsDb.convertToBit(resultFalse);
        //Then
        Assertions.assertEquals(1, expTrue);
        Assertions.assertEquals(0, expFalse);
    }
}
