package com.murex.retail.experience;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {
    @Test
    void test_read_in_csv() throws IOException {
        List<String> expectedResult = (Arrays.asList("JAVA,PYTHON,C", "ECLIPSE,INTELLIJ,JCREATOR"));
        Parser testParse = new Parser("src/test/resources/test_file.csv");
        List<String> actualResult = testParse.readCSV();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test_replace_comma_method() throws IOException {
        Parser testParse = new Parser("src/test/resources/test_file.csv");
        List<String> actualResult = testParse.readCSV();
        List<String> expectedResult = Arrays.asList("JAVA\t|\tPYTHON\t|\tC", "ECLIPSE\t|\tINTELLIJ\t|\tJCREATOR");
        actualResult = testParse.replaceCommasAndLog(actualResult);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test_empty_csv() throws IOException {
        List<String> expectedResult = new ArrayList<String>(Arrays.asList(""));
        Parser testParse = new Parser("src/test/resources/empty.csv");
        List<String> actualResult = testParse.readCSV();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test_wrong_file_location() {
        Parser testParse = new Parser("src/test/resources/wrong.csv");
        Assertions.assertThrows(NoSuchFileException.class, () -> testParse.readCSV());
    }

    @Test
    void test_wrong_format_file() {
        Parser testParse = new Parser("src/test/resources/wrong_format.docx");
        Assertions.assertThrows(IOException.class, () -> testParse.readCSV());
    }

}
