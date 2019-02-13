package org.vaadin.hr.time;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.vaadin.hr.time.provider.FileBasedCalendarProvider;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * All the calendar tests.
 * Do not modify this file.
 * @author miki
 * @since 2019-02-05
 */
public class CalendarTest {

    private static FileBasedCalendarProvider PROVIDER;

    private Calendar calendar;

    @BeforeClass
    public static void setUpClass() throws IOException {
        File file;
        try {
            file = new File(CalendarTest.class.getClassLoader().getResource("plan.csv").getFile());
        }
        catch(NullPointerException ex) {
            // if you imported this project as a Java project (not maven), the line above will fail
            // and you will end up in this place
            // please provide an absolute path to [plan.csv] so that everything works fine

            // and of course comment out the exception in the line below:
            throw new IllegalArgumentException("cannot load the resource file (is project imported as a Maven project?) - please supply direct path to the file");

            // and uncomment the following line:
            // file = new File("replace/this/with/a/direct/path/to/src/main/resources/plan.csv");
        }

        PROVIDER = new FileBasedCalendarProvider();
        PROVIDER.read(file);
    }

    @Before
    public void setUp() {
        this.calendar = PROVIDER.getCalendar();
    }

    /**
     * Checks whether the given list is ordered properly.
     * @param entries Entries.
     * @return {@code false} when there is any entry that has an ending time that happens after the starting time of the next entry, otherwise {@code true}.
     */
    private static boolean isOrdered(Collection<TimeSlot> entries) {
        List<TimeSlot> sorted = entries.stream().sorted().collect(Collectors.toList());
        List<TimeSlot> asIs = new ArrayList<>(entries);
        return sorted.equals(asIs);
    }

    @Test
    public void testSortedAddingAndRemoving() {
        // initial entries
        Collection<TimeSlot> entries = this.calendar.getSortedEntries();
        int initialSize = entries.size();
        Assert.assertEquals("not all entries were read", 15, initialSize);
        // check whether the list is ordered properly
        Assert.assertTrue("the list of entries is not ordered properly initially", isOrdered(entries));
        // add entry
        TimeSlot slot = new TimeSlot(LocalTime.of(18,0), 15, "second afternoon coffee");
        Assert.assertEquals("the entry should have been added properly", 1, this.calendar.addEntry(slot));
        entries = this.calendar.getSortedEntries();
        Assert.assertEquals("there should be now 16 entries", initialSize+1, entries.size());
        // and they should be ordered
        Assert.assertTrue("the list of entries is not ordered properly after adding", isOrdered(entries));
        // now removing the entry
        Optional<TimeSlot> perhapsSlot = this.calendar.removeEntryAt(LocalTime.of(18,0));
        Assert.assertTrue("there should be a proper entry at 18:00, it was just added", perhapsSlot.isPresent());
        entries = this.calendar.getSortedEntries();
        Assert.assertEquals("there should be now 15 entries again", initialSize, entries.size());
        // and they should be ordered
        Assert.assertTrue("the list of entries is not ordered properly after removing", isOrdered(entries));
    }

    @Test
    public void testNothingToRemove() {
        Optional<TimeSlot> perhapsSlot = this.calendar.removeEntryAt(LocalTime.of(12, 52));
        Assert.assertFalse("there should be no entry removed at 12:52", perhapsSlot.isPresent());
        perhapsSlot = this.calendar.removeEntryAt(LocalTime.of(12, 50));
        Assert.assertFalse("there should be no entry removed at 12:50 (even though an event ends at that time)", perhapsSlot.isPresent());
    }

    @Test
    public void testFindingAvailableSlotAfter() {
        Optional<TimeSlot> perhapsSlot = this.calendar.findAvailableEntryAtOrAfter(LocalTime.of(8, 0, 0));
        Assert.assertTrue("there should be available free time from 8 o'clock onwards", perhapsSlot.isPresent());
        TimeSlot slot = perhapsSlot.get();
        TimeSlot expected = new TimeSlot(LocalTime.of(8,15), 5);
        Assert.assertEquals("free time should be 8:15-8:20", expected, slot);
    }

    @Test
    public void testFindingAvailableSlotAt() {
        Optional<TimeSlot> perhapsSlot = this.calendar.findAvailableEntryAtOrAfter(LocalTime.of(12, 30, 0));
        Assert.assertTrue("there should be available free time precisely at 12:30", perhapsSlot.isPresent());
        TimeSlot slot = perhapsSlot.get();
        TimeSlot expected = new TimeSlot(LocalTime.of(12,30), 15);
        Assert.assertEquals("free time should be 12:30-12:45", expected, slot);
    }

    @Test
    public void testFindingNoAvailableSlot() {
        // check availability
        Optional<TimeSlot> perhapsSlot = this.calendar.findAvailableEntryAtOrAfter(LocalTime.of(23, 5, 0));
        Assert.assertTrue("there should be available free time at 23:55 to end of day", perhapsSlot.isPresent());
        TimeSlot slot = perhapsSlot.get();
        TimeSlot expected = new TimeSlot(LocalTime.of(23,55));
        Assert.assertEquals("free time at end of day should be 23:55-0:00", expected, slot);

        // add time that was found, now there should be no free time
        this.calendar.addEntry(slot);
        perhapsSlot = this.calendar.findAvailableEntryAtOrAfter(LocalTime.of(23,5));
        Assert.assertFalse("now there should be no available free time from 23:05 until end of day", perhapsSlot.isPresent());
        this.calendar.removeEntryAt(slot.getStartingTime());

        // check again after removing that the time slot is still there
        perhapsSlot = this.calendar.findAvailableEntryAtOrAfter(LocalTime.of(23, 5, 0));
        Assert.assertTrue("there should again be available free time at 23:55 to end of day", perhapsSlot.isPresent());
        slot = perhapsSlot.get();
        expected = new TimeSlot(LocalTime.of(23,55));
        Assert.assertEquals("free time at end of day should not change and be 23:55-0:00", expected, slot);
    }

    @Test
    public void testCheckingAvailability() {
        Assert.assertFalse("8:55 to 9:00 should not be available", this.calendar.isAvailable(new TimeSlot(LocalTime.of(8,55), 5)));
        Assert.assertFalse("8:50 to 9:00 should not be available", this.calendar.isAvailable(new TimeSlot(LocalTime.of(8,50), 10)));
        Assert.assertFalse("8:55 to 9:10 should not be available", this.calendar.isAvailable(new TimeSlot(LocalTime.of(8,55), 15)));
        Assert.assertFalse("8:50 to 9:10 should not be available", this.calendar.isAvailable(new TimeSlot(LocalTime.of(8,50), 20)));
        Assert.assertTrue("9:00 to 9:30 should be available", this.calendar.isAvailable(new TimeSlot(LocalTime.of(9,0), 30)));
        Assert.assertTrue("9:15 to 9:30 should be available", this.calendar.isAvailable(new TimeSlot(LocalTime.of(9,15), 15)));
        Assert.assertTrue("9:00 to 9:20 should be available", this.calendar.isAvailable(new TimeSlot(LocalTime.of(9,0), 20)));
        Assert.assertTrue("9:15 to 9:20 should be available", this.calendar.isAvailable(new TimeSlot(LocalTime.of(9,15), 5)));
    }
}