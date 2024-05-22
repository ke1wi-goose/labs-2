import java.util.*;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) {
        List<Applicant> applicants = Arrays.asList(
            new Applicant("Maliarevych", 80),
            new Applicant("Vovchok", 70),
            new Applicant("Nychyk", 85),
            new Applicant("Perehuda", 55),
            new Applicant("Martuniuk", 60),
            new Applicant("Klimchuk", 95));


        List<String> rejectedApplicants = applicants.stream()
                .filter(a -> a.getScore() < 60)
                .map(Applicant::getSurname)
                .collect(Collectors.toList());

        System.out.println("Rejected Applicants:");
        rejectedApplicants.forEach(System.out::println);
    }
}
