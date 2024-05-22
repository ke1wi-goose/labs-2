package main.classes.models;

import java.util.List;
import java.util.ArrayList;

public class Movie {
    private String title;
    private List<Actor> actors;

    public Movie(String title) {
        this.title = title;
        this.actors = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void addActor(Actor actor) {
        actors.add(actor);
        actor.addMovie(this);
    }
}
