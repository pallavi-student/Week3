package day5TestFiles;

import static org.junit.jupiter.api.Assertions.*;

import com.week3.day5.StringPerformance;
import org.junit.jupiter.api.Test;

class StringPerformanceTest {

    @Test
    void testStringConcatenation() {
        double timeSmall = StringPerformance.stringConcatenation(1000);
        double timeMedium = StringPerformance.stringConcatenation(10000);
        double timeLarge = StringPerformance.stringConcatenation(1000000);

        System.out.println("String Time: " + timeSmall + ", " + timeMedium + ", " + timeLarge + " ms");
        assertTrue(timeSmall < timeMedium && timeMedium < timeLarge);
    }

    @Test
    void testStringBuilderConcatenation() {
        double timeSmall = StringPerformance.stringBuilderConcatenation(1000);
        double timeMedium = StringPerformance.stringBuilderConcatenation(10000);
        double timeLarge = StringPerformance.stringBuilderConcatenation(1000000);

        System.out.println("StringBuilder Concatenation Time: " + timeSmall + ", " + timeMedium + ", " + timeLarge + " ms");
        assertTrue(timeSmall < timeMedium && timeMedium < timeLarge);
    }

    @Test
    void testStringBufferConcatenation() {
        double timeSmall = StringPerformance.stringBufferConcatenation(1000);
        double timeMedium = StringPerformance.stringBufferConcatenation(10000);
        double timeLarge = StringPerformance.stringBufferConcatenation(1000000);

        System.out.println("StringBuffer Time: " + timeSmall + ", " + timeMedium + ", " + timeLarge + " ms");
        assertTrue(timeSmall < timeMedium && timeMedium < timeLarge);
    }
}
