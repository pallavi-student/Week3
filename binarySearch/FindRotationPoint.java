package com.week3.day4.binarySearch;

public class FindRotationPoint {

        public static int findRotationPoint(int[] arr) {
            int left = 0, right = arr.length - 1;

            while (left < right) {
                int mid = left + (right - left) / 2;

                // If mid element is greater than right element, the smallest element is in right half
                if (arr[mid] > arr[right]) {
                    left = mid + 1;
                }
                // Else, the smallest element is in left half (including mid)
                else {
                    right = mid;
                }
            }
            return left; // Left now points to the smallest element (rotation point)
        }
        public static void main(String[] args) {
        int[] arr = { 7, 8, 9, 1, 2, 3, 4, 5, 6 }; // Rotated sorted array
        int rotationIndex = findRotationPoint(arr);
        System.out.println("Rotation point index: " + rotationIndex);
        System.out.println("Smallest element: " + arr[rotationIndex]);
    }
    }


