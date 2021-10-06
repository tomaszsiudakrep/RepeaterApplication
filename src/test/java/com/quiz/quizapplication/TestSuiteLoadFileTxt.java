package com.quiz.quizapplication;

import com.quiz.quizapplication.data.file.LoadFileTxt;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class TestSuiteLoadFileTxt {

    private LoadFileTxt loadFileTxt;

    @Test
    void testLoadTxtFile() throws IOException {
        //Given
        loadFileTxt = new LoadFileTxt();
        String id = "1";
        //When
        loadFileTxt.loadExampleSolution(id);
        //Then

    }

}
