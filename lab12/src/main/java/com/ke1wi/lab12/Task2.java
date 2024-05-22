import java.util.*;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        List<Student> students1 = Arrays.asList(
                new Student("John", "Doe", "123", 4.5),
                new Student("Jane", "Smith", "124", 3.8));

        List<Student> students2 = Arrays.asList(
                new Student("Bob", "Brown", "125", 4.0),
                new Student("Alice", "Johnson", "126", 4.2));

        Faculty faculty1 = new Faculty("Computer Science", students1);
        Faculty faculty2 = new Faculty("Mathematics", students2);

        Institute institute = new Institute("Technical University", Arrays.asList(faculty1, faculty2));

        double instituteAverageScore = institute.getFaculties().stream()
                .flatMap(f -> f.getStudents().stream())
                .mapToDouble(Student::getAverageScore)
                .average()
                .orElse(0);

        List<Student> aboveAverageStudents = institute.getFaculties().stream()
                .flatMap(f -> f.getStudents().stream())
                .filter(s -> s.getAverageScore() > instituteAverageScore)
                .collect(Collectors.toList());

        System.out.println("Students with above-average scores:");
        aboveAverageStudents.forEach(s -> System.out.println(s.getFullName()));
    }
}

class Institute {
    private String name;
    private List<Faculty> faculties;

    public Institute(String name, List<Faculty> faculties) {
        this.name = name;
        this.faculties = faculties;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }
}

class Faculty {
    private String name;
    private List<Student> students;

    public Faculty(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }
}

class Student {
    private String firstName;
    private String lastName;
    private String studentId;
    private double averageScore;

    public Student(String firstName, String lastName, String studentId, double averageScore) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.averageScore = averageScore;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
