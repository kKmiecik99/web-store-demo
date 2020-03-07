package pl.sda.intermediate25;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CustomerStatisticsTest {
    @Test
    void shouldProperlyGroupCustomersBySalary() {
        int expectedSize = 2;
        BigDecimal salary = BigDecimal.valueOf(3333);

        Map<BigDecimal, List<Customer>> salaryMap = CustomerStatistics.customerWithSalaryMap();
        Assertions.assertEquals(expectedSize, salaryMap.get(salary).size());
    }

    @Test
    void shouldProperlyGroupCustomersByNameAndSalary() {
        int expectedSize = 2;
        BigDecimal salary = BigDecimal.valueOf(3333);
        String name = "Adam";

        Map<String, Map<BigDecimal, Integer>> nameSalaryMap = CustomerStatistics.countByNameAndSalaryMap();
        Integer counter = nameSalaryMap.get(name).get(salary);
        Assertions.assertEquals(expectedSize, counter);
    }

    @Test
    void shouldSortUniqueNamesDescending() {
        int expectedSize = 5;
        String expectedName = "Anna";
        List<String> namesList = CustomerStatistics.sortDistinctNamesDescending();
        Assertions.assertEquals(expectedSize, namesList.size());
        Assertions.assertEquals(expectedName, namesList.get(3));

    }

    @Test
    void shouldPartitionCustomerByAge() {
        String expectedFirstName = "Adam";
        String expectedLastName = "Madej";
        List<Customer> customers = CustomerStatistics.adultMap().get(false);
        boolean present = customers.stream()
                .filter(e -> e.getFirstName().trim().equals(expectedFirstName))
                .filter(e -> e.getLastName().trim().equals(expectedLastName))
                .findAny()
                .isPresent();
        Assertions.assertTrue(present);
    }
}
