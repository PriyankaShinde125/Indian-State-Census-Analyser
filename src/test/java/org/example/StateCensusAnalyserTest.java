package org.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class StateCensusAnalyserTest {
    public static final String CORRECT_FILE_NAME = "IndiaStateCensusData.csv";
    public static final String WRONG_FILE_NAME = "abc.csv";
    public static final String FILE_NAME_WITH_WRONG_TYPE = "abc.txt";
    public static final String FILE_NAME_WITH_WRONG_FIELD_SEPARATOR = "abc.csv";
    public static final String FILE_NAME_WITH_WRONG_FIELD_HEADERS = "abcWrongHeader.csv";

    @Test
    public void whenLoadDataFromCsv_shouldMatchNumberOfRecordsWithCsvData() throws CustomException {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        List<CsvStateCensus> csvStateCensusData = stateCensusAnalyser.loadData(CORRECT_FILE_NAME);
        Assert.assertEquals(29, csvStateCensusData.size());
    }

    @Test
    public void givenFileName_whenWrong_shouldReturnCustomException() {
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            stateCensusAnalyser.loadData(WRONG_FILE_NAME);
        } catch (CustomException e) {
            Assert.assertEquals("File not found", e.getMessage());
        }
    }

    @Test
    public void givenFileName_whenFileTypeWrong_shouldReturnCustomException() {
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            stateCensusAnalyser.loadData(FILE_NAME_WITH_WRONG_TYPE);
        } catch (CustomException e) {
            Assert.assertEquals("Invalid type of file", e.getMessage());
        }
    }

    @Test
    public void givenFileName_whenFieldSeparatorIncorrect_shouldReturnCustomException() {
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            stateCensusAnalyser.loadData(FILE_NAME_WITH_WRONG_FIELD_SEPARATOR);
        } catch (CustomException e) {
            Assert.assertEquals("Internal csv exception", e.getMessage());
        }
    }
    @Test
    public void givenFileName_whenFieldHeaders_shouldReturnCustomException() {
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            stateCensusAnalyser.loadData(FILE_NAME_WITH_WRONG_FIELD_HEADERS);
        } catch (CustomException e) {
            Assert.assertEquals("Internal csv exception", e.getMessage());
        }
    }
}
