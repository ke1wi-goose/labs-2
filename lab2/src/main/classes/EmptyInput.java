package src.main.classes;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/empty")
public class EmptyInput extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.print("<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<meta http-equiv='refresh' content='3; URL=http://localhost:8080/lab2/html/home'>" +
                "<title>Redirecting...</title>" +
                "</head>" +
                "<body style='text-align='center''>" +
                // "<div style='text-align: center; background-color: red; box-shadow: 0 0 20px rgba(0, 0, 0, 0.2); width: 400px'>"
                // +
                "<h1>Empty input</h1>" +
                "<p>You will be redirected to the homepage in 3 seconds...</p>" +
                "<p>If you are not redirected, <a href='http://localhost:8080/lab2/html/home'>click here</a>.</p>"
                +
                // "</div>" +
                "</body>" +
                "</html>");
    };
}
