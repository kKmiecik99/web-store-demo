package pl.sda.intermediate25;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class HashCodeTest {

    @RepeatedTest(100)
    void randomHashCode() {
        CarRandomHashCode car1 = new CarRandomHashCode("Audi");
        CarRandomHashCode car2 = new CarRandomHashCode("Audi");
        CarRandomHashCode car3 = new CarRandomHashCode("Audi");
        CarRandomHashCode car4 = new CarRandomHashCode("Audi");
        CarRandomHashCode car5 = new CarRandomHashCode("Audi");
        CarRandomHashCode car6 = new CarRandomHashCode("Audi");
        Set<CarRandomHashCode> cars = new HashSet<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        cars.add(car6);
        System.out.println(cars.size());
        Assertions.assertEquals(1,cars.size());
    }

    @RepeatedTest(100)
    void constantHashCode() {
        CarConstantHashCode car1 = new CarConstantHashCode("Audi");
        CarConstantHashCode car2 = new CarConstantHashCode("Audi");
        CarConstantHashCode car3 = new CarConstantHashCode("Audi");
        CarConstantHashCode car4 = new CarConstantHashCode("Audi");
        CarConstantHashCode car5 = new CarConstantHashCode("Audi");
        CarConstantHashCode car6 = new CarConstantHashCode("Audi");
        Set<CarConstantHashCode> cars = new HashSet<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        cars.add(car6);
        System.out.println(cars.size());
        Assertions.assertEquals(1,cars.size());
    }
}
