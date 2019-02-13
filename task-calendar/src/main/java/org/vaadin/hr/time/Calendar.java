package org.vaadin.hr.time;

import java.time.LocalTime;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

/**
 * A calendar, which is an ordered collection of non-overlapping {@link TimeSlot}s that happen during one day.
 * @author miki
 * @since 2019-02-05
 */
public final class Calendar {

    /**
     * A collection to keep the entries (TimeSlots).
     * The entries are non-overlapping.
     */
    // todo task-? use whatever data structure is suitable
    private final Collection<TimeSlot> slots = null;

    /**
     * Finds the first available time slot that happens not earlier than on the specified time.
     * If there is time left until end of day, then that time should be returned.
     *
     * Assume the calendar has two entries, 7:00-10:00 and 12:00-15:00.
     * When finding the time from 5:00, this method should return 5:00-7:00.
     * When finding the time from 7:00 (or 8:30, or 9:59), this method should return 10:00-12:00.
     * When finding the time from 16:00, this method should return 16:00-24:00.
     *
     * @param from Starting time to look for the available time slot.
     * @return The first available time slot, or an empty optional if there is no available time until end of day.
     * @see TimeSlot#TimeSlot(LocalTime)
     * @see TimeSlot#TimeSlot(LocalTime, LocalTime)
     * @see TimeSlot#isUntilEndOfDay()
     * @see TimeSlot#getStartingTime()
     * @see TimeSlot#getEndingTime()
     */
    public Optional<TimeSlot> findAvailableEntryAtOrAfter(LocalTime from) {
        // todo task-? this probably should do some actual checking for available time
        throw new UnsupportedOperationException("finding available entry is not implemented");
    }

    /**
     * Checks if the specified time slot is available in its entirety - i.e. it does not overlap with anything already existing.
     * @param entry Entry to check.
     * @return Whether or not the specified time slot is available (does not overlap existing entries).
     * @see TimeSlot#contains(LocalTime)
     * @see TimeSlot#overlaps(TimeSlot)
     */
    public boolean isAvailable(TimeSlot entry) {
        // todo task-? this probably should do some actual checking for overlapping
        throw new UnsupportedOperationException("checking for available time is not implemented");
    }

    /**
     * Removes the entry that happens at the provided time, if it was present. Otherwise, does nothing.
     * @param time Time to match time slots for.
     * @return The entry present at the specified time, if any.
     * @see TimeSlot#contains(LocalTime)
     */
    public Optional<TimeSlot> removeEntryAt(LocalTime time) {
        // todo task-? this probably should do some searching for a matching time slot and removing it
        throw new UnsupportedOperationException("removing entries is not implemented");
    }

    /**
     * Adds those entries that do not overlap with any of the already existing entries.
     * After adding all the entries, calling {@link #getSortedEntries()} should return an ordered collection that includes new entries.
     * @param entries Entries to add. They will be processed in the order listed.
     * @return A number of added entries.
     */
    public int addEntry(TimeSlot... entries) {
        int result = 0;
        for(TimeSlot entry: entries) {
            if (this.isAvailable(entry)) {
                this.slots.add(entry);
                result++;
            }
        }
        return result;
    }

    /**
     * Returns a non-modifiable collection of {@link TimeSlot}s.
     * The resulting {@link Collection} should be sorted, starting by the earliest and ending with the latest.
     * {@link TimeSlot} is comparable.
     * @return A collection of sorted entries.
     */
    public Collection<TimeSlot> getSortedEntries() {
        return Collections.unmodifiableCollection(this.slots);
    }


    /**
     * Adds those entries that do not overlap with any of the already existing entries.
     * After adding all the entries, calling {@link #getSortedEntries()} should return an ordered collection that includes new entries.
     * @param entries Entries to add. They will be processed in the order listed.
     * @return A number of added entries.
     */
    public int addEntries(Collection<TimeSlot> entries) {
        return this.addEntry(entries.toArray(new TimeSlot[0]));
    }

}
