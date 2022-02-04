package Uppgift1;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Person> personList = List.of(
                new Person("Haris", "Male", 25_000),
                new Person("Karl", "Male", 35_000),
                new Person("Filip", "Male", 27_500),
                new Person("Albin", "Male", 30_000),
                new Person("Oliver", "Male", 29_000),
                new Person("Linda", "Female", 20_000),
                new Person("Olivia", "Female", 22_500),
                new Person("Johanna", "Female", 31_500),
                new Person("Sofia", "Female", 23_500),
                new Person("Daniella", "Female", 31_000)
        );

        System.out.println("Snittlönen för män: " +
                personList
                        .stream()
                        .filter(gender->gender.getGender().equals("Male"))
                        .mapToDouble(Person::getSalary)
                        .summaryStatistics()
                        .getAverage()
        );
        System.out.println("----");

        System.out.println("Snittlönen för kvinnor: " +
                personList
                        .stream()
                        .filter(gender->gender.getGender().equals("Female"))
                        .mapToDouble(Person::getSalary)
                        .summaryStatistics()
                        .getAverage()
        );
        System.out.println("----");

        System.out.println("Högsta lönen: " +
                personList
                        .stream()
                        .mapToDouble(Person::getSalary)
                        .summaryStatistics()
                        .getMax()
        );
        System.out.println("----");

        System.out.println("Lägsta lönen: " +
                personList
                        .stream()
                        .mapToDouble(Person::getSalary)
                        .summaryStatistics()
                        .getMin()
        );
        System.out.println("----");

    }
}
