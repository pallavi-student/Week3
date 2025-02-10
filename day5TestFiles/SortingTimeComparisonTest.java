package day5TestFiles;

import static org.junit.jupiter.api.Assertions.*;

import com.week3.day5.SortingTimeComparison;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class SortingTimeComparisonTest {

    @Test
    void testBubbleSort() {
        int[] array = {5, 3, 8, 4, 2};
        int[] expected = {2, 3, 4, 5, 8};
        SortingTimeComparison.bubbleSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void testMergeSort() {
        int[] array = {10, 1, 9, 3, 7};
        int[] expected = {1, 3, 7, 9, 10};
        SortingTimeComparison.mergeSort(array, 0, array.length - 1);
        assertArrayEquals(expected, array);
    }

    @Test
    void testQuickSort() {
        int[] array = {12, 4, 5, 6, 1};
        int[] expected = {1, 4, 5, 6, 12};
        SortingTimeComparison.quickSort(array, 0, array.length - 1);
        assertArrayEquals(expected, array);
    }

    @Test
    void testSortingPerformance() {
        int size = 10000;
        int[] data = SortingTimeComparison.generateRandomArray(size);

        if (size <= 10000) {
            int[] bubbleData = Arrays.copyOf(data, data.length);
            long startTime = System.nanoTime();
            SortingTimeComparison.bubbleSort(bubbleData);
            long endTime = System.nanoTime();
            System.out.println("Bubble Sort Time: " + (endTime - startTime) / 1_000_000.0 + " ms");
        }

        int[] mergeData = Arrays.copyOf(data, data.length);
        long mergeStart = System.nanoTime();
        SortingTimeComparison.mergeSort(mergeData, 0, mergeData.length - 1);
        long mergeEnd = System.nanoTime();
        System.out.println("Merge Sort Time: " + (mergeEnd - mergeStart) / 1_000_000.0 + " ms");

        int[] quickData = Arrays.copyOf(data, data.length);
        long quickStart = System.nanoTime();
        SortingTimeComparison.quickSort(quickData, 0, quickData.length - 1);
        long quickEnd = System.nanoTime();
        System.out.println("Quick Sort Time: " + (quickEnd - quickStart) / 1_000_000.0 + " ms");
    }
}
