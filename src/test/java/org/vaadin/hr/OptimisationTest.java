package org.vaadin.hr;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.vaadin.hr.optimise.LongSummator;
import org.vaadin.hr.optimise.PascalNumberCalculator;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests for optimisation of redundant operations.
 *
 * @author miki
 * @since 2017-05-04
 */
public class OptimisationTest {

    private PascalNumberCalculator calculator;

    @Before
    public void setUp() {
        // reset the counter and make new calculator
        LongSummator.getCounter().reset();
        this.calculator = new PascalNumberCalculator();
    }

    @Test
    public void testSingleNumber() {
        long number = calculator.getNumber(9, 3);
        assertEquals("incorrect calculation", 84, number);
        assertTrue(String.format("too many operations - %d", LongSummator.getCounter().getTicks()), LongSummator.getCounter().getTicks() < 25);
    }

    @Test
    public void testSingleRow() {
        long[] row = calculator.getRow(5);
        assertArrayEquals("incorrect data", new long[]{1, 5, 10, 10, 5, 1}, row);
        assertTrue(String.format("too many operations - %d", LongSummator.getCounter().getTicks()), LongSummator.getCounter().getTicks() <= 15);
    }

    @Test
    public void testTwoRows() {
        long[] low = calculator.getRow(8);
        long ticksLow = LongSummator.getCounter().getTicks();
        long[] hi = calculator.getRow(3);
        long ticksHi = LongSummator.getCounter().getTicks();
        assertEquals("getting an already calculated row should not require extra computation", ticksLow, ticksHi);
    }

    /**
     * Runs the tests as a java app.
     * This method should be used if your IDE does not have support for Maven or JUnit.
     *
     * @param args
     *          Command line arguments. Ignored.
     */
    public static final void main(String[] args) {
        JUnitCore.main("org.vaadin.hr.OptimisationTest");
    }

}
