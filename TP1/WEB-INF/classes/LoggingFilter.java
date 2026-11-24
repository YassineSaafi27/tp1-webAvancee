
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class LoggingFilter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("LoggingFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
                         throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        System.out.println("LOGGING FILTER - BEFORE");
        System.out.println("Requested URL: " + req.getRequestURL());

        chain.doFilter(request, response);

        System.out.println("LOGGING FILTER - AFTER");
    }

    @Override
    public void destroy() {
        System.out.println("LoggingFilter destroyed");
    }
}
