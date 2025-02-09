package day5TestFiles;

import com.week3.day5.SearchingComparison;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;





class SearchingComparisonTest {

    @Test
    void testLinearSearch() {
        int[] arr = {1, 3, 5, 7, 9};
        assertTrue(SearchingComparison.linearSearch(arr, 5), "5 should be found in the array");
        assertFalse(SearchingComparison.linearSearch(arr, 4), "4 should not be found in the array");
    }

    @Test
    void testSearchPerformance() {
        int size = 100000;
        Random random = new Random();
        int[] arr = new int[size];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < size; i++) {
            int num = random.nextInt(size * 10);
            arr[i] = num;
            hashSet.add(num);
            treeSet.add(num);
        }

        int target = arr[random.nextInt(size)];

        long start = System.nanoTime();
        SearchingComparison.linearSearch(arr, target);
        long end = System.nanoTime();
        System.out.println("Array Search Time: " + (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        hashSet.contains(target);
        end = System.nanoTime();
        System.out.println("HashSet Search Time: " + (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        treeSet.contains(target);
        end = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (end - start) / 1_000_000.0 + " ms");
    }
}
