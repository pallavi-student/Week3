package day4TestFiles;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

class CompareInputTakingMethodsTest {

    @Test
    void testStringConcatenationPerformance() {
        long stringBuilderTime = measureStringBuilderTime();
        long stringBufferTime = measureStringBufferTime();

        System.out.println("StringBuilder Time: " + stringBuilderTime + " ns");
        System.out.println("StringBuffer Time: " + stringBufferTime + " ns");

        assertTrue(stringBuilderTime > 0);
        assertTrue(stringBufferTime > 0);
    }

    private long measureStringBuilderTime() {
        StringBuilder sb = new StringBuilder();
        long start = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            sb.append("hello");
        }
        return System.nanoTime() - start;
    }

    private long measureStringBufferTime() {
        StringBuffer sb = new StringBuffer();
        long start = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            sb.append("hello");
        }
        return System.nanoTime() - start;
    }

    @Test
    void testFileReadingPerformance() throws IOException {
        String filePath = "src/main/java/day4/Sample1.txt";

        long fileReaderTime = measureFileReaderTime(filePath);
        long inputStreamReaderTime = measureInputStreamReaderTime(filePath);

        System.out.println("FileReader Time: " + fileReaderTime + " ns");
        System.out.println("InputStreamReader Time: " + inputStreamReaderTime + " ns");

        assertTrue(fileReaderTime > 0);
        assertTrue(inputStreamReaderTime > 0);
    }

    private long measureFileReaderTime(String filePath) throws IOException {
        long start = System.nanoTime();
        int wordCount = countWordsUsingFileReader(filePath);
        return System.nanoTime() - start;
    }

    private long measureInputStreamReaderTime(String filePath) throws IOException {
        long start = System.nanoTime();
        int wordCount = countWordsUsingInputStreamReader(filePath);
        return System.nanoTime() - start;
    }

    private int countWordsUsingFileReader(String filePath) throws IOException {
        int wordCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        }
        return wordCount;
    }

    private int countWordsUsingInputStreamReader(String filePath) throws IOException {
        int wordCount = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        }
        return wordCount;
    }
}
