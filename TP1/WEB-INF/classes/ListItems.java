import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/ListItems")
public class ListItems extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Get the user's session
        HttpSession session = request.getSession();

        // Get the item submitted by the form
        String newItem = request.getParameter("newItem");

        // Retrieve the existing list from the session
        ArrayList<String> items =
                (ArrayList<String>) session.getAttribute("items");

        // Create the list if it does not exist yet
        if (items == null) {
            items = new ArrayList<String>();
        }

        // Add the new item
        if (newItem != null && !newItem.trim().isEmpty()) {
            items.add(newItem.trim());
        }

        // Save the list in the session
        session.setAttribute("items", items);

        // Display the list
        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>My Items</title></head><body>");
        out.println("<h1>My Items</h1>");
        out.println("<ul>");

        for (String item : items) {
            out.println("<li>" + escapeHtml(item) + "</li>");
        }

        out.println("</ul>");
        out.println("<p>Total items: " + items.size() + "</p>");
        out.println("<a href='items.html'>Add another item</a>");
        out.println("</body></html>");
    }

    private String escapeHtml(String value) {
        return value.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&#39;");
    }
}
