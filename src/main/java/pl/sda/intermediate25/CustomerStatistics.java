package pl.sda.intermediate25;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

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
        return stream(people)
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
        return stream(people)
                .collect(Collectors.toMap(p -> p.getId(), p -> p));
    }

    //4. Napisz metodę, która zwróci mapę osób według zarobków <zarobki,osoby_z_zarobkami>
    static Map<BigDecimal, List<Customer>> customerWithSalaryMap() {
        Map<BigDecimal, List<Customer>> resultMap = new HashMap<>();
        for (Customer person : people) {
            BigDecimal salary = person.getSalary();
            if (resultMap.containsKey(salary)) {
                List<Customer> innerList = resultMap.get(salary);
                innerList.add(person);
//                resultMap.put(salary,innerList); krok zbędny - Java referencja
            } else {
                List<Customer> innerList = new ArrayList<>();
                innerList.add(person);
                resultMap.put(salary, innerList);
            }
        }
        return resultMap;
    }

    static Map<BigDecimal, List<Customer>> customerWithSalaryMapWithStream() {
        return stream(people)
                .collect(groupingBy(p -> p.getSalary()));
    }

    //    6. Napisz metodę, która zwróci mapę map <imię,<zarobki, liczba_osób_z_takimi_zarobkami>>
    static Map<String, Map<BigDecimal, Integer>> countByNameAndSalaryMap() {
        Map<String, Map<BigDecimal, Integer>> resultMap = new HashMap<>();
        for (Customer person : people) {
            String firstName = person.getFirstName().strip();
            if (resultMap.containsKey(firstName)) {
                Map<BigDecimal, Integer> innerMap = resultMap.get(firstName);
                if (innerMap.containsKey(person.getSalary())) {
                    Integer counter = innerMap.get(person.getSalary());
                    innerMap.put(person.getSalary(), ++counter);
                } else {
                    innerMap.put(person.getSalary(), 1);
                }
            } else {
                Map<BigDecimal, Integer> innerMap = new HashMap<>();
                innerMap.put(person.getSalary(), 1);
                resultMap.put(firstName, innerMap);
            }
        }
        return resultMap;
    }

    static Map<String, Map<BigDecimal, Long>> countByNameAndSalaryMapWithStream() {
        return stream(people)
                .collect(groupingBy(e -> e.getFirstName().trim(), groupingBy(p -> p.getSalary(), counting())));
    }
    //8. Napisz metodę, która zwróci kolekcję unikalnych imion posortowanych alfabetycznie, ale malejącej kolejności

}
