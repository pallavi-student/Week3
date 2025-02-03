package com.week3.day3;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        double[] bookPrices = {499, 150.7, 299, 199, 350};

        System.out.println("Original " + Arrays.toString(bookPrices));
        mergeSort(bookPrices);
        System.out.println("Sorted " + Arrays.toString(bookPrices));
    }

    public static void mergeSort(double[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        double[] left = Arrays.copyOfRange(arr, 0, mid);
        double[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    public static void merge(double[] arr, double[] left, double[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            arr[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];
        }
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }
}