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
        Assertions.assertEquals(expectedSize,salaryMap.get(salary).size());
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
}
