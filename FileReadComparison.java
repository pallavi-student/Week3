package com.week3.day5;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileReadComparison {
    private static final String FILE_PATH_1MB = "large_file_1MB.txt";
    private static final String FILE_PATH_100MB = "large_file_100MB.txt";
    private static final String FILE_PATH_500MB = "large_file_500MB.txt";

    public static void main(String[] args) {
        try {
            generateLargeFile(FILE_PATH_1MB, 1);
            generateLargeFile(FILE_PATH_100MB, 100);
            generateLargeFile(FILE_PATH_500MB, 500);

            compareFileReadPerformance(FILE_PATH_1MB, "1MB");
            compareFileReadPerformance(FILE_PATH_100MB, "100MB");
            compareFileReadPerformance(FILE_PATH_500MB, "500MB");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     static void generateLargeFile(String filePath, int sizeInMB) throws IOException {
        System.out.println("Generating a large file of " + sizeInMB + " MB...");
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        String data = "Hi all This is Pallavi's Code.\n";
        int lines = (sizeInMB * 1024 * 1024) / data.length();

        for (int i = 0; i < lines; i++) {
            writer.write(data);
        }
        writer.close();
        System.out.println("File generation complete: " + filePath);
    }

    static void compareFileReadPerformance(String filePath, String sizeLabel) throws IOException {
        long fileReaderTime = measureFileReaderTime(filePath);
        System.out.println("FileReader Time for " + sizeLabel + ": " + fileReaderTime + " ms");

        long inputStreamReaderTime = measureInputStreamReaderTime(filePath);
        System.out.println("InputStreamReader Time for " + sizeLabel + ": " + inputStreamReaderTime + " ms");
    }

     static long measureFileReaderTime(String filePath) throws IOException {
        long startTime = System.currentTimeMillis();
        FileReader fileReader = new FileReader(filePath);
        while (fileReader.read() != -1) {
            // Read character by character
        }
        fileReader.close();
        return System.currentTimeMillis() - startTime;
    }

    static long measureInputStreamReaderTime(String filePath) throws IOException {
        long startTime = System.currentTimeMillis();
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8);
        while (inputStreamReader.read() != -1) {
            // Read character by character
        }
        inputStreamReader.close();
        return System.currentTimeMillis() - startTime;
    }
}
