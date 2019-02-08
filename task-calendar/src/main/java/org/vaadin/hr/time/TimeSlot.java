package org.vaadin.hr.time;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
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
    private final long duration;
    private String description;

    /**
     * Creates the time slot from given parameters.
     * @param startingTime Starting time (included in the time slot).
     * @param duration Duration (in minutes).
     * @param description Description (for informative purposes only; can be {@code null}).
     * @throws IllegalArgumentException when the ending time is not after the starting time
     */
    public TimeSlot(LocalTime startingTime, long duration, String description) {
        if(duration <= 0)
            throw new IllegalArgumentException("duration must be a positive number");

        this.startingTime = startingTime;
        this.duration = duration;
        this.endingTime = startingTime.plus(duration, ChronoUnit.MINUTES);
        this.description = description;
    }

    /**
     * Creates the time slot from given parameters, without a description.
     * @param startingTime Starting time (included in the time slot).
     * @param duration Duration (in minutes).
     */
    public TimeSlot(LocalTime startingTime, long duration) {
        this(startingTime, duration, null);
    }

    /**
     * Creates the time slot from given parameters, without a description.
     * @param startingTime Starting time (included in the time slot).
     * @param duration Duration (in minutes).
     */
    public TimeSlot(LocalTime startingTime, int duration) {
        this(startingTime, duration, null);
    }

    /**
     * Creates the time slot from given parameters, without a description.
     * @param startingTime Starting time.
     * @param endingTime Ending time (not included in the slot).
     */
    public TimeSlot(LocalTime startingTime, LocalTime endingTime) {
        this(startingTime, ChronoUnit.MINUTES.between(startingTime, endingTime));
    }

    public LocalTime getStartingTime() {
        return startingTime;
    }

    public LocalTime getEndingTime() {
        return endingTime;
    }

    public long getDuration() {
        return duration;
    }

    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d - %02d:%02d", this.getStartingTime().getHour(), this.getStartingTime().getMinute(), this.getEndingTime().getHour(), this.getEndingTime().getMinute());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getStartingTime(), this.getEndingTime());
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof TimeSlot && (this.getStartingTime().equals(((TimeSlot) obj).getStartingTime()))
            && this.getDuration() == ((TimeSlot) obj).getDuration();
    }
}
