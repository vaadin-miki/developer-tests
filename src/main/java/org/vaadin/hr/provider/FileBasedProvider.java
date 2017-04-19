package org.vaadin.hr.provider;

import org.vaadin.hr.data.Person;

import java.io.File;
import java.util.Collection;

/**
 * Provides data based on a file.
 * @author miki
 * @since 2017-04-19
 */
public class FileBasedProvider {

    /**
     * Constructs the provider.
     * @param file File to get data from, in CSV format (firstName, lastName, country, age)
     */
    public FileBasedProvider(File file) {
        // todo implement this
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Returns all data read from the file.
     * @return An array of people data.
     */
    public Collection<Person> findAll() {
        throw new UnsupportedOperationException("not supported");
    }

    /**
     * Searches people by given criteria.
     * @param firstName If not {@code null}, only people with given first name.
     * @param lastName If not {@code null}, only people with given last name.
     * @param eu If not {@code null}, only people with country either from EU ({@code true}) or not ({@code false}).
     * @param age If a positive number, only people with that age OR older.
     * @return A list of people matching the criteria.
     */
    public Collection<Person> search(String firstName, String lastName, Boolean eu, int age) {
        throw new UnsupportedOperationException("not supported");
    }

}
