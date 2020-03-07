package pl.sda.intermediate25;

import java.math.BigDecimal;

public class Customer {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private BigDecimal salary;
    private static int counter;

    static {
        counter = 1;
        System.out.println("Statyczny blok inicjalizujący - wykonuje się raz przy inicjalizacji klasy");
    }

    {
        id = counter++;
        System.out.println("Zwykły blok inicjalizujący - wykonuje się raz przy tworzeniu obiektu przez każdy konstruktor");
    }

    public Customer(String firstName, String lastName, int age, String salary) {
//        this.id = counter++;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.age = age;
//        this.salary = BigDecimal.valueOf(Double.valueOf(salary));
        this(firstName,lastName,age,Integer.valueOf(salary));
    }

    public Customer(String firstName, String lastName, int age, int salary) {
//        this.id = counter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = BigDecimal.valueOf(salary);
//        new BigDecimal(Double.valueOf(salary)); dont do this ^ problem z zaokrąglaniem -> użyj valueOf()
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public BigDecimal getSalary() {
        return salary;
    }
}
