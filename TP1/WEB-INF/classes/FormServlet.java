
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/FormServlet", "/Form_Servlet"})
public class FormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthDay = request.getParameter("birthDay");
        String sex = request.getParameter("sex");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Person Information</title></head>");
        out.println("<body>");

        out.println("<h1>Person Information</h1>");
        out.println("<table border='1' cellpadding='10'>");
        out.println("<tr><th>Field</th><th>Value</th></tr>");

        out.println("<tr><td>First Name</td><td>" + firstName + "</td></tr>");
        out.println("<tr><td>Last Name</td><td>" + lastName + "</td></tr>");
        out.println("<tr><td>Birth Date</td><td>" + birthDay + "</td></tr>");
        out.println("<tr><td>Sex</td><td>" + sex + "</td></tr>");

        out.println("</table>");
        out.println("<p><a href='form.html'>Back to form</a></p>");
        out.println("</body></html>");
    }
}
