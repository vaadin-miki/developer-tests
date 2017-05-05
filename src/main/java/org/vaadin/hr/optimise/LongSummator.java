package org.vaadin.hr.optimise;

/**
 * @author miki
 * @since 2017-05-04
 */
public class LongSummator implements Aggregator<Long> {

    // this is a monostate
    private static final Counter counter = new Counter();

    @Override
    public Long aggregate(Long one, Long two) {
        counter.tick();
        return one+two;
    }

    public static final Counter getCounter() {
        return counter;
    }

}
