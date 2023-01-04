package org.example;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvFieldAssignmentException;
import com.opencsv.exceptions.CsvMalformedLineException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class StateCensusAnalyser {
    public static void main(String[] args) throws CustomException {
        List<CsvStateCensus> data = new StateCensusAnalyser().loadData("IndiaStateCensusData.csv");
        data.forEach(System.out::println);
    }

    public List<CsvStateCensus> loadData(String fileName) throws CustomException {
        if (!fileName.endsWith(".csv"))
            throw new CustomException(ExceptionType.INVALID_FILE_TYPE);
        List<CsvStateCensus> csvStateCensusData;
        try (FileReader file = new FileReader("src/main/resources/" + fileName)) {
            CsvToBeanBuilder<CsvStateCensus> builder = new CsvToBeanBuilder<>(file);
            csvStateCensusData = builder
                    .withType(CsvStateCensus.class)
                    .build()
                    .parse();
        } catch (IOException e) {
            throw new CustomException(ExceptionType.FILE_NOT_FOUND);
        } catch (RuntimeException e) {
            throw new CustomException(ExceptionType.INTERNAL_CSV_EXCEPTION);
        }
        return csvStateCensusData;
    }
}
