import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/dex")
public class DivisionByZeroEx extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.print("<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<title>Redirecting...</title>" +
                "</head>" +
                "<form id='redirectForm' action='https://localhost:8080/lab2' method='GET'>" +
                "<input type='submit' value='Click here if not redirected'>" +
                "</form>" +
                "<script>" +
                "document.getElementById('redirectForm').submit();" +
                "</script>" +
                "<p style='color: white'>If you are not redirected, <a href='https://localhost:8080/lab2'>click here</a>.</p>"
                +
                "</body>" +
                "</html>");

    };
}
