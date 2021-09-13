package com.quiz.quizapplication;

import org.junit.jupiter.api.Test;
import java.io.IOException;

public class TestSuiteLoadSolution {

    private LoadSolution loadSolution;

    @Test
    void testLoadTxtFile() throws IOException {
        //Given
        loadSolution = new LoadSolution();
        String id = "1";
        //When
        loadSolution.loadExampleSolution(id);
        //Then

    }

}
