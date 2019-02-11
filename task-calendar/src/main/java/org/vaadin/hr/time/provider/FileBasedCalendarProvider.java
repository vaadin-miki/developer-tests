package org.vaadin.hr.time.provider;

import org.vaadin.hr.time.Calendar;
import org.vaadin.hr.time.CalendarProvider;

import java.io.File;

/**
 * Provides {@link Calendar}s.
 * @author miki
 * @since 2019-02-05
 */
public final class FileBasedCalendarProvider implements CalendarProvider {

    private Calendar calendar;

    /**
     * Reads the contents of the provided file.
     * @param file A CSV file without a header line. Format is: starting time (HH:MM in 24-hour format), duration (in minutes), description.
     */
    public void read(File file) {
        // todo task-1 implement this to read contents from the provided file, according to the documentation
        // see: Calendar.addEntry
        throw new UnsupportedOperationException("creating calendar from file is not implemented");
    }

    @Override
    public Calendar getCalendar() {
        return this.calendar;
    }

}
