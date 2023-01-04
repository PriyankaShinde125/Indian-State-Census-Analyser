package org.example;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class StateCensusAnalyserTest {
    public static final String CORRECT_FILE_NAME = "IndiaStateCensusData.csv";
    public static final String WRONG_FILE_NAME = "abc.csv";

    @Test
    public void whenLoadDataFromCsv_shouldMatchNumberOfRecordsWithCsvData() throws CustomException {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        List<CsvStateCensus> csvStateCensusData = stateCensusAnalyser.loadData(CORRECT_FILE_NAME);
        Assert.assertEquals(29, csvStateCensusData.size());
    }

    @Test
    public void givenFileName_whenWrong_shouldReturnCustomException() {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            stateCensusAnalyser.loadData(WRONG_FILE_NAME);
        } catch (CustomException e) {
            Assert.assertEquals("File not found", e.getMessage());
        }
    }
}
