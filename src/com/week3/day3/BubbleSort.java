package com.week3.day3;

import java.util.Arrays;
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped in the last pass, break only for optimization
            if (!swapped) break;
        }
    }
    public static void main(String[] args) {
        int[] marks = {95, 72, 90, 45, 40, 95, 85};

        System.out.println("Original Marks: " + Arrays.toString(marks));
        bubbleSort(marks);
        System.out.println("Sorted Marks: " + Arrays.toString(marks));


    }
}