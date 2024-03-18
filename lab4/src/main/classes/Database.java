import java.util.ArrayList;

public class Database {
    private ArrayList<Film> listOfFilms;
    private ArrayList<Actor> listOfActors;

    public Database() {
        this.listOfFilms = new ArrayList<Film>();
        this.listOfActors = new ArrayList<Actor>();
    }

    public ArrayList<Actor> getListOfActors() {
        return listOfActors;
    }

    public ArrayList<Film> getListOfFilms() {
        return listOfFilms;
    }

    public void addFilm(Film film) {
        this.listOfFilms.add(film);
    }

    public void addActor(Actor actor) {
        this.listOfActors.add(actor);
    }
}

