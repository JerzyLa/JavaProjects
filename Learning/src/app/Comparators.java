package app;

import java.util.Arrays;
import java.util.Comparator;

import static java.util.Comparator.naturalOrder;

public class Comparators implements Runnable {
    @Override
    public void run() {
        Person[] persons = {
            new Person("Zenon", null, "Malkovic"),
            new Person("Abelart", null, "Giza"),
            new Person("Adam", "Edward", "Rabenda"),
            new Person("Marcin", null, "Rabenda"),
            new Person("Jerzy", "Stanislaw", "Lasyk"),
        };

        System.out.println(Arrays.toString(persons));

        System.out.println("\n*** After sort by name ***\n");
        Arrays.sort(persons, Comparator.comparing(Person::getName));
        System.out.println(Arrays.toString(persons));

        System.out.println("\n*** After sort by last name and first name ***\n");
        Arrays.sort(persons, Comparator.comparing(Person::getLastName).thenComparing(Person::getName));
        System.out.println(Arrays.toString(persons));

        System.out.println("\n*** After sort by name length ***\n");
        Arrays.sort(persons, Comparator.comparingInt(p -> p.getName().length()));
        System.out.println(Arrays.toString(persons));

        System.out.println("\n*** After sort by middle name null first ***\n");
        Arrays.sort(persons, Comparator.comparing(Person::getMiddleName, Comparator.nullsFirst(naturalOrder())));
        System.out.println(Arrays.toString(persons));
    }
}

class Person {
    public Person(String name, String middleName, String lastName) {
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("name: %s, middleName: %s, lastName: %s\n", name, middleName, lastName);
    }

    String name;
    String middleName;
    String lastName;
}
