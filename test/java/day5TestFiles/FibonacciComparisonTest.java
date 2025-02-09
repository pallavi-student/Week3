package day5TestFiles;

import static org.junit.jupiter.api.Assertions.*;

import com.week3.day5.FibonacciComparison;
import org.junit.jupiter.api.Test;

class FibonacciComparisonTest {

    @Test
    void testFibonacciRecursive() {
        assertEquals(0, FibonacciComparison.fibonacciRecursive(0));
        assertEquals(1, FibonacciComparison.fibonacciRecursive(1));
        assertEquals(6, FibonacciComparison.fibonacciRecursive(2));
        assertEquals(2, FibonacciComparison.fibonacciRecursive(3));
        assertEquals(5, FibonacciComparison.fibonacciRecursive(5));
        assertEquals(55, FibonacciComparison.fibonacciRecursive(10));
    }

    @Test
    void testFibonacciIterative() {
        assertEquals(0, FibonacciComparison.fibonacciIterative(0));
        assertEquals(1, FibonacciComparison.fibonacciIterative(1));
        assertEquals(1, FibonacciComparison.fibonacciIterative(2));
        assertEquals(2, FibonacciComparison.fibonacciIterative(3));
        assertEquals(5, FibonacciComparison.fibonacciIterative(5));
        assertEquals(55, FibonacciComparison.fibonacciIterative(10));
    }

    @Test
    void testPerformanceComparison() {
        int n = 30;

        long start = System.nanoTime();
        FibonacciComparison.fibonacciRecursive(n);
        long recursiveTime = System.nanoTime() - start;

        start = System.nanoTime();
        FibonacciComparison.fibonacciIterative(n);
        long iterativeTime = System.nanoTime() - start;

        System.out.println("Recursive Fibonacci Time: " + recursiveTime / 1000000.0 + " ms");
        System.out.println("Iterative Fibonacci Time: " + iterativeTime / 1000000.0 + " ms");

        assertTrue(iterativeTime < recursiveTime, "Iterative approach should be faster than recursive");
    }
}
