package com.quiz.quizapplication.importantInformation.data;

import com.quiz.quizapplication.database.ConnectToDb;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementDataBase {

    public Statement createStatement() throws SQLException {
        ConnectToDb connectToDb = ConnectToDb.getInstance();
        Statement statement = connectToDb.getConn().createStatement();
        return statement;
    }
}
