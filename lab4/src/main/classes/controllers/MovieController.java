package main.classes.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import main.classes.models.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/movieController")
public class MovieController extends HttpServlet {
    private Database dataBase;

    @Override
    public void init() throws ServletException {
        super.init();
        dataBase = new Database();

        Actor actor1 = new Actor("Jason Statham");
        Actor actor2 = new Actor("Dwayne Douglas Johnson");
        Actor actor3 = new Actor("Tom Cruise");
        Movie movie1 = new Movie("Fast & Furious: Hobbs & Shaw");
        Movie movie2 = new Movie("Mission: Impossible");
        movie1.addActor(actor1);
        movie1.addActor(actor2);
        movie2.addActor(actor2);
        movie2.addActor(actor3);

        dataBase.addActor(actor1);
        dataBase.addActor(actor2);
        dataBase.addActor(actor3);
        dataBase.addMovie(movie1);
        dataBase.addMovie(movie2);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "view";
        }

        switch (action) {
            case "findActorsWithoutMovies":
                findActorsWithoutMovies(request, response);
                break;
            case "findCoActors":
                findCoActors(request, response);
                break;
            case "findMovieWithMostActors":
                findMovieWithMostActors(request, response);
                break;
            default:
                showMainPage(request, response);
                break;
        }
    }

    private void showMainPage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Movie> movies = dataBase.getMovies();
        List<Actor> actors = dataBase.getActors();
        request.setAttribute("movies", movies);
        request.setAttribute("vova", 10);
        request.setAttribute("actors", actors);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void findActorsWithoutMovies(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Actor> actorsWithoutMovies = dataBase.findActorsWithoutMovies();
        request.setAttribute("actorsWithoutMovies", actorsWithoutMovies);
        RequestDispatcher dispatcher = request.getRequestDispatcher("actorsWithoutMovies.jsp");
        dispatcher.forward(request, response);
    }

    private void findCoActors(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String actorName = request.getParameter("actorName");
        List<Actor> coActors = dataBase.findCoActors(actorName);
        request.setAttribute("coActors", coActors);
        request.setAttribute("actorName", actorName);
        RequestDispatcher dispatcher = request.getRequestDispatcher("coActors.jsp");
        dispatcher.forward(request, response);
    }

    private void findMovieWithMostActors(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Movie movieWithMostActors = dataBase.findMovieWithMostActors();
        request.setAttribute("movieWithMostActors", movieWithMostActors);
        RequestDispatcher dispatcher = request.getRequestDispatcher("movieWithMostActors.jsp");
        dispatcher.forward(request, response);
    }
}
