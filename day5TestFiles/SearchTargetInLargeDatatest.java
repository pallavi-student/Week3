package day5TestFiles;

import com.week3.day5.SearchTargetInLargeData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchTargetInLargeDatatest {

    int[] arr={23,45,56,67,78};
    int target=56;
    @Test
    void checkLinearSearch(){
        assertTrue(SearchTargetInLargeData.linearSearch(arr,target));
        assertTrue(SearchTargetInLargeData.linearSearch(arr,target));
    }
    @Test
    void checkBinarySearch(){int target1=89;
        assertTrue(SearchTargetInLargeData.binarySearch(arr,target1));
        target1=56;
        assertTrue(SearchTargetInLargeData.binarySearch(arr,target1));
    }
}
