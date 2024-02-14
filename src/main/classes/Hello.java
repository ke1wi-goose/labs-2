import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;


@WebServlet("/hello")
public class Hello extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
     throws IOException, ServletException{
        PrintWriter out = response.getWriter();

        out.println("<html><head><meta charset=\"UTF-8\"><title>Сайт 8 команди</title></head><body><h2>Тестове повідомлення</h2></body></html>");
    }
    
}