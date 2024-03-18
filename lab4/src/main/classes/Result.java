import java.util.ArrayList;
import java.util.Iterator;

public class Result {
    public static void main(String[] args) {

        Film film1 = new Film("The Wolf of Wall Street");
        Film film2 = new Film("Titanic");
        Film film3 = new Film("Oppenheimer");

        Actor actor1 = new Actor("Margot Robbie");
        Actor actor2 = new Actor("Leonardo DiCaprio");
        Actor actor3 = new Actor("Cillian Murphy");
        Actor actor4 = new Actor("Jason Stethem");

        Database database = new Database();

        database.addFilm(film1);
        database.addFilm(film2);
        database.addFilm(film3);

        database.addActor(actor1);
        database.addActor(actor2);
        database.addActor(actor3);
        database.addActor(actor4);

        film1.addActor(actor1);
        film1.addActor(actor2);
        film2.addActor(actor2);
        film3.addActor(actor3);

        if (findFilmWithMostActors(database) != null) {
            System.out.println("\nFilm with the most actors: " + findFilmWithMostActors(database).getName());
        } else {
            System.out.println("No films found in the database.");
        }

        System.out.println("\nActors that played with given actor:");
        for (Actor actor : playedWithActor(database, actor1)) {
            System.out.println(actor.getName());
        }

        System.out.printf("\nIs there any actor that doesn't play in any film: %s", hasActorWithNoFilms(database));
    }

    private static Film findFilmWithMostActors(Database database) {
        Film filmWithMostActors = null;
        int maxActorCount = 0;

        ArrayList<Film> films = database.getListOfFilms();
        Iterator<Film> iterator = films.iterator();

        while (iterator.hasNext()) {
            Film film = iterator.next();
            int actorCount = film.getActors().size();

            if (actorCount > maxActorCount) {
                maxActorCount = actorCount;
                filmWithMostActors = film;
            }
        }

        return filmWithMostActors;
    }

    private static ArrayList<Actor> playedWithActor(Database database, Actor givenActor) {
        ArrayList<Actor> playedWithActor = new ArrayList<>();
        for (Film film : database.getListOfFilms()) {
            if (film.getActors().contains(givenActor)) {
                for (Actor actor : film.getActors()) {
                    if (!actor.equals(givenActor) && !playedWithActor.contains(actor)) {
                        playedWithActor.add(actor);
                    }
                }
            }

        }
        return playedWithActor;
    }
    private static boolean hasActorWithNoFilms(Database database) {


        ArrayList<Actor> actors = database.getListOfActors();
        ArrayList<Film> films = database.getListOfFilms();

        Iterator actorIterator = actors.iterator();
        while (actorIterator.hasNext()) {
            boolean actinFilm = false;
            Actor actor = (Actor) actorIterator.next();

            Iterator filmIterator = films.iterator();
            while (filmIterator.hasNext()) {
                Film film = (Film) filmIterator.next();
                if (film.getActors().contains(actor)) {
                    actinFilm = true;
                    break;
                }
            }
            if (!actinFilm) {
                return true;
            }
        }
        return false;
    }
}

