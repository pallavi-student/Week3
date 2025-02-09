package day4TestFiles;

import static org.junit.jupiter.api.Assertions.*;

import com.week3.day5.SearchingComparison;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

class SearchingComparisonTest {

    private int[] arr;
    private HashSet<Integer> hashSet;
    private TreeSet<Integer> treeSet;
    private int target;
    private static final int SIZE = 10000;

    @BeforeEach
    void setUp() {
        arr = new int[SIZE];
        hashSet = new HashSet<>();
        treeSet = new TreeSet<>();
        Random random = new Random();

        for (int i = 0; i < SIZE; i++) {
            int num = random.nextInt(SIZE * 10);
            arr[i] = num;
            hashSet.add(num);
            treeSet.add(num);
        }
        target = arr[random.nextInt(SIZE)];
    }

    @Test
    void testLinearSearch() {
        assertTrue(SearchingComparison.linearSearch(arr, target));
    }

    @Test
    void testHashSetSearch() {
        assertTrue(hashSet.contains(target));
    }

    @Test
    void testTreeSetSearch() {
        assertTrue(treeSet.contains(target));
    }

    @Test
    void testPerformance() {
        long start, end;

        start = System.nanoTime();
        SearchingComparison.linearSearch(arr, target);
        end = System.nanoTime();
        System.out.println("Linear Search Time: " + (end - start) / 1000000.0 + " ms");

        start = System.nanoTime();
        hashSet.contains(target);
        end = System.nanoTime();
        System.out.println("HashSet Search Time: " + (end - start) / 1000000.0 + " ms");

        start = System.nanoTime();
        treeSet.contains(target);
        end = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (end - start) / 1000000.0 + " ms");
    }
}
