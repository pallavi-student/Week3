package com.week3.day4.fileReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountOccurrenceUsingFileReader {
    public static void main(String[] args) {
        String target = "assigned";
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("src/com/week3/day4/Sample1.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line.toLowerCase().replaceAll("[^a-zA-Z0-9]\\s", "")).append(" ");
            }

            String[] arr = sb.toString().split("\\s");  // Fixes incorrect splitting
            for (String word : arr) {
                if (word.equals(target)) {
                    count++;
                }
            }

            System.out.println("The word " + target + " appears " + count + " times in the file.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
