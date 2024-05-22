package Employees;

public class Manager extends Employee {
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
        return String.format("Class %s(Name: %s, Age: %s, Phone: %s, Salary: %s $, Subordinates: %s)",
            this.getClass().getSimpleName(),
            this.getName(),
            this.getAge() != 0 ? this.getAge() : "Not available",
            this.getPhone() != null ? this.getPhone() : "Not available",
            this.getSalary() != 0 ? this.getSalary() : "Not available",
            this.getSubordinates() != 0 ? this.getSubordinates() : "Not available");
    }
}
