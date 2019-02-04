package org.vaadin.miki.hr.calculator;

/**
 * Provides an instance of a {@link Calculator}.
 * @author miki
 * @since 2019-01-30
 */
class CalculatorProvider {

    private CalculatorProvider() {
        // cannot be created
    }

    /**
     * Provides a stateless instance of a calculator.
     * @return An instance of a {@link Calculator}.
     */
    static Calculator getCalculator() {
        // TODO task-1 get rid of this exception and construct a proper calculator
        throw new IllegalStateException("not implemented");
    }

}
