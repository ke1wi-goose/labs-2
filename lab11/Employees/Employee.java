package Employees;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.function.BiFunction;

public class Employee {
    private String name;
    private int age;
    private int salary;
    private String phone;

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Employee(String name, int age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public Employee(String name, int age, String phone, int salary) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.salary = salary;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getPhone() {
        return this.phone;
    }

    public int getSalary() {
        return this.salary;
    }

    public static String getEmployeeType() {
        return "Employee";
    }

    @Override
    public String toString() {
        return String.format("Class %s(Name: %s, Age: %s, Phone: %s , Salary: %s)",
            this.getClass().getSimpleName(),
            this.getName(),
            this.getAge() != 0 ? this.getAge() : "Not available",
            this.getPhone() != null ? this.getPhone() : "Not available",
            this.getSalary() != 0 ? this.getSalary() : "Not available");
    }

    @Override
    public boolean equals(Object obj) {
        return (this == obj);
    }

    public static void main(String[] args) {
        Employee employee = new Employee("Bob");
        Employee employee2 = new Employee("Bob", 28);
        
        Supplier<String> employeeType = Employee::getEmployeeType;
        System.out.println(employeeType.get());

        Function<Employee, String> employeeName = Employee::getName;
        System.out.println(employeeName.apply(employee));

        ToIntFunction<Employee> employeeAge = Employee::getAge;
        System.out.println(employeeAge.applyAsInt(employee2));

        BiFunction<String, Integer, Employee> employeeConstructor = Employee::new;
        Employee newEmployee = employeeConstructor.apply("Alice", 30);
        System.out.println(newEmployee);
    }
}
