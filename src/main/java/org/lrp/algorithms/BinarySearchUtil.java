package org.lrp.algorithms;

import java.util.logging.Logger;

/**
 * Binary Search: https://www.khanacademy.org/computing/computer-science/algorithms/binary-search/a/binary-search
 */
public class BinarySearchUtil {

    public static int findElementPositionInArray(int[] array, int targetElement) {
        int minPosition = 0;
        int maxPosition = array.length - 1;

        while (minPosition <= maxPosition) {
            int middlePosition = (minPosition + maxPosition) / 2;

            int middleElement = array[middlePosition];

            if (middleElement == targetElement) {
                return middlePosition;
            }

            if (middleElement > targetElement) {
                maxPosition = middlePosition - 1;
                continue;
            }

            if(middleElement < targetElement) {
                minPosition = middlePosition + 1;
                continue;
            }
        }

        return -1;
    }
}
