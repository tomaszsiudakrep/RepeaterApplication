package com.quiz.quizapplication;

import com.quiz.quizapplication.database.ConnectToDb;
import org.junit.jupiter.api.*;
import java.sql.SQLException;
import java.sql.Statement;

class ConnectToDbTestSuite {

    @BeforeEach
    @AfterEach
    public void cleanUp() throws SQLException {
        String sqlDel = "DELETE FROM EXERCISES;\nDELETE FROM GROUP_EXERCISES;\nDELETE FROM IMPORTANT_INFORMATION;\nDELETE FROM GROUP_IMPORTANT_INFORMATION";
        Statement statement = ConnectToDb.getInstance().getConn().createStatement();
        statement.executeUpdate(sqlDel);
        statement.close();
    }

    @DisplayName("Connect to db")
    @Test
    void test_connectToDb() {
        //Given
        //When
            ConnectToDb connectToDb = ConnectToDb.getInstance();
        //Then
            Assertions.assertNotNull(connectToDb.getConn());
    }

}
