package day5TestFiles;

import static org.junit.jupiter.api.Assertions.*;

import com.week3.day5.FileReadComparison;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;

class FileReadComparisonTest {
    private static final String FILE_PATH_1MB = "large_file_1MB.txt";
    private static final String FILE_PATH_100MB = "large_file_100MB.txt";
    private static final String FILE_PATH_500MB = "large_file_500MB.txt";

    @BeforeAll
    static void setup() throws IOException {
        FileReadComparison.generateLargeFile(FILE_PATH_1MB, 1);
        FileReadComparison.generateLargeFile(FILE_PATH_100MB, 100);
        FileReadComparison.generateLargeFile(FILE_PATH_500MB, 500);
    }

    @Test
    void testFileGeneration() {
        assertTrue(new File(FILE_PATH_1MB).exists(), "1MB file should be generated");
        assertTrue(new File(FILE_PATH_100MB).exists(), "100MB file should be generated");
        assertTrue(new File(FILE_PATH_500MB).exists(), "500MB file should be generated");
    }

    @Test
    void testFileReaderPerformance() throws IOException {
        long time1MB = FileReadComparison.measureFileReaderTime(FILE_PATH_1MB);
        long time100MB = FileReadComparison.measureFileReaderTime(FILE_PATH_100MB);
        long time500MB = FileReadComparison.measureFileReaderTime(FILE_PATH_500MB);

        System.out.println("FileReader Time: 1MB: " + time1MB + " ms, 100MB: " + time100MB + " ms, 500MB: " + time500MB + " ms");
        assertTrue(time1MB < time100MB && time100MB < time500MB, "Reading time should increase with file size");
    }

    @Test
    void testInputStreamReaderPerformance() throws IOException {
        long time1MB = FileReadComparison.measureInputStreamReaderTime(FILE_PATH_1MB);
        long time100MB = FileReadComparison.measureInputStreamReaderTime(FILE_PATH_100MB);
        long time500MB = FileReadComparison.measureInputStreamReaderTime(FILE_PATH_500MB);

        System.out.println("InputStreamReader Time: 1MB: " + time1MB + " ms, 100MB: " + time100MB + " ms, 500MB: " + time500MB + " ms");
        assertTrue(time1MB < time100MB && time100MB < time500MB );
    }
}
