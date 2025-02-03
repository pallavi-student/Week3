package com.week3.day3;

import java.util.Arrays;

public class HeapSort {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heap(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heap(arr, i, 0);
        }
    }

    public static void heap(int[] arr, int n, int i) {
        int largest = i, left = 2 * i + 1, right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;

        if (largest != i) {
            swap(arr, i, largest);
            heap(arr, n, largest); // Fixed the incorrect method call
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] salaries = {50, 450, 67, 900, 68};

        System.out.println("Before sorting: " + Arrays.toString(salaries));
        heapSort(salaries);
        System.out.println("After sorting: " + Arrays.toString(salaries));
    }
}
