
import Employees.Employee;
import Employees.Manager;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.function.BiFunction;

public class Result {
    public static void main(String[] args) {
        Employee employee = new Employee("Bob");
        Employee employee2 = new Employee("Bob", 28);
        Manager manager = new Manager("Alex", 36, "0873168955", 1000);
        System.out.println(employee);
        System.out.println(employee2);
        System.out.println(manager);
        System.out.println(employee.equals(manager));

        // Посилання на статичний метод класу
        Supplier<String> employeeType = Employee::getEmployeeType;
        System.out.println(employeeType.get());

        // Посилання на нестатичний метод об'єкта
        Function<Employee, String> employeeName = Employee::getName;
        System.out.println(employeeName.apply(employee));

        // Посилання на нестатичний метод класу
        ToIntFunction<Employee> employeeAge = Employee::getAge;
        System.out.println(employeeAge.applyAsInt(employee2));

        // Посилання на конструктор
        BiFunction<String, Integer, Employee> employeeConstructor = Employee::new;
        Employee newEmployee = employeeConstructor.apply("Alice", 30);
        System.out.println(newEmployee);
    }
}
