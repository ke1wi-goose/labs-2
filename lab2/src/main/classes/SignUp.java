package src.main.classes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import src.main.classes.Storage.*;
import src.main.classes.Security.*;

@WebServlet("/html/signup")
public class SignUp extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        byte[] salt = Security.generateSalt();
        String login = request.getParameter("sign");
        String pass = request.getParameter("pass");
        Cookie[] cookies = {
                new Cookie("login", request.getParameter("sign")),
                new Cookie("salt", salt.toString()),
        };
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(300);
            response.addCookie(cookie);
        }
        Storage storage = Storage.getInstance();
        storage.put(login, Security.hashPassword(request.getParameter("pass"), salt.toString()));

        response.sendRedirect("/lab2/html/home");
        return;
    }
}