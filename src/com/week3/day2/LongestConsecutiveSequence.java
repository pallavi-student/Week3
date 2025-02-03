package com.week3.day2;

import java.util.*;

class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int maxLen = 0;

        for (int num : nums) {
            if (!set.contains(num - 1)) { // Only check for sequence start
                int length = 1;
                while (set.contains(num + length)) {
                    length++;
                }
                maxLen = Math.max(maxLen, length);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 300, 3, 2};
        System.out.println(longestConsecutive(nums)); // Output: 4 (1,2,3,4)
    }
}