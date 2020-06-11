package org.lrp.algorithms;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class BubbleSortUtilTest {

    @Test
    public void sortFromMinToMax() {
        int[] array = new int[]{9, 1, 7, 2, 4, 15, 35, -8, 1};
        int[] expectedSortedArray = new int[]{-8, 1, 1, 2, 4, 7, 9, 15, 35};
        int[] actualSortedArray = BubbleSortUtil.sort(array);

        assertArrayEquals("Got an unexpectedly sorted array: " + Arrays.toString(actualSortedArray),
                          expectedSortedArray, actualSortedArray);
    }

    @Test
    public void sortSingleElementArray() {
        int[] array = new int[]{9};
        int[] actualSortedArray = BubbleSortUtil.sort(array);

        assertArrayEquals("Got an unexpectedly sorted array: " + Arrays.toString(actualSortedArray),
                          array, actualSortedArray);
    }

    @Test
    public void sortEmptyArray() {
        int[] array = new int[]{};
        int[] actualSortedArray = BubbleSortUtil.sort(array);

        assertArrayEquals("Got an unexpectedly sorted array: " + Arrays.toString(actualSortedArray),
                          array, actualSortedArray);
    }
}
