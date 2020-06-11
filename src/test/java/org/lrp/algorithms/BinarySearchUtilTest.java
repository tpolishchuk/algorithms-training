package org.lrp.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchUtilTest {

    @Test
    public void findElementPositionInMiddleOfArray() {
        int[] array = new int[]{1, 6, 14, 24, 95, 132, 999};
        int expectedElement = 24;

        assertEquals("Got an unexpected element position",
                     3, BinarySearchUtil.findElementPositionInArray(array, expectedElement));
    }

    @Test
    public void findElementPositionInFirstHalfOfArray() {
        int[] array = new int[]{1, 6, 14, 24, 95, 132, 999};
        int expectedElement = 6;

        assertEquals("Got an unexpected element position",
                     1, BinarySearchUtil.findElementPositionInArray(array, expectedElement));
    }

    @Test
    public void findElementPositionInSecondHalfOfArray() {
        int[] array = new int[]{1, 6, 14, 24, 132, 999};
        int expectedElement = 132;

        assertEquals("Got an unexpected element position",
                     4, BinarySearchUtil.findElementPositionInArray(array, expectedElement));
    }

    @Test
    public void findFirstElementPosition() {
        int[] array = new int[]{1, 6, 14, 24, 95, 132, 999};
        int expectedElement = 1;

        assertEquals("Got an unexpected element position",
                     0, BinarySearchUtil.findElementPositionInArray(array, expectedElement));
    }

    @Test
    public void findLastElementPosition() {
        int[] array = new int[]{1, 6, 14, 24, 95, 132, 999};
        int expectedElement = 999;

        assertEquals("Got an unexpected element position",
                     6, BinarySearchUtil.findElementPositionInArray(array, expectedElement));
    }

    @Test
    public void findNonexistentElementPosition() {
        int[] array = new int[]{1, 6, 14, 24, 95, 132, 999};
        int expectedElement = 345;

        assertEquals("Got an unexpected element position",
                     -1, BinarySearchUtil.findElementPositionInArray(array, expectedElement));
    }

    @Test
    public void findNonexistentElementPositionEmptyArray() {
        int[] array = new int[]{};
        int expectedElement = 1;

        assertEquals("Got an unexpected element position",
                     -1, BinarySearchUtil.findElementPositionInArray(array, expectedElement));
    }
}
