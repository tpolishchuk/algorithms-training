package org.lrp.algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FactorialUtilTest {

    @Test
    public void calculatePositiveFactorial() {
        assertEquals("Got an unexpected factorial",
                     24, FactorialUtil.calculateFactorial(4));
    }

    @Test
    public void calculateZeroFactorial() {
        assertEquals("Got an unexpected factorial",
                     1, FactorialUtil.calculateFactorial(1));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void calculateNegativeFactorial() {
        FactorialUtil.calculateFactorial(-1);
    }
}
