package org.vaadin.hr.time;

import java.time.LocalTime;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

/**
 * A simple calendar that consists {@link TimeSlot}s ordered from earliest to latest.
 * @author miki
 * @since 2019-02-05
 */
public final class SimpleCalendar implements Calendar {

    /**
     * Stores the entries.
     */
    private final Collection<TimeSlot> slots = null;

    /**
     * Creates the calendar from specified slots. All of them are added.
     * @param slots Slots to add.
     */
    public SimpleCalendar(TimeSlot... slots) {
        for(TimeSlot slot: slots)
            this.addEntry(slot);
    }

    @Override
    public Optional<TimeSlot> findAvailable(LocalTime from) {
        // todo task-? this probably should do some actual checking for available time
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public boolean isAvailable(TimeSlot entry) {
        // todo task-? this probably should do some actual checking for overlapping
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public Optional<TimeSlot> removeEntryAt(LocalTime time) {
        // todo task-? this probably should do some searching for a matching time slot and removing it
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public boolean addEntry(TimeSlot entry) {
        boolean result = this.isAvailable(entry);
        if(result)
            this.slots.add(entry);
        return result;
    }

    @Override
    public Collection<TimeSlot> getEntries() {
        return Collections.unmodifiableCollection(this.slots);
    }

}
