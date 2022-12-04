package org.example;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClassMissingNumberPerformanceTest {

    private int[] missingMax = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    private int[] missingNone = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    private int[] missingSeven = { 1, 2, 3, 4, 5, 6, 8, 9, 10 };
    private int max = 10;
    private ClassMissingNumber mn = new ClassMissingNumber();

    // FYI only implemented one function -- below tests the same function three times.
    @Test(timeout=1000)
    public void testMissingNumber_Performance() {
        for (int i = 0; i < 1000000; i += 1) {
            mn.findMissingNum(missingMax, max);
            mn.findMissingNum(missingNone, max);
            mn.findMissingNum(missingSeven, max);
        }
    }

    @Test(timeout=1000)
    public void testMissingNumberSort_Performance() {
        for (int i = 0; i < 1000000; i += 1) {
            mn.findMissingNum(missingMax, max);
            mn.findMissingNum(missingNone, max);
            mn.findMissingNum(missingSeven, max);
        }
    }

    @Test(timeout=1000)
    public void testMissingNumberSum_Performance() {
        for (int i = 0; i < 1000000; i += 1) {
            mn.findMissingNum(missingMax, max);
            mn.findMissingNum(missingNone, max);
            mn.findMissingNum(missingSeven, max);
        }
    }
}

// In Part 1, you wrote 3 different solutions with different runtime complexities.
// Let’s test that Step 3’s solution is actually the most efficient! Create a file
// MissingNumberPerformanceTest and write tests for each of the 3 solutions to
// show which solution is the most efficient.