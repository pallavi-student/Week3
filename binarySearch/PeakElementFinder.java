package com.week3.day4.binarySearch;

public class PeakElementFinder {
    public static int findPeakElement(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is smaller than its right neighbor, move right
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            }
            // Otherwise, move left
            else {
                right = mid;
            }
        }
        return left; // 'left' or 'right' will point to a peak element
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0}; // Example array
        int peakIndex = findPeakElement(arr);
        System.out.println("Peak element index: " + peakIndex);
        System.out.println("Peak element value: " + arr[peakIndex]);
    }
}
