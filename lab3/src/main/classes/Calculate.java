import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calculate")
public class Calculate extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        double[] from = new double[4];
        double[] to = new double[4];
        double[] step = new double[4];

        String[] params = { "a", "b", "c", "d" };
        for (int i = 0; i < params.length; i++) {
            from[i] = Double.parseDouble(request.getParameter("from_" + params[i]));
            to[i] = Double.parseDouble(request.getParameter("to_" + params[i]));
            step[i] = Double.parseDouble(request.getParameter("step_" + params[i]));
        }

        ArrayList<ArrayList<Double>> lists_of_vars = new ArrayList<ArrayList<Double>>();

        double y = 0;
        for (double a = from[0]; a <= to[0]; a += step[0]) {
            for (double b = from[1]; b <= to[1]; b += step[1]) {
                for (double c = from[2]; c <= to[2]; c += step[2]) {
                    for (double d = from[3]; d <= to[3]; d += step[3]) {
                        y = ((5 * a) / (Math.sin(a))) + (Math.sqrt((Math.tanh(Math.abs(b) + c)) / Math.log(d)));
                        lists_of_vars.add(new ArrayList<Double>(Arrays.asList(y, a, b, c, d)));
                    }
                }
            }
        }
        int i = 1;
        for (ArrayList list : lists_of_vars) {
            request.setAttribute("Iteration " + i, list);
            i++;
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/");
        dispatcher.forward(request, response);
    }
}