package com.company;

import java.io.IOException;
import java.util.Scanner;

public class UserInterface {

    public void start() throws IOException {

        boolean isRunning = true;
        App app = new App();
        Scanner sc = new Scanner(System.in);
        while (isRunning) {

            System.out.println("""
                    0 for at afslutte programmet
                    1 for at tilføje bruger
                    2 for at slette bruger
                    3 for at se listen af alle brugere
                    """);
            int input = sc.nextInt();

            switch (input) {
                case 0 -> isRunning = false;
                case 1 -> {
                    System.out.println("Indtast fornavn");
                    String firstName = sc.next();
                    System.out.println("Indtast efternavn");
                    String lastName = sc.next();
                    app.addPerson(firstName, lastName);
                }
                case 2 -> {
                    System.out.println("Hvilken person vil du fjerne");
                    input = sc.nextInt();
                    Person person = app.findPersonByIndex(input);
                    app.removePerson(person);
                }
                case 3 -> System.out.println(app.personsToString());
                default -> System.out.println("Forkert input");
            }
        }
    }


}

