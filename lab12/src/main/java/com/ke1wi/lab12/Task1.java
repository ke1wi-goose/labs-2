import java.util.*;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        List<Applicant> applicants = Arrays.asList(
                new Applicant("Ivanov", 80),
                new Applicant("Petrov", 70),
                new Applicant("Sidorov", 85),
                new Applicant("Nikolaev", 55),
                new Applicant("Alexeev", 60),
                new Applicant("Vasiliev", 95));

        int budgetPlaces = 2;
        int contractPlaces = 3;

        List<Applicant> sortedApplicants = applicants.stream()
                .sorted(Comparator.comparing(Applicant::getScore).reversed())
                .collect(Collectors.toList());

        List<Applicant> budgetApplicants = sortedApplicants.stream()
                .limit(budgetPlaces)
                .collect(Collectors.toList());

        List<Applicant> contractApplicants = sortedApplicants.stream()
                .skip(budgetPlaces)
                .filter(a -> a.getScore() >= 60)
                .limit(contractPlaces)
                .collect(Collectors.toList());

        System.out.println("Contract Applicants:");
        contractApplicants.stream()
                .sorted(Comparator.comparing(Applicant::getSurname))
                .forEach(a -> System.out.println(a.getSurname() + " " + a.getScore()));
    }
}


