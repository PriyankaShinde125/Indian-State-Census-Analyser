package org.example;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class StateCensusAnalyser {
    public List<CsvStateCensus> loadData() throws CustomException {
        List<CsvStateCensus> csvStateCensusData;
        try (FileReader file = new FileReader("src/main/resources/IndiaStateCensusData.csv")) {
            CsvToBeanBuilder<CsvStateCensus> builder = new CsvToBeanBuilder<>(file);
            csvStateCensusData = builder
                    .withType(CsvStateCensus.class)
                    .build()
                    .parse();
            csvStateCensusData.forEach(System.out::println);
        } catch (FileNotFoundException e) {
            throw new CustomException(ExceptionType.FILE_NOT_FOUND);
        } catch (IOException e) {
            throw new CustomException(ExceptionType.IO_EXCEPTION);
        }
        return csvStateCensusData;
    }
}
