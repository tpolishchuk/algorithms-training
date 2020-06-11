package org.lrp.algorithms;

import java.util.Arrays;

public class QuickSortUtil {

    public static int[] sortFromMinToMax(int[] array) {
        return sortFromMinToMax(array, 0, array.length - 1);
    }

    public static int[] sortFromMinToMax(int[] array, int originLeftPointer, int originRightPointer) {
        if (array.length < 2 ||
            originLeftPointer == originRightPointer) {
            return array;
        }

        if (originLeftPointer >= originRightPointer) {
            return array;
        }

        //Because otherwise light and left pointers won't move
        if ((originRightPointer - originLeftPointer) == 1 &&
            array[originLeftPointer] <= array[originRightPointer]) {
            return array;
        }

        int pivotIndex = originLeftPointer + (originRightPointer - originLeftPointer) / 2;
        int pivot = array[pivotIndex];

        int leftPointer = originLeftPointer;
        int rightPointer = originRightPointer;

        while (leftPointer < rightPointer) {

            while(array[leftPointer] < pivot) {
                leftPointer++;
            }

            while(array[rightPointer] > pivot) {
                rightPointer--;
            }

            if(leftPointer < rightPointer) {
                swap(array, leftPointer, rightPointer);
                leftPointer++;
                rightPointer--;
            }

            if (leftPointer == rightPointer) {
                break;
            }
        }

        if (rightPointer > originLeftPointer) {
            sortFromMinToMax(array, originLeftPointer, rightPointer);
        }

        if (leftPointer < originRightPointer) {
            sortFromMinToMax(array, leftPointer, originRightPointer);
        }
        return array;
    }

    private static void swap(int[] array, int leftPointer, int rightPointer) {
        int buffer = array[leftPointer];
        array[leftPointer] = array[rightPointer];
        array[rightPointer] = buffer;
    }
}
