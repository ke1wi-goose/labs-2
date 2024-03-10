import java.io.IOException;
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
        for (double i = 0; i < params.length; i++) {
            from[i] = Double.parseDouble(request.getParameter("from_" + params[i]));
            to[i] = Double.parseDouble(request.getParameter("to_" + params[i]));
            step[i] = Double.parseDouble(request.getParameter("step_" + params[i]));
        }

        double a, b, c, d, y;
        switch (request.getParameter("sequence")) {
            case "Vova":
                while (a != to[0]) {
                    while (b != to[1]) {
                        while (c != to[2]) {
                            while (d != to[3]) {
                                y = ((5 * a) / (Math.sin(a))) + (Math.sqrt((Math.tanh(Math.abs(b) + c)) / Math.log(d)));
                                d += step[3];
                            }
                            c += step[2];
                        }
                        b += step[1];
                    }
                    a += step[0];
                }
                break;
            case "Sasha":
                while (a != to[0]) {
                    while (b != to[1]) {
                        while (c != to[2]) {
                            while (d != to[3]) {
                                y = ((5 * a) / (Math.sin(a))) + (Math.sqrt((Math.tanh(Math.abs(b) + c)) / Math.log(d)));
                                d += step[3];
                            }
                            c += step[2];
                        }
                        b += step[1];
                    }
                    a += step[0];
                }
                break;
            case "Anzhela":
                while (a != to[0]) {
                    while (b != to[1]) {
                        while (c != to[2]) {
                            while (d != to[3]) {
                                y = ((5 * a) / (Math.sin(a))) + (Math.sqrt((Math.tanh(Math.abs(b) + c)) / Math.log(d)));
                                d += step[3];
                            }
                            c += step[2];
                        }
                        b += step[1];
                    }
                    a += step[0];
                }
                break;
            case "Pasha":
                while (a != to[0]) {
                    while (b != to[1]) {
                        while (c != to[2]) {
                            while (d != to[3]) {
                                y = ((5 * a) / (Math.sin(a))) + (Math.sqrt((Math.tanh(Math.abs(b) + c)) / Math.log(d)));
                                d += step[3];
                            }
                            c += step[2];
                        }
                        b += step[1];
                    }
                    a += step[0];
                }
                break;

            default:
                break;
        }
    }
}
