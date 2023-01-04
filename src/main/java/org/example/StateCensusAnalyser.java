package org.example;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class StateCensusAnalyser {
    public List<CsvStateCensus> loadData(String fileName) throws CustomException {
        List<CsvStateCensus> csvStateCensusData;
        try (FileReader file = new FileReader("src/main/resources/"+fileName)) {
            CsvToBeanBuilder<CsvStateCensus> builder = new CsvToBeanBuilder<>(file);
            csvStateCensusData = builder
                    .withType(CsvStateCensus.class)
                    .build()
                    .parse();
            csvStateCensusData.forEach(System.out::println);
        } catch (IOException e) {
            throw new CustomException(ExceptionType.FILE_NOT_FOUND);
        }
        return csvStateCensusData;
    }
}
