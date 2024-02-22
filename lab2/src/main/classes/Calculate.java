package src.main.classes;

import java.io.*;
import java.util.Timer;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/html/calculate")
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
        Long number1 = Long.parseLong(request.getParameter("number1"));
        Long number2 = Long.parseLong(request.getParameter("number2"));
        String action = request.getParameter("select");
        Cookie[] cookies = {
                new Cookie("num1", number1.toString()),
                new Cookie("num2", number2.toString()),
        };
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(3600);
            response.addCookie(cookie);
        }
        Long result;
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
                "<title>Result</title>" +
                "</head>" +
                "<body>" +
                "<div style='backgroud-color: white; text-align: center'" +
                "<h1 align='center' >Your result: <br>" + result + "</h1>" +
                "<a href='http://localhost:8080/lab2/html/home'>Redirect to homepage</a>" +
                "</body>" +
                "</html>");
    }
}
