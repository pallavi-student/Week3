package day4TestFiles;

import com.week3.day5.StringPerformance;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringPerformanceTest {

    @Test
    public void testStringConcatenation() {
        double time1 = StringPerformance.stringConcatenation(1000);
        double time2 = StringPerformance.stringConcatenation(10000);
        assertTrue(time2 >= time1);
    }

    @Test
    public void testStringBuilderConcatenation() {
        double time1 = StringPerformance.stringBuilderConcatenation(1000);
        double time2 = StringPerformance.stringBuilderConcatenation(10000);
        assertTrue(time2 >= time1);
    }

    @Test
    public void testStringBufferConcatenation() {
        double time1 = StringPerformance.stringBufferConcatenation(1000);
        double time2 = StringPerformance.stringBufferConcatenation(10000);
        assertTrue(time2 >= time1);
    }

    @Test
    public void testPerformanceComparison() {
        double stringTime = StringPerformance.stringConcatenation(10000);
        double stringBuilderTime = StringPerformance.stringBuilderConcatenation(10000);
        double stringBufferTime = StringPerformance.stringBufferConcatenation(10000);

        assertTrue(stringBuilderTime < stringTime);
        assertTrue(stringBufferTime < stringTime);
    }
}
