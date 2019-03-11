package org.vaadin.hr.datareader.data;

/**
 * POJO for a person.
 *
 * @author miki
 * @since 2017-04-19
 */
public final class Person {

    private String firstName;
    private String lastName;
    private Country country;
    private int age;

    public Person() {
        // this constructor is here if you prefer using setters instead of constructor parameters
    }

    public Person(String firstName, String lastName, Country country, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%d / %s)", this.getFirstName(), this.getLastName(), this.getAge(), this.getCountry().toString());
    }
}
