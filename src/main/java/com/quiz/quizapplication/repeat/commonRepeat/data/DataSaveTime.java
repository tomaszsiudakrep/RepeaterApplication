package com.quiz.quizapplication.repeat.commonRepeat.data;

import com.quiz.quizapplication.database.ConnectToDb;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSaveTime {

    public void saveTimeResult(String sqlQuery) throws SQLException {
        try {
            Statement statement = ConnectToDb.getInstance().getConn().createStatement();
                statement.executeUpdate(sqlQuery);
                statement.close();
        } catch (SQLException e) {
            System.out.println("Wrong: " + e);
        }
    }

    public boolean checkIfElapsedTimeIsNotNull(int elapsedTime) {
        boolean result = false;
        if (elapsedTime > 0) result = true;
        return result;
    }

    public String convertElapsedTimeToString(int elapsedTimeLoading) {
        int hours = (elapsedTimeLoading / 3600000);
        int minutes = (elapsedTimeLoading / 60000) % 60;
        int seconds = (elapsedTimeLoading / 1000) % 60;
        String hours_string = String.format("%02d", hours);
        String minutes_string = String.format("%02d", minutes);
        String seconds_string = String.format("%02d", seconds);
        return hours_string + ":" + minutes_string + ":" + seconds_string;
    }

}
