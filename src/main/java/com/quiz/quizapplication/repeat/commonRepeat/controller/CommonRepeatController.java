package com.quiz.quizapplication.repeat.commonRepeat.controller;

import com.quiz.quizapplication.data.alerts.AlertExercises;
import com.quiz.quizapplication.data.timers.TimerCommon;
import com.quiz.quizapplication.exercises.data.add.DataAddExercisesGroup;
import com.quiz.quizapplication.repeat.ChooseRepeatScene;
import com.quiz.quizapplication.repeat.commonRepeat.data.DataCommonRepeat;
import com.quiz.quizapplication.repeat.commonRepeat.data.DataSaveTime;
import com.quiz.quizapplication.repeat.commonRepeat.data.sqlQuery.SqlQueryCommonRepeat;
import com.quiz.quizapplication.repeat.commonRepeat.data.sqlQuery.SqlQueryTime;
import com.quiz.quizapplication.repeat.commonRepeat.scene.RepeatScene;
import java.sql.SQLException;
import java.util.List;

public class CommonRepeatController {

    DataCommonRepeat dataCommonRepeat = new DataCommonRepeat();
    SqlQueryCommonRepeat sqlQueryCommonRepeat = new SqlQueryCommonRepeat();
    DataAddExercisesGroup dataAddExercisesGroup = new DataAddExercisesGroup();
    DataSaveTime dataSaveTime = new DataSaveTime();
    SqlQueryTime sqlQueryTime = new SqlQueryTime();

    public void createListOfExercises() throws SQLException {
        String groupName = dataCommonRepeat.downloadChosenGroupFromChoiceBox();
        String sqlQuery = sqlQueryCommonRepeat.sqlQuerySelectAllFromExercises();
        if (groupName != null) {
            int groupId = dataAddExercisesGroup.checkGroupId(groupName);
            sqlQuery = sqlQueryCommonRepeat.sqlQuerySelectAllFromExercisesWhereGroupIs(groupId);
        }
        List<Integer> list = dataCommonRepeat.createListWithExercisesId(sqlQuery);
        dataCommonRepeat.createFinallyList(list);
    }

    public void shuffleListToCommonRepeat() {
        List<Integer> list = ChooseRepeatScene.listToCommonRepeat;
        dataCommonRepeat.shuffleList(list);
        RepeatScene.shuffleExercisesButton.setDisable(true);
    }

    public void nextExercises() throws SQLException {
        TimerCommon.reset();
        RepeatScene.shuffleExercisesButton.setDisable(true);
        if (RepeatScene.startTimerImmediatelyRadioButton.isSelected()) TimerCommon.start();
        if (ChooseRepeatScene.listToCommonRepeat.size() > RepeatScene.getElementFromList) {
            RepeatScene.id = ChooseRepeatScene.listToCommonRepeat.get(RepeatScene.getElementFromList);
            String sqlQuery = sqlQueryCommonRepeat.sqlQueryNextExercises(RepeatScene.id);
            dataCommonRepeat.showMeExercisesById(sqlQuery);
                RepeatScene.getElementFromList++;
        } else {
            RepeatScene.nextExercisesButton.setDisable(true);
            TimerCommon.reset();
            dataCommonRepeat.initializeFieldsToEmpty();
            AlertExercises.dialogInformation.show();
        }
    }

    public void initializeCounter() {
        RepeatScene.getElementFromList = 0;
    }

    public void saveTime() throws SQLException {
        String idIsShowing = dataCommonRepeat.checkIfIdIsShowing();
        if (!idIsShowing.equals("")) {
            int elapsedTime = TimerCommon.elapsedTime;
            int id = RepeatScene.id;
            String sqlQuery = sqlQueryTime.sqlQuerySaveTime(elapsedTime, id);
            dataSaveTime.saveTimeResult(sqlQuery);
            String bestResult = dataSaveTime.convertElapsedTimeToString(elapsedTime);
            RepeatScene.bestResultLabel.setText("BEST RESULT " + bestResult);
        }
    }
}
