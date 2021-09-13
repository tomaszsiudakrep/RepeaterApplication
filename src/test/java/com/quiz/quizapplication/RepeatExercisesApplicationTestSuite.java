package com.quiz.quizapplication;

import com.quiz.quizapplication.database.ConnectToDb;
import org.junit.jupiter.api.*;
import java.sql.SQLException;
import java.sql.Statement;

class RepeatExercisesApplicationTestSuite {

    @BeforeEach
    @AfterEach
    public void cleanUp() throws SQLException {
        String sqlDel = "DELETE FROM EXERCISES;\nDELETE FROM GROUP_EXERCISES;";
        Statement statement = ConnectToDb.getInstance().getConn().createStatement();
        statement.executeUpdate(sqlDel);
        statement.close();
    }

    @DisplayName("Connect to db")
    @Test
    void connectToDbTest() throws SQLException {
        //Given

        //When
            ConnectToDb connectToDb = ConnectToDb.getInstance();
        //Then
            Assertions.assertNotNull(connectToDb.getConn());
    }

}
