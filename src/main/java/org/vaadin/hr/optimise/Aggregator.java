package org.vaadin.hr.optimise;

/**
 * @author miki
 * @since 2017-05-04
 */
public interface Aggregator<N extends Number> {

    N aggregate(N one, N two);

}
