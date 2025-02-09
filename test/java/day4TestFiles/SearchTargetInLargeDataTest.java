package day4TestFiles;

import com.week3.day5.SearchTargetInLargeData;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Random;

public class SearchTargetInLargeDataTest {

    @Test
    public void testLinearSearch() {
        int[] arr = {1, 2, 3, 4, 5};
        assertTrue(SearchTargetInLargeData.linearSearch(arr, 3));
        assertFalse(SearchTargetInLargeData.linearSearch(arr, 10));
    }

    @Test
    public void testBinarySearch() {
        int[] arr = {1, 2, 3, 4, 5};
        assertTrue(SearchTargetInLargeData.binarySearch(arr, 3));
        assertFalse(SearchTargetInLargeData.binarySearch(arr, 10));
    }

    @Test
    public void testBinarySearchWithUnsortedArray() {
        int[] arr = {5, 3, 1, 4, 2};
        assertFalse(SearchTargetInLargeData.binarySearch(arr, 3)); // Unsorted array, might fail

        Arrays.sort(arr);
        assertTrue(SearchTargetInLargeData.binarySearch(arr, 3)); // Should pass after sorting
    }

    @Test
    public void testSearchPerformance() {
        int size = 100000;
        int[] arr = SearchTargetInLargeData.randomArray(size);
        int target = arr[new Random().nextInt(size)];

        long start = System.nanoTime();
        boolean linearFound = SearchTargetInLargeData.linearSearch(arr, target);
        long end = System.nanoTime();
        System.out.println("Linear Search Time: " + (end - start) / 1e6 + " ms");

        Arrays.sort(arr);
        start = System.nanoTime();
        boolean binaryFound = SearchTargetInLargeData.binarySearch(arr, target);
        end = System.nanoTime();
        System.out.println("Binary Search Time: " + (end - start) / 1e6 + " ms");

        assertTrue(linearFound);
        assertTrue(binaryFound);
    }
}
