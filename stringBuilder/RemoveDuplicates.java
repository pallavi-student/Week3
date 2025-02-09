package com.week3.day4.stringBuilder;
import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String original=sc.nextLine();
        StringBuilder sb=new StringBuilder();
        HashSet<Character>hs=new HashSet<>();
        for(char itr:original.toCharArray()) {
            if (!hs.contains(itr)) {
                sb.append(itr);
            }
            hs.add(itr);
        }
        String uniqueChar=sb.toString();
        System.out.println("Original String is "+original);
        System.out.println("After removing duplicate character "+uniqueChar);

    }
}
