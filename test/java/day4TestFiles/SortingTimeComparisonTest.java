package day4TestFiles;

import com.week3.day5.SortingTimeComparison;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class SortingTimeComparisonTest {

    // Helper method to verify sorting correctness
    private void testSortingAlgorithm(int[] original, int[] sorted, Runnable sortingMethod) {
        int[] expected = Arrays.copyOf(original, original.length);
        Arrays.sort(expected); // Sort using Java's built-in sorting
        sortingMethod.run();
        assertArrayEquals(expected, sorted);
    }

    @Test
    public void testBubbleSort() {
        int[] data = {5, 2, 9, 1, 5, 6};
        int[] sortedData = Arrays.copyOf(data, data.length);
        SortingTimeComparison.bubbleSort(sortedData);
        testSortingAlgorithm(data, sortedData, () -> SortingTimeComparison.bubbleSort(sortedData));
    }

    @Test
    public void testMergeSort() {
        int[] data = {10, -2, 4, 7, 1, 5};
        int[] sortedData = Arrays.copyOf(data, data.length);
        SortingTimeComparison.mergeSort(sortedData, 0, sortedData.length - 1);
        testSortingAlgorithm(data, sortedData, () -> SortingTimeComparison.mergeSort(sortedData, 0, sortedData.length - 1));
    }

    @Test
    public void testQuickSort() {
        int[] data = {3, 8, 6, 2, 9, 1};
        int[] sortedData = Arrays.copyOf(data, data.length);
        SortingTimeComparison.quickSort(sortedData, 0, sortedData.length - 1);
        testSortingAlgorithm(data, sortedData, () -> SortingTimeComparison.quickSort(sortedData, 0, sortedData.length - 1));
    }

    @Test
    public void testSortingPerformance() {
        int[] data = SortingTimeComparison.generateRandomArray(10000);

        // Measure performance of sorting algorithms
        long startTime = System.nanoTime();
        int[] bubbleData = Arrays.copyOf(data, data.length);
        SortingTimeComparison.bubbleSort(bubbleData);
        long bubbleSortTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        int[] mergeData = Arrays.copyOf(data, data.length);
        SortingTimeComparison.mergeSort(mergeData, 0, mergeData.length - 1);
        long mergeSortTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        int[] quickData = Arrays.copyOf(data, data.length);
        SortingTimeComparison.quickSort(quickData, 0, quickData.length - 1);
        long quickSortTime = System.nanoTime() - startTime;

        System.out.println("Bubble Sort Time: " + bubbleSortTime / 1_000_000.0 + " ms");
        System.out.println("Merge Sort Time: " + mergeSortTime / 1_000_000.0 + " ms");
        System.out.println("Quick Sort Time: " + quickSortTime / 1_000_000.0 + " ms");
    }
}
