
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        // 1. Retrieve username from the form
        String username = request.getParameter("username");

        // 2. Check username
        if (username == null || username.trim().isEmpty()) {
            response.sendRedirect("login.html");
            return;
        }

        // 3. Create or retrieve HTTP session
        HttpSession session = request.getSession();

        // 4. Store username in session
        session.setAttribute("user", username);

        // 5. Display confirmation message
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html><body>");

        out.println("<h1>Login Successful!</h1>");

        out.println("<p>Welcome " + username + "</p>");

        out.println("<a href='items.html'>Go to Items Page</a>");

        out.println("<br><br>");

        out.println("<a href='ListItems'>Access ListItems Servlet</a>");

        out.println("</body></html>");
    }
}
