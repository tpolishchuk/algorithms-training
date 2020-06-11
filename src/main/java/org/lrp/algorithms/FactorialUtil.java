package org.lrp.algorithms;

public class FactorialUtil {

    public static long calculateFactorial(int value) {
        if (value < 0) {
            throw new UnsupportedOperationException("Cannot calculate factorial for " + value);
        }

        if(value == 0 || value == 1) {
            return 1;
        }

        return value * calculateFactorial(value - 1);
    }
}
