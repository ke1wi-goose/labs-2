import java.util.*;
import java.util.stream.Collectors;

public class Task1 {
        public static void main(String[] args) {
                List<Applicant> applicants = Arrays.asList(
                                new Applicant("Maliarevych", 80),
                                new Applicant("Vovchok", 70),
                                new Applicant("Nychyk", 85),
                                new Applicant("Perehuda", 55),
                                new Applicant("Martuniuk", 60),
                                new Applicant("Klimchuk", 95));

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

                System.out.println("Budject Applicants:");
                budgetApplicants.stream()
                                .sorted(Comparator.comparing(Applicant::getSurname))
                                .forEach(a -> System.out.println(a.getSurname() + " " + a.getScore()));
                System.out.println("Contract Applicants:");
                contractApplicants.stream()
                                .sorted(Comparator.comparing(Applicant::getSurname))
                                .forEach(a -> System.out.println(a.getSurname() + " " + a.getScore()));
        }
}
