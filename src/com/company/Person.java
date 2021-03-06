package com.company;

public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return "Firstname: " + firstName + "\n" + "Lastname: " + lastName + "\n";
    }

    @Override
    public int compareTo(Person other) {
        return this.firstName.compareTo(other.firstName);
    }
}
