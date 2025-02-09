package com.week3.day4.inputStreamReader;

import java.io.*;

public class WriteToFileUsingInputStreamReader {
    public static void main(String[] args) {
       //setting path
        String filePath = "src/main/java/day4/JavaWrittenFile.txt";


        try (
                InputStreamReader isr = new InputStreamReader(System.in);  // Read user input
                BufferedReader br = new BufferedReader(isr);  // Efficient reading
                FileWriter fw = new FileWriter(filePath, true);  // Append mode to write into the file
                BufferedWriter bw = new BufferedWriter(fw)  // Efficient writing
        ) {
            System.out.println("Enter text to write to the file stop using\"exit\"");

            String line;
            while (!(line = br.readLine()).equalsIgnoreCase("exit")) {  // Read user input
                bw.write(line);  // Write input to file
                bw.newLine();  // Add a new line
            }

            System.out.println("User input has been saved to ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
