import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calculate")
public class Calculate extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        ArrayList<Double> from = new ArrayList<Double>();
        ArrayList<Double> to = new ArrayList<Double>();
        ArrayList<Double> step = new ArrayList<Double>();

        String[] params = { "a", "b", "c", "d" };
        for (int i = 0; i < params.length; i++) {
            from.add(Double.parseDouble(request.getParameter("from_" + params[i])));
            to.add(Double.parseDouble(request.getParameter("to_" + params[i])));
            step.add(Double.parseDouble(request.getParameter("step_" + params[i])));
        }
        for (int i = 0; i < 4; i++) {
            response.addCookie(new Cookie("from_" + params[i], from.get(i).toString()));
        }
        for (int i = 0; i < 4; i++) {
            response.addCookie(new Cookie("to_" + params[i], to.get(i).toString()));
        }
        for (int i = 0; i < 4; i++) {
            response.addCookie(new Cookie("step_" + params[i], step.get(i).toString()));
        }

        ArrayList<ArrayList<Double>> lists_of_vars = new ArrayList<ArrayList<Double>>();

        double y = 0;
        for (double a = from.get(0); a <= to.get(0); a += step.get(0)) {
            for (double b = from.get(1); b <= to.get(1); b += step.get(1)) {
                for (double c = from.get(2); c <= to.get(2); c += step.get(2)) {
                    for (double d = from.get(3); d <= to.get(3); d += step.get(3)) {
                        y = ((5 * a) / (Math.sin(a))) + (Math.sqrt((Math.tanh(Math.abs(b) + c)) / Math.log(d)));
                        lists_of_vars.add(new ArrayList<Double>(Arrays.asList(y, a, b, c, d)));
                    }
                }
            }
        }
        int i = 0;
        for (ArrayList list : lists_of_vars) {
            i++;
            request.setAttribute("Iteration " + i, list);
        }
        request.setAttribute("Number_of_iter", i);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}