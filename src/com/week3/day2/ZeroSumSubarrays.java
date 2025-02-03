package com.week3.day2;

import java.util.*;

class ZeroSumSubarrays {
    public static List<int[]> findZeroSumSubarrays(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<int[]> result = new ArrayList<>();
        int sum = 0;
        map.put(0, new ArrayList<>(List.of(-1)));
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum)) {
                for (int start : map.get(sum)) {
                    result.add(new int[]{start + 1, i});
                }
            }
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, -3, 3, 1, -4, 2, 2};
        List<int[]> subarrays = findZeroSumSubarrays(nums);
        for (int[] sub : subarrays) {
            System.out.println("Subarray" + sub[0] + " to " + sub[1]);
        }
    }
}