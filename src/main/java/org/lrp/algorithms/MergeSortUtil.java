package org.lrp.algorithms;

public class MergeSortUtil {

    public static int[] divideAndMerge(int[] originArray) {
        if (originArray == null) {
            return null;
        }

        if (originArray.length < 2) {
            return originArray;
        }

        int firstArrayLength = originArray.length / 2;
        int[] firstArray = new int[firstArrayLength];
        System.arraycopy(originArray, 0, firstArray, 0, firstArrayLength);

        int secondArrayLength = originArray.length - firstArrayLength;
        int[] secondArray = new int[secondArrayLength];
        System.arraycopy(originArray, firstArrayLength, secondArray, 0, secondArrayLength);

        firstArray = divideAndMerge(firstArray);
        secondArray = divideAndMerge(secondArray);

        return merge(firstArray, secondArray);
    }

    private static int[] merge(int[] firstArray, int[] secondArray) {
        int[] resultArray = new int[firstArray.length + secondArray.length];

        int firstArrayIndex = 0;
        int secondArrayIndex = 0;

        for (int resultArrayIndex = 0; resultArrayIndex < resultArray.length; resultArrayIndex++) {
            if (firstArray.length <= firstArrayIndex) {
                resultArray[resultArrayIndex] = secondArray[secondArrayIndex];
                secondArrayIndex++;
                continue;
            }

            if (secondArray.length <= secondArrayIndex) {
                resultArray[resultArrayIndex] = firstArray[firstArrayIndex];
                firstArrayIndex++;
                continue;
            }

            if (firstArray[firstArrayIndex] < secondArray[secondArrayIndex]) {
                resultArray[resultArrayIndex] = firstArray[firstArrayIndex];
                firstArrayIndex++;
            } else {
                resultArray[resultArrayIndex] = secondArray[secondArrayIndex];
                secondArrayIndex++;
            }
        }
        return resultArray;
    }
}
