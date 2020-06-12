package org.lrp.algorithms;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class MergeSortUtilTest {

    @Test
    public void sortFromMinToMax() {
        int[] array = new int[]{4, 1, 16, 9, -36, 0, 245, -3, 55};
        int[] expectedSortedArray = new int[]{-36, -3, 0, 1, 4, 9, 16, 55, 245};
        int[] actualSortedArray = MergeSortUtil.divideAndMerge(array);

        assertArrayEquals("Got an unexpectedly sorted array: " + Arrays.toString(actualSortedArray),
                          expectedSortedArray, actualSortedArray);
    }

    @Test
    public void sortEmptyArray() {
        int[] array = new int[]{};
        int[] actualSortedArray = MergeSortUtil.divideAndMerge(array);

        assertArrayEquals("Got an unexpectedly sorted array: " + Arrays.toString(actualSortedArray),
                          array, actualSortedArray);
    }
}
