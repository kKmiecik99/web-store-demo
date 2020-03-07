package pl.sda.intermediate25;

import java.util.*;
import java.util.stream.Collectors;

public class CustomerStatistics {
    private final static Customer[] people = new Customer[]{
            new Customer("Anna", "Nowak   ", 33, "1200"),
            new Customer("Beata", "Kowalska", 22, "1200"),
            new Customer("Marek", " Nowak", 25, "1250 "),
            new Customer("Adam", "Twardowski", 33, "4100 "),
            new Customer("Monika  ", "Kos", 25, "2500"),
            new Customer("Adam ", "Rudy", 45, "3333"),
            new Customer("Marek", "Rudy", 15, 2210),
            new Customer("Adam", "Madej", 15, 3333),
            new Customer("Adam", "Nowak ", 15, null)
    };

    static List<Customer> arrayToList() {
        return Arrays.asList(people);
    }

    //2. Napisz metodę, która przyjmie tablicę people i zwróci listę Stringów <imię nazwisko> (elementem listy będzie np "Anna Nowak")
    static List<String> namesListWithStream() {
        return Arrays.stream(people)
                .map(p -> p.getFirstName() + " " + p.getLastName())
                .collect(Collectors.toList());
    }

    static List<String> namesList() {
        List<String> resultList = new ArrayList<>();
        for (Customer person : people) {
            resultList.add(person.getFirstName() + " " + person.getLastName());
        }
        return resultList;
    }

    //3. Napisz metodę, która zwróci mapę osób <id,osoba>
    static Map<Integer, Customer> customerIdMap() {
        Map<Integer, Customer> resultMap = new HashMap<>();
        for (Customer person : people) {
            resultMap.put(person.getId(), person);
        }
        return resultMap;
    }

    static Map<Integer, Customer> customerIdMapWithStream() {
        return Arrays.stream(people)
                .collect(Collectors.toMap(p -> p.getId(), p -> p));
    }
}
