import java.util.ArrayList;

public class Film {
    private String name;
    private ArrayList<Actor> actors;

    public Film(String name) {
        this.name = name;
        this.actors = new ArrayList<Actor>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }
}

