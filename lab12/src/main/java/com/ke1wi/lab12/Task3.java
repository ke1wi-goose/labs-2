import java.util.*;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) {
        List<Applicant> applicants = Arrays.asList(
                new Applicant("Ivanov", 80),
                new Applicant("Petrov", 70),
                new Applicant("Sidorov", 85),
                new Applicant("Nikolaev", 55),
                new Applicant("Alexeev", 60),
                new Applicant("Vasiliev", 95));

        List<String> rejectedApplicants = applicants.stream()
                .filter(a -> a.getScore() < 60)
                .map(Applicant::getSurname)
                .collect(Collectors.toList());

        System.out.println("Rejected Applicants:");
        rejectedApplicants.forEach(System.out::println);
    }
}
