package src.main.classes;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@WebServlet("/calculate")
public class HelloForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "Using GET Method to Read Form Data";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        out.print(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>First Name</b>: "
                + request.getParameter("first_name") + "\n" +
                "  <li><b>Last Name</b>: "
                + request.getParameter("last_name") + "\n" +
                "</ul>\n" +
                "</body>" +
                "</html>");
    };

    // protected void doPost(HttpServletRequest request, HttpServletResponse
    // response)
    // throws ServletException, IOException {
    // BufferedReader reader = request.getReader();
    // StringBuilder sb = new StringBuilder();
    // String line;
    // while ((line = reader.readLine()) != null) {
    // sb.append(line);
    // }
    // reader.close();

    // JsonObject json = JsonParser.parseString(sb.toString()).getAsJsonObject();
    // String firstName;
    // String lastName;
    // if (json.get("first_name") != null) {
    // firstName = json.get("first_name").getAsString();
    // } else {
    // firstName = "First name empty";
    // }
    // if (json.get("first_name") != null) {
    // lastName = json.get("last_name").getAsString();
    // } else {
    // lastName = "Last name empty";
    // }
    // response.setContentType("application/json");
    // response.setCharacterEncoding("UTF-8");
    // response.getWriter().print(
    // "<html>\n" +
    // "<head><title>" + "POST RESPONSE" + "</title></head>\n" +
    // "<body bgcolor = \"#f0f0f0\">\n" +
    // "<h1 align = \"center\">" + "POST RESPONSE" + "</h1>\n" +
    // "<ul>\n" +
    // " <li><b>First Name</b>: "
    // + firstName + "\n" +
    // " <li><b>Last Name</b>: "
    // + lastName + "\n" +
    // "</ul>\n" +
    // "</body>" +
    // "</html>");
    // }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

                
                String param1 = request.getParameter("number1");
                String param2 = request.getParameter("number2");

                int number1 = Integer.parseInt(param1);
                int number2 = Integer.parseInt(param2);

                
    }
}
