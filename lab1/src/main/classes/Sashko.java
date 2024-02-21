import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;


@WebServlet("/sashko")
public class Sashko extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String filepath = "D:\\goose\\goose-kpi\\java2\\lab1\\src\\main\\webapp\\html\\sashko.html";
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        PrintWriter out = response.getWriter();
        response.addHeader("encoding", "UTF-8");

        String line;
        while ((line = reader.readLine()) != null) {
            out.println(line);
        }

        reader.close();
        out.close();
    }
}