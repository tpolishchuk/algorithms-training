package org.lrp.algorithms;


import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class SelectionSortUtilTest {

    @Test
    public void sortFromMinToMax() {
        int[] array = new int[]{1, 25, 6, 34, -125, 0, -3};
        int[] expectedSortedArray = new int[]{-125, -3, 0, 1, 6, 25, 34};
        int[] actualSortedArray = SelectionSortUtil.sortFromMinToMax(array);

        assertArrayEquals("Got an unexpectedly sorted array: " + Arrays.toString(actualSortedArray),
                          expectedSortedArray, actualSortedArray);
    }

    @Test
    public void sortFromMinToMaxDuplicatedElements() {
        int[] array = new int[]{1, 25, 6, 15, 34, -125, 15, 0, -3};
        int[] expectedSortedArray = new int[]{-125, -3, 0, 1, 6, 15, 15, 25, 34};
        int[] actualSortedArray = SelectionSortUtil.sortFromMinToMax(array);

        assertArrayEquals("Got an unexpectedly sorted array: " + Arrays.toString(actualSortedArray),
                          expectedSortedArray, actualSortedArray);
    }

    @Test
    public void sortEmptyArray() {
        int[] array = new int[]{};
        int[] actualSortedArray = SelectionSortUtil.sortFromMinToMax(array);

        assertArrayEquals("Got an unexpectedly sorted array: " + Arrays.toString(actualSortedArray),
                          array, actualSortedArray);
    }
}
