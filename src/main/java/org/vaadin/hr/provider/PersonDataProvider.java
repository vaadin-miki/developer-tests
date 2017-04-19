package org.vaadin.hr.provider;

import org.vaadin.hr.data.Person;

import java.util.Collection;

/**
 * Interface for objects that provide information about people.<br/>
 * Do not modify this file.
 * @author miki
 * @since 2017-04-19
 */
public interface PersonDataProvider {
    /**
     * Returns all data read from the file.
     *
     * @return
     * A collection of all people data.
     */
    Collection<Person> findAll();

    /**
     * Searches people by given criteria. All given criteria must match ({@code AND} search).
     *
     * @param firstName
     *              If not {@code null}, only people with given first name.
     * @param lastName
     *              If not {@code null}, only people with given last name.
     * @param eu
     *              If not {@code null}, only people with country either from EU ({@code true}) or not ({@code false}).
     * @param age
     *              If a positive number, only people with that age or older.
     * @return
     *              A collection of people data matching the criteria.
     */
    Collection<Person> search(String firstName, String lastName, Boolean eu, int age);
}
