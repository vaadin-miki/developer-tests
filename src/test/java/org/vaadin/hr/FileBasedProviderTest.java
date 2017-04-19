package org.vaadin.hr;

import org.junit.BeforeClass;
import org.junit.Test;
import org.vaadin.hr.data.Country;
import org.vaadin.hr.data.Person;
import org.vaadin.hr.provider.FileBasedProvider;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Contains tests that must pass.
 * @author miki
 * @since 2017-04-19
 */
public class FileBasedProviderTest {

    private static FileBasedProvider PROVIDER;

    @BeforeClass
    public static void setUp() {
        File file = new File(FileBasedProviderTest.class.getClassLoader().getResource("people.csv").getFile());
        PROVIDER = new FileBasedProvider(file);
    }

    @Test
    public void testReadAll() {
        assertEquals("incorrect number of entries read from the file", 500, PROVIDER.findAll().size());
    }

    @Test
    public void testFindByFirstName() {
        Collection<Person> entries = PROVIDER.search("Russ", null, null, 0);
        assertEquals(10, entries.size());
        List<Person> results = Arrays.asList(
            new Person("Russ", "Wyatt", Country.SLOVENIA, 24),
            new Person("Russ", "York", Country.CROATIA, 37),
            new Person("Russ", "Gross", Country.SWITZERLAND, 39),
            new Person("Russ", "Scott", Country.ARMENIA, 26),
            new Person("Russ", "Stephenson", Country.BOSNIA_AND_HERZEGOVINA, 35),
            new Person("Russ", "Walton", Country.DENMARK, 42),
            new Person("Russ", "Moses", Country.MONACO, 32),
            new Person("Russ", "Harrison", Country.ARMENIA, 38),
            new Person("Russ", "Shea", Country.TURKEY, 25),
            new Person("Russ", "Casey", Country.FRANCE, 22)
        );
        assertTrue("not all expected data are included in the results", entries.containsAll(results));
    }

    @Test
    public void testFindNothingByFirstNameAndEuAndAge() {
        Collection<Person> entries = PROVIDER.search("Russ", null, true, 50);
        assertTrue(entries.isEmpty());
    }

    @Test
    public void testFindByFirstNameAndEuAndAge() {
        Collection<Person> entries = PROVIDER.search("Russ", null, true, 35);
        assertEquals(2, entries.size());
        List<Person> results = Arrays.asList(
            new Person("Russ", "York", Country.CROATIA, 37),
            new Person("Russ", "Walton", Country.DENMARK, 42)
        );
        assertTrue(entries.containsAll(results));
    }

}
