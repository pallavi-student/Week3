package com.week3.day4.challengeProblem1and2;
import java.util.Arrays;

public class LinearBinarySearchChallenge {
    // Linear Search to find the first missing positive integer
    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;


        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    // Utility function
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Binary Search to find target index
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;  // Target found
            } else if (arr[mid] < target) {
                left = mid + 1;  // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
        return -1;  // Target not found
    }
    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        int target = 4;  // Target number

        int missingPositive = findFirstMissingPositive(arr);
        System.out.println("First missing positive integer: " + missingPositive);

        Arrays.sort(arr);  // Binary Search requires a sorted array
        int targetIndex = binarySearch(arr, target);
        System.out.println("Index of target " + target + ": " + targetIndex);
    }
}
