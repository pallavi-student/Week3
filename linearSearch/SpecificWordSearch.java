package com.week3.day4.linearSearch;
import java.io.*;
public class SpecificWordSearch {
        public static void main(String[] args) {
            // Sample list of sentences
            String[] sentences = {
                    "Java is a popular programming language.",
                    "I love solving coding problems.",
                    "Data structures and algorithms are important.",
                    "Linear search is simple but not always good.",
                    "Practice makes perfect in programming."
            };

            // Reading input using BufferedReader
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                System.out.print("Enter the word to search: ");
                String searchWord = br.readLine().trim(); // Read input and trim extra spaces

                // Perform linear search
                String result = searchWordInSentences(sentences, searchWord);

                // Output result
                System.out.println("Result: " + result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static String searchWordInSentences(String[] sentences, String word) {
            for (String sentence : sentences) {
                if (sentence.toLowerCase().contains(word.toLowerCase())) {
                    return sentence; // Return the first matching sentence
                }
            }
            return "Not Found";
        }
    }


