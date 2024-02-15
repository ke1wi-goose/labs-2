import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;


@WebServlet("/vova")
public class Vova extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String filepath = "/Users/ke1wi/Documents/JavaUnik/2-lab1-general-web/lab1/src/main/webapp/html/vova.html";
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        PrintWriter out = response.getWriter();

        String line;
        while ((line = reader.readLine()) != null) {
            out.println(line);
        }

        reader.close();
        out.close();
    }
}