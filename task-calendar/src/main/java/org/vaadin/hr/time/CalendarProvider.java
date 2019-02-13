package org.vaadin.hr.time;

/**
 * A marker interface for anything that can provide a {@link Calendar}.
 *
 * Do not modify this file.
 *
 * @author miki
 * @since 2019-02-05
 */
@FunctionalInterface
public interface CalendarProvider {
    /**
     * Returns an instance of {@link Calendar}.
     * @return A calendar.
     */
    Calendar getCalendar();
}
