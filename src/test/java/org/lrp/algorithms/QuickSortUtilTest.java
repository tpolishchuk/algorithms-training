package org.lrp.algorithms;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class QuickSortUtilTest {

    @Test
    public void sortFromMinToMaxFully() {
        int[] array = new int[]{1, 25, 6, 34, -125, 0, -3};
        int[] expectedSortedArray = new int[]{-125, -3, 0, 1, 6, 25, 34};
        int[] actualSortedArray = QuickSortUtil.sortFromMinToMax(array);

        assertArrayEquals("Got an unexpectedly sorted array: " + Arrays.toString(actualSortedArray),
                          expectedSortedArray, actualSortedArray);
    }

    @Test
    public void sortFromMinToMaxPartially() {
        int[] array = new int[]{6, 16, 1, 7, 8};
        int[] expectedSortedArray = new int[]{1, 6, 7, 16, 8};
        int[] actualSortedArray = QuickSortUtil.sortFromMinToMax(array, 0, 3);

        assertArrayEquals("Got an unexpectedly sorted array: " + Arrays.toString(actualSortedArray),
                          expectedSortedArray, actualSortedArray);
    }

    @Test
    public void sortEmptyArray() {
        int[] array = new int[]{};
        int[] actualSortedArray = QuickSortUtil.sortFromMinToMax(array);

        assertArrayEquals("Got an unexpectedly sorted array: " + Arrays.toString(actualSortedArray),
                          array, actualSortedArray);
    }
}
