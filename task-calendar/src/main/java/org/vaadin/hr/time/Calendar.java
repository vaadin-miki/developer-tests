package org.vaadin.hr.time;

import java.time.LocalTime;
import java.util.Collection;
import java.util.Optional;

/**
 * An interface for {@link TimeSlot}s (ordered from earliest to latest).
 * Do not modify this file.
 * @author miki
 * @since 2019-02-05
 */
public interface Calendar {

    /**
     * Finds the first available time slot that happens not earlier than on the specified time.
     * @param from Starting time to look for the available time slot.
     * @return The first available time slot, or an empty optional if there is no available time until end of day.
     */
    Optional<TimeSlot> findAvailable(LocalTime from);

    /**
     * Adds the entry, if it is not overlapping with any of the already existing entries.
     * @param entry Entry to add.
     * @return Whether or not the entry has been added.
     */
    boolean addEntry(TimeSlot entry);

    /**
     * Removes the entry that happens at the provided time, if it was present. Otherwise, does nothing.
     * @param time Time to match time slots for.
     * @return The entry present at the specified time, if any.
     */
    Optional<TimeSlot> removeEntryAt(LocalTime time);

    /**
     * Checks if the specified time slot is available in its entirety - i.e. it does not overlap with anything already existing.
     * @param entry Entry to check.
     * @return Whether or not the specified time slot is available (does not overlap existing entries).
     */
    boolean isAvailable(TimeSlot entry);

    /**
     * Returns a non-modifiable collection of {@link TimeSlot}s. The resulting {@link Collection} should be sorted, starting by the earliest and ending with the latest.
     * @return A collection of sorted entries.
     */
    Collection<TimeSlot> getEntries();

}
