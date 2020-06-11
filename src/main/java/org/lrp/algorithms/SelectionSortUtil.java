package org.lrp.algorithms;

import org.apache.commons.lang3.ArrayUtils;

public class SelectionSortUtil {

    public static int[] sortFromMinToMax(int[] array) {
        int[] sortedArray = new int[array.length];

        for (int i = 0; i < sortedArray.length; i++) {
            int minElementIndex = findMinElementIndex(array);
            sortedArray[i] = array[minElementIndex];

            array = ArrayUtils.remove(array, minElementIndex);
        }

        return sortedArray;
    }

    private static int findMinElementIndex(int[] array) {
        int minElementIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < array[minElementIndex]) {
                minElementIndex = i;
            }
        }

        return minElementIndex;
    }

}
