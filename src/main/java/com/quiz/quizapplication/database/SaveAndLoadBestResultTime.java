package com.quiz.quizapplication.database;

import com.quiz.quizapplication.scene.repeatScene.RepeatScene;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SaveAndLoadBestResultTime {

    RepeatScene repeatScene = new RepeatScene();

    public void saveTimeResult(int elapsedTime, String id) throws SQLException {
        if (elapsedTime != 0 & !id.equals("")) {
            ConnectToDb connectToDb = ConnectToDb.getInstance();
            Statement statement = connectToDb.getConn().createStatement();
            String sqlSave = "UPDATE EXERCISES SET TIME_DONE = " + elapsedTime + " where id = " + id;
            statement.executeUpdate(sqlSave);
            statement.close();
        } else {
            System.out.println("Elapsed time = 0 or id = null");
        }
    }

    public int loadTimeResult(String id) throws SQLException {
        int elapsedTime = 0;
        if (!id.equals("")) {
            String sqlLoad = "SELECT * FROM EXERCISES WHERE id = " + id;
            ConnectToDb connectToDb = ConnectToDb.getInstance();
            Statement statement = connectToDb.getConn().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlLoad);
            resultSet.next();
            elapsedTime = resultSet.getInt("TIME_DONE");
            return elapsedTime;
        } else {
            return elapsedTime;
        }
    }

    public String convertElapsedTimeToString(int elapsedTimeLoading) {
        int hours = (elapsedTimeLoading / 3600000);
        int minutes = (elapsedTimeLoading / 60000) % 60;
        int seconds = (elapsedTimeLoading / 1000) % 60;
        String hours_string = String.format("%02d", hours);
        String minutes_string = String.format("%02d", minutes);
        String seconds_string = String.format("%02d", seconds);
        String resultTime = hours_string + ":" + minutes_string + ":" + seconds_string;
        return resultTime;
    }
}
