public class Applicant {
    private String surname;
    private int score;

    public Applicant(String surname, int score) {
        this.surname = surname;
        this.score = score;
    }

    public String getSurname() {
        return surname;
    }

    public int getScore() {
        return score;
    }
}