package org.vaadin.hr.time;

import java.time.LocalTime;
import java.util.Optional;

/**
 * Basic information about a time slot.
 * It has a starting time (that belongs to the slot)
 * and ending time (that does not belong to the slot)
 * and a description (purely informative, no real meaning).
 * Do not modify this file.
 * @author miki
 * @since 2019-02-05
 */
public final class TimeSlot {

    private final LocalTime startingTime;
    private final LocalTime endingTime;
    private String description;

    /**
     * Creates the time slot from given parameters.
     * @param startingTime Starting time (included in the time slot).
     * @param endingTime Ending time (not included in the time slot).
     * @param description Description (for informative purposes only; can be {@code null}).
     * @throws IllegalArgumentException when the ending time is not after the starting time
     */
    public TimeSlot(LocalTime startingTime, LocalTime endingTime, String description) {
        if(!endingTime.isAfter(startingTime))
            throw new IllegalArgumentException("starting time must be before ending time");

        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.description = description;
    }

    /**
     * Creates the time slot from given parameters, without a description.
     * @param startingTime Starting time (included in the time slot).
     * @param endingTime Ending time (not included in the time slot).
     */
    public TimeSlot(LocalTime startingTime, LocalTime endingTime) {
        this(startingTime, endingTime, null);
    }

    public LocalTime getStartingTime() {
        return startingTime;
    }

    public LocalTime getEndingTime() {
        return endingTime;
    }

    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
