package org.vaadin.miki.hr.calculator;

/**
 * Calculator interface. Instances should be stateless.
 *
 * Do not modify this file.
 *
 * @author miki
 * @since 2019-01-30
 */
@FunctionalInterface
public interface Calculator {

    /**
     * Calculates the result of the input: {@code number operation number}.
     *
     * Number is a positive decimal integer.
     *
     * Operation is: {@code + - *} for addition, subtraction and multiplication, respectively; {@code /} for integer division,
     * and {@code %} for integer division remainder. Any whitespace around operation is optional.
     *
     * @param input Input string.
     *
     * @return Result of the computation.
     *
     * @throws IllegalArgumentException when the input cannot be parsed or calculated for any reason.
     */
    long calculate(String input);

}
