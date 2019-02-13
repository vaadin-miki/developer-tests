package org.vaadin.hr.time.provider;

import org.vaadin.hr.time.Calendar;
import org.vaadin.hr.time.CalendarProvider;
import org.vaadin.hr.time.TimeSlot;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

/**
 * Provides {@link Calendar}s.
 * @author miki
 * @since 2019-02-05
 */
public final class FileBasedCalendarProvider implements CalendarProvider {

    private Collection<TimeSlot> timeSlots;

    /**
     * Reads time slots from the provided file. The entries in the file are not ordered.
     * @param file A CSV file without a header line. Format is: starting time (HH:mm in 24-hour format), duration (in minutes), description (does not contain comma ({@code ,})).
     * @return A collection of {@link TimeSlot}s that correspond to the entries in the file.
     */
    private Collection<TimeSlot> readTimeSlotsFromFile(File file) throws IOException {
        // todo task-1 implement this to read contents from the provided file, according to the documentation
        throw new UnsupportedOperationException("creating calendar from file is not implemented");
    }

    public void read(File file) {
        try {
            this.timeSlots = this.readTimeSlotsFromFile(file);
        }
        catch(IOException ioe) {
            throw new IllegalArgumentException(String.format("cannot read from file [%s]", file.getAbsolutePath()));
        }
    }

    @Override
    public Calendar getCalendar() {
        Calendar calendar = new Calendar();
        calendar.addEntries(this.timeSlots);
        return calendar;
    }

}
