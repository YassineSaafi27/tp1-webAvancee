
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class SecurityFilter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("SecurityFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
                         throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        System.out.println("SECURITY FILTER - BEFORE");

        HttpSession session = req.getSession(false);

        if (session != null && session.getAttribute("user") != null) {

            System.out.println("User authenticated");

            chain.doFilter(request, response);

            System.out.println("SECURITY FILTER - AFTER");

        } else {

            System.out.println("User not authenticated");

            res.sendRedirect("login.html");
        }
    }

    @Override
    public void destroy() {
        System.out.println("SecurityFilter destroyed");
    }
}
