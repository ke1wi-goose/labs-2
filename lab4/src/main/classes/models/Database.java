package main.classes.models;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Comparator;

public class Database {
    private List<Movie> movies;
    private List<Actor> actors;

    public Database() {
        this.movies = new ArrayList<>();
        this.actors = new ArrayList<>();
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }

    public List<Actor> findActorsWithoutMovies() {
        return actors.stream()
                .filter(actor -> actor.getMovies().isEmpty())
                .collect(Collectors.toList());
    }

    public List<Actor> findCoActors(String actorName) {
        List<Actor> coActors = new ArrayList<>();
        for (Actor actor : actors) {
            if (actor.getName().equals(actorName)) {
                for (Movie movie : actor.getMovies()) {
                    for (Actor coActor : movie.getActors()) {
                        if (!coActor.getName().equals(actorName)) {
                            coActors.add(coActor);
                        }
                    }
                }
                break;
            }
        }
        return coActors;
    }

    public Movie findMovieWithMostActors() {
        return movies.stream()
                .max(Comparator.comparingInt(movie -> movie.getActors().size()))
                .orElse(null);
    }
}
