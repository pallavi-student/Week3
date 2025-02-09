package com.week3.day4.challengeProblem1and2;

import java.io.FileReader;
import java.io.IOException;
import java.io.*;
public class CompareInputTakingMethods {

    private static void compareStringConcatenation() {
        // Concatenating using StringBuilder
        StringBuilder sb = new StringBuilder();
        long start = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            sb.append("hello");
        }
        long end = System.nanoTime();
        long timeTakenByStringBuilder = end - start;
        System.out.println("Time taken by StringBuilder to concatenate 1 million strings: " + timeTakenByStringBuilder + " ns");

        // Concatenating using StringBuffer
        StringBuffer sbuffer = new StringBuffer();
        start = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            sbuffer.append("hello");
        }
        end = System.nanoTime();
        long timeTakenByStringBuffer = end - start;
        System.out.println("Time taken by StringBuffer to concatenate 1 million strings: " + timeTakenByStringBuffer + " ns");
    }

    private static void compareFileReading() {
        String filePath = "src/main/java/day4/Sample1.txt";

        // Reading file using FileReader
        long start = System.nanoTime();
        int wordCountFileReader = countWordsUsingFileReader(filePath);
        long end = System.nanoTime();
        long timeTakenByFileReader = end - start;
        System.out.println("Time taken by FileReader: " + timeTakenByFileReader + " ns | Word count: " + wordCountFileReader);

        // Reading file using InputStreamReader
        start = System.nanoTime();
        int wordCountInputStreamReader = countWordsUsingInputStreamReader(filePath);
        end = System.nanoTime();
        long timeTakenByInputStreamReader = end - start;
        System.out.println("Time taken by InputStreamReader: " + timeTakenByInputStreamReader + " ns | Word count: " + wordCountInputStreamReader);
    }

    private static int countWordsUsingFileReader(String filePath) {
        int wordCount = 0;
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length; // Splitting by spaces
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return wordCount;
    }

    private static int countWordsUsingInputStreamReader(String filePath) {
        int wordCount = 0;
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
             BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length; // Splitting by spaces
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return wordCount;
    }
    public static void main(String[] args) {
        compareStringConcatenation();
        compareFileReading();
    }
}
