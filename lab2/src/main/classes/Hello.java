import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;

@WebServlet("/hello")
public class Hello extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Hello</h2>");
        out.println("</body></html>");
    }
}
