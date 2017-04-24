package org.vaadin.hr.provider.file;

import org.vaadin.hr.data.Person;
import org.vaadin.hr.data.Country;
import org.vaadin.hr.provider.PersonDataProvider;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

/**
 * Provides data based on a file.
 *
 * This file contains tasks to implement.
 *
 * @author miki
 * @since 2017-04-19
 * @see PersonDataProvider
 */
public class FileBasedProvider implements PersonDataProvider {

    /**
     * Reads the contents of the file.
     * @param file
     *          File to get data from, in CSV format ({@code firstName,lastName,country,age}).<br/>
     *          Assume that the data is correct.<br/>
     *          The file contains one data per line (unix line endings). The first line is a header line.<br/>
     *          First name and last name are Strings that contain letters a-z and start with a capital letter.<br/>
     *          Country is all UPPER CASE and matches the enum name in the Country class.<br/>
     *          Age is a positive integer.
     * @throws IOException when reading the file fails for any reason.
     * @see Person a POJO that corresponds to an entry in the file
     * @see Country an enum with defined countries
     */
    public void read(File file) throws IOException {
        // todo task-1: read contents of the given file
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public Collection<Person> findAll() {
        // todo task-2: return all data read from the file
        throw new UnsupportedOperationException("not supported");
    }

    @Override
    public Collection<Person> search(String firstName, String lastName, Boolean eu, int age) {
        // todo task-3: implement the searching as described in this method's javadoc
        throw new UnsupportedOperationException("not supported");
    }

}
