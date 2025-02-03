package com.week3.day3;

import java.util.Arrays;
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    public static void main(String[] args) {
        int[] employeeIDs = {97, 101, 100, 102, 104};

        System.out.println(Arrays.toString(employeeIDs));
        insertionSort(employeeIDs);
        System.out.println( Arrays.toString(employeeIDs));
    }




}
