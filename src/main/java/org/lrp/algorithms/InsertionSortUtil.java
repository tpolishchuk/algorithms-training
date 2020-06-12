package org.lrp.algorithms;

public class InsertionSortUtil {

    public static int[] sortFromMinToMax(int[] array) {
        if (array.length < 2) {
            return array;
        }

        for (int originIndex = 1; originIndex < array.length; originIndex++) {

            int currentIndex = originIndex;
            int referenceElementIndex = originIndex-1;

            while(array[currentIndex] < array[referenceElementIndex]) {
                swap(array, currentIndex, referenceElementIndex);
                referenceElementIndex--;
                currentIndex--;

                if(referenceElementIndex == -1) {
                    break;
                }
            }
        }

        return array;
    }

    private static void swap(int[] array, int index1, int index2) {
        int buffer = array[index1];
        array[index1] = array[index2];
        array[index2] = buffer;
    }
}
