package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Database {
    private final File FILE = new File("data/persons.txt");
    private final Scanner sc = new Scanner(FILE);
    private final ArrayList<Person> persons = new ArrayList<>();

    public Database() throws FileNotFoundException {
        sc.useDelimiter(";");
    }

    public void loadPersons() throws IOException {
        while (sc.hasNextLine()) {
            String firstName = sc.next();
            String lastName = sc.next();
            Person person = new Person(firstName, lastName);
            addPerson(person);
            sc.nextLine();
        }
    }

    public void addPerson(Person person) throws IOException {
        persons.add(person);
        updateDB();
    }

    public int size() {
        return persons.size();
    }

    public void removePerson(Person person) throws IOException {
        persons.remove(person);
        updateDB();
    }

    public String personsToString() {
        Collections.sort(persons);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < persons.size(); i++) {
            result.append("Person ").append(persons.indexOf(persons.get(i))).append(":\n");
            result.append(persons.get(i).toString());
        }

        return result.toString();
    }

    public Person findPersonByIndex(int num) {
        for (int i = 0; i < size(); i++) {
            if (persons.indexOf(persons.get(i)) == num) {
                return persons.get(i);
            }
        }
        return null;
    }

    public void updateDB() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE));
        for (int i = 0; i < persons.size(); i++) {
            String result = "";
            result += persons.get(i).getFirstName();
            result += ";";
            result += persons.get(i).getLastName();
            result += ";";
            writer.write(result);
            writer.newLine();
        }
        writer.close();
    }
}
