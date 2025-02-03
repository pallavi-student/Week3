package com.week3.day2;

import java.util.*;

class PairWithGivenSum {
    public static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(target - num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 7, 3, 9};
        int target = 10;
        System.out.println(hasPairWithSum(nums, target)); // Output: true
    }
}