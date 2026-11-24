import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ShowSession")
public class ShowSession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        // Get the current session or create a new one
        HttpSession session = request.getSession();

        // Check whether this is the first visit
        Integer visits = (Integer) session.getAttribute("visits");

        if (visits == null) {
            visits = 1;
            session.setAttribute("visits", visits);

            out.println("<h1>Welcome on my site!</h1>");
            out.println("<p>You are a new visitor.</p>");

        } else {
            visits++;
            session.setAttribute("visits", visits);

            out.println("<h1>Welcome back!</h1>");
        }

        out.println("<p>Number of visits: " + visits + "</p>");

        out.println("<p><a href='form.html'>Back to form</a></p>");
    }
}