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
                "<meta http-equiv='refresh' content='5; URL=https://localhost:8080/lab2'>" +
                "<title>Redirecting...</title>" +
                "</head>" +
                "<body style='backgroud-color: red'>" +
                "<h1 style='color: white'>Empty input</h1>" +
                "<p style='color: white'>You will be redirected to the homepage in 3 seconds...</p>" +
                "<p style='color: white'>If you are not redirected, <a href='https://localhost:8080/lab2'>click here</a>.</p>" +
                "</body>" +
                "</html>");
    };
}
