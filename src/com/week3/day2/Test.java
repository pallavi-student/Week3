package com.week3.day2;

import java.util.ListIterator;
import java.util.Stack;

class Test {
    static void sortedInsert(Stack<Integer> s, int x)
    {
        if (s.isEmpty() || x > s.peek()) {
            s.push(x);
            return;
        }

        // If top is greater, remove the top item and recur
        int temp = s.pop();
        sortedInsert(s, x);
        s.push(temp);
    }

    // Method to sort stack
    static void sortStack(Stack<Integer> s)
    {
        // If stack is not empty
        if (!s.isEmpty()) {
            // Remove the top item
            int x = s.pop();

            // Sort remaining stack
            sortStack(s);
            sortedInsert(s, x);
        }
    }


    static void printStack(Stack<Integer> s)
    {
        ListIterator<Integer> lt = s.listIterator();

        while (lt.hasNext())
            lt.next();

        // printing from top to bottom
        while (lt.hasPrevious())
            System.out.print(lt.previous() + " ");
    }
    public static void main(String[] args)
    {
        Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(-50);
        s.push(10);
        s.push(14);
        s.push(-3);

        System.out.println(
                "before sorting: ");
        printStack(s);

        sortStack(s);

        System.out.println(
                " after sorting:");
        printStack(s);
    }
}