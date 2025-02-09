package com.week3.day4.stringBuffer;

import java.util.Scanner;

import static java.lang.System.out;

public class ConcatenateStrings {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int size=input.nextInt();
        String[]str=new String[size];
        StringBuffer concatWords=new StringBuffer();
        for(int i=0;i<size;i++){
            str[i]=input.nextLine();
        }
        for(String itr:str){
            concatWords.append(itr);
        }
        out.println("Original Inputted array ");
        out.println("After concatenation "+concatWords);


    }
}
