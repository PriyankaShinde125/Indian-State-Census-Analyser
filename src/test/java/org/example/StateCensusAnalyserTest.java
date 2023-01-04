package org.example;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class StateCensusAnalyserTest {
    @Test
    public void whenLoadDataFromCsv_shouldMatchNumberOfRecordsWithCsvData() throws CustomException {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        List<CsvStateCensus> csvStateCensusData = stateCensusAnalyser.loadData();
        Assert.assertEquals(29,csvStateCensusData.size());
    }
}
