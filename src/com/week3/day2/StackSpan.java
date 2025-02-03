package com.week3.day2;

import java.util.*;

class StackSpan {
    static ArrayList<Integer> calculateSpan(
            ArrayList<Integer> arr) {

        int n = arr.size();
        ArrayList<Integer> span = new ArrayList<>(
                Collections.nCopies(n, 0));
        Stack<Integer> stk = new Stack<>();

        // Process each day's price
        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && arr.get(stk.peek())
                    <= arr.get(i)) {
                stk.pop();
            }
            if (stk.isEmpty()) {
                span.set(i, (i + 1));
            } else {
                span.set(i, (i - stk.peek()));
            }

            // Push the current index to the stack
            stk.push(i);
        }

        return span;
    }

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>(
                Arrays.asList(100, 4, 5, 90, 120, 80));

        ArrayList<Integer> span = calculateSpan(arr);

        for (int x : span) {
            System.out.print(x + " ");
        }
    }
}