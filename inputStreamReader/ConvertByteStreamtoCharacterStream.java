package com.week3.day4.inputStreamReader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ConvertByteStreamtoCharacterStream {
    public static void omain(String[] args) {
        try{
            FileInputStream file=new FileInputStream("src/com/week3/day4/Sample1.txt");//read data in the form of binary form
            InputStreamReader isr=new InputStreamReader(file, StandardCharsets.US_ASCII);//convert data to characters using encoding specified
            BufferedReader br=new BufferedReader(isr);// helps to read character from file
           String line;
            while((line= br.readLine())!=null){
                System.out.println(line);

            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
