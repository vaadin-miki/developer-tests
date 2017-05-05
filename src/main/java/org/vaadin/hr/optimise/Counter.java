package org.vaadin.hr.optimise;

import java.util.Objects;

/**
 * Counter. Counts ticks.
 *
 * @author miki
 * @since 2017-05-04
 */
public final class Counter {

    private long ticks = 0;

    public final long tick() {
        return ticks++;
    }

    public final long getTicks() {
        return ticks;
    }

    public final long reset() {
        long ticks = this.getTicks();
        this.ticks = 0;
        return ticks;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Counter && ((Counter) obj).getTicks() == this.getTicks();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getTicks())*31;
    }
}
