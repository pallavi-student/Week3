package com.week3.day4.stringBuilder;

import java.util.Scanner;

import static java.lang.System.out;

public class ReverseString {
    public static void main(String[] args) {
        //programme to reverse a given String using StringBuilder
        Scanner input=new Scanner(System.in);
        //Taking String input from the user
        String original=input.nextLine();
        //Converting String to StringBuilder by using StringBuilder Constructor
        StringBuilder sb=new StringBuilder(original);
        //Reversing the original String by calling built-in function of StringBuilder
        sb.reverse();
        //Converting StringBuilder to String
        String reverse=sb.toString();
        out.println("Original String is "+original);
        out.println("Reverse String is "+reverse);

    }
}
