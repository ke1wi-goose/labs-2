package src.main.classes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;
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

@WebServlet("/html/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        Storage storage = Storage.getInstance();
        PrintWriter out = response.getWriter();

        for (Cookie cookie : cookies) {
            if ((Security.hashPassword(request.getParameter("pass"),
                    cookie.getValue())).equals(storage.get(request.getParameter("log")))) {
                Cookie new_cookie = new Cookie("status", "logged");
                new_cookie.setMaxAge(300);
                response.addCookie(new_cookie);
                response.sendRedirect("/lab2/html/home");
                return;
            }
        }
    }
    // What to do if not login?;
}