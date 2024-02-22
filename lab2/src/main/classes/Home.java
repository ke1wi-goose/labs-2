package src.main.classes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/html/home")
public class Home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("status")) {
                if (cookie.getValue().equals("logged")) {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/form.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
            }
        }
        response.sendRedirect("http://localhost:8080/lab2/html/login.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        PrintWriter out = response.getWriter();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("status")) {
                if (cookie.getValue().equals("logged")) {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/form.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
            }
        }
    }
}
