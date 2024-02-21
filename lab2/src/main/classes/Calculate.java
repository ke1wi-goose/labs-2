package src.main.classes;

import java.io.*;
import java.util.Timer;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;


@WebServlet("/calculate")
public class Calculate extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String param1 = request.getParameter("number1");
        String param2 = request.getParameter("number2");
        if (param1 == "" || param2 == "") {
            response.sendRedirect("http://localhost:8080/lab2/empty");
            return;
        }
        Integer number1 = Integer.parseInt(request.getParameter("number1"));
        Integer number2 = Integer.parseInt(request.getParameter("number2"));
        String action = request.getParameter("select");
        int result;
        PrintWriter out = response.getWriter();

        switch (action) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                try {
                    result = number1 / number2;
                } catch (ArithmeticException ex) {
                    out.println("Cannot " + ex.getMessage());
                    response.sendRedirect("http://localhost:8080/lab2/dex");
                }
                return;
            default:
                out.println("Something went wrong");
                out.close();
                return;
        }
        out.print("<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<meta http-equiv='refresh' content='5; URL=https://localhost:8080/lab2'>" +
                "<title>Redirecting...</title>" +
                "</head>" +
                "<body style='backgroud-color: white'>" +
                "<h1 align='center' >Your result: " + result + "</h1>" +
                "<p>You will be redirected to the homepage in 3 seconds...</p>" +
                "<p>If you are not redirected, <a href='https://localhost:8080/lab2'>click here</a>.</p>" +
                "</body>" +
                "</html>");
    }
}
