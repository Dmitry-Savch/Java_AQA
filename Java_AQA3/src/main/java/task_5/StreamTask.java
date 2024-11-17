package task_5;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Stream:
a) Generate 10 random objects using a class from a previous task
b) Sort it using any two fields using stream.
c) Filter it by any two fields custom filter.
d) Collect it to List with *main field(s).
*/

public class StreamTask {
    public static void main(String[] args) {

        int n = 10;
        Random random = new Random();
        if (args.length > 0) {
            n = Integer.parseInt(args[0]);
        }

        List<Person> inputList = IntStream.range(0, n).mapToObj(i -> {
            Person person = new Person();
            person.setName("Person_" + (i + 1));
            person.setBirthdate(LocalDate.now().minusYears(random.nextInt(30) + 20));
            Person.Address address = new Person.Address(
                    "Street " + (i + 1),
                    "City " + (i % 5),
                    "State " + (i % 3)
            );
            person.setAddress(address);

            return person;
        }).collect(Collectors.toList());

        System.out.println("Original List:");
        inputList.forEach(System.out::println);

        System.out.println();

        List<Person> outputList = inputList.stream()
                .filter(person -> person.getName().contains("2"))
                .filter(person -> person.getBirthdate().isBefore(LocalDate.of(2000, 1, 1)))
                .sorted(Comparator.comparing(Person::getName).thenComparing(Person::getBirthdate))
                .collect(Collectors.toList());

        System.out.println("Filtered and Sorted List:");
        outputList.forEach(System.out::println);
    }
}
