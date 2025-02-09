package com.week3.day4.fileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileUsingFileReader {
    public static void main(String[] args){try {
        FileReader fr = new FileReader("src/com/week3/day4/Sample1.txt");
        BufferedReader br=new BufferedReader(fr);
        String line;
        while((line=br.readLine())!=null){
            System.out.println(line);
        }
    }
    catch(IOException ex){
        ex.printStackTrace();
    }
    }
}
