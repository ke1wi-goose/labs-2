import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Завдання з л/р №2
        double a = 0.345d;
        double b = -2.25d;
        double c = 2.65d;
        double d = 3.99d;

        CustomFunction function = (x, y, z, w) -> (5 * x) / Math.sin(x)
                + Math.sqrt((Math.tanh(Math.abs(y) * z) / Math.log(w)));
        executeFunction(function, a, b, c, d);

        // Завдання з л/р №8
        List<Employee> employees = Arrays.asList(
                new Employee("Bob"),
                new Employee("Bob", 28),
                new Employee("Alice", 30, "0987654321"),
                new Manager("Alex", 36, "0873168955", 1000, 5));

        employees.forEach(employee -> System.out.println(employee));

    }

    public static void executeFunction(CustomFunction function, double a, double b, double c, double d) {
        double result = function.apply(a, b, c, d);
        System.out.println("Параметри: a = " + a + ", b = " + b + ", c = " + c + ", d = " + d);
        System.out.println("Результат обчислення функції: y = " + result);
    }
}

@FunctionalInterface
interface CustomFunction {
    double apply(double a, double b, double c, double d);
}

class Employee {
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
}

class Manager extends Employee {
    private int subordinates;

    public Manager(String name) {
        super(name);
    }

    public Manager(String name, int age) {
        super(name, age);
    }

    public Manager(String name, int age, String phone) {
        super(name, age, phone);
    }

    public Manager(String name, int age, String phone, int salary) {
        super(name, age, phone, salary);
    }

    public Manager(String name, int age, String phone, int salary, int subordinates) {
        super(name, age, phone, salary);
        this.subordinates = subordinates;
    }

    public int getSubordinates() {
        return this.subordinates;
    }

    @Override
    public String toString() {
        return String.format("Class %s(Name: %s, Age: %s, Phone: %s, Salary: %s $)",
                this.getClass().getSimpleName(),
                this.getName(),
                this.getAge() != 0 ? this.getAge() : "Not available",
                this.getPhone() != null ? this.getPhone() : "Not available",
                this.getSalary() != 0 ? this.getSalary() : "Not available",
                this.getSubordinates() != 0 ? this.getSubordinates() : "Not available");
    }
}
