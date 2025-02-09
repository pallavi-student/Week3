package day4TestFiles;

import static org.junit.jupiter.api.Assertions.*;

import com.week3.day4.binarySearch.FindRotationPoint;
import org.junit.jupiter.api.Test;

class FindRotationPointTest {

    @Test
    void testFindRotationPoint() {
        int[] arr1 = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        assertEquals(3, FindRotationPoint.findRotationPoint(arr1));
        assertEquals(1, arr1[FindRotationPoint.findRotationPoint(arr1)]);

        int[] arr2 = {15, 18, 2, 3, 6, 12};
        assertEquals(2, FindRotationPoint.findRotationPoint(arr2));
        assertEquals(2, arr2[FindRotationPoint.findRotationPoint(arr2)]);

        int[] arr3 = {1, 2, 3, 4, 5}; // Not rotated
        assertEquals(0, FindRotationPoint.findRotationPoint(arr3));
        assertEquals(1, arr3[FindRotationPoint.findRotationPoint(arr3)]);
    }
}
