package org.vaadin.hr.time;

/**
 * @author miki
 * @since 2019-02-05
 */
public interface CalendarProvider {
    /**
     * Returns an instance of {@link Calendar}.
     * @return A calendar.
     */
    Calendar getCalendar();
}
