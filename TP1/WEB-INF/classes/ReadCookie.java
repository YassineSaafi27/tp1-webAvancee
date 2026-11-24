
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;

import java.io.IOException;
import java.io.PrintWriter;

public class ReadCookie extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>Reading Cookies</h1>");

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {

            for (Cookie c : cookies) {

                if (c.getName().equals("firstName") ||
                    c.getName().equals("lastName") ||
                    c.getName().equals("birthDay") ||
                    c.getName().equals("sex")) {

                    out.println("<p>" + c.getName()
                            + " : " + c.getValue() + "</p>");
                }
            }

        } else {
            out.println("<p>No cookies found!</p>");
        }

        out.println("<br><a href='form.html'>Back to Form</a>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        doGet(request, response);
    }
}
