package com.week3.day3;

import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String[] args) {
        int[] examScores = {50, 48, 45, 88, 67, 99, 81};

        System.out.println(Arrays.toString(examScores));
        selectionSort(examScores);
        System.out.println(Arrays.toString(examScores));
    }

}