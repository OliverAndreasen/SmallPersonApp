package com.company;

import java.io.IOException;

public class App {
    private final Database db = new Database();

    public App() throws IOException {
        db.loadPersons();
    }

    public String personsToString() {
        return db.personsToString();
    }

    public void removePerson(Person person) throws IOException {
        db.removePerson(person);
    }

    public Person findPersonByIndex(int num) {
        return db.findPersonByIndex(num);
    }

    public void addPerson(String firstName, String lastName) throws IOException {
        Person person = new Person(firstName, lastName);
        db.addPerson(person);
    }
}
