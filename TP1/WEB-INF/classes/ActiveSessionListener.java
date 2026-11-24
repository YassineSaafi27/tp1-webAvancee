import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;

@WebListener
public class ActiveSessionListener implements HttpSessionListener {

    private static final String ATTR = "activeSessions";

    private AtomicInteger counter(ServletContext ctx) {
        synchronized (ctx) { // safe lazy init
            AtomicInteger c = (AtomicInteger) ctx.getAttribute(ATTR);
            if (c == null) {
                c = new AtomicInteger(0);
                ctx.setAttribute(ATTR, c);
            }
            return c;
        }
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext ctx = se.getSession().getServletContext();
        int n = counter(ctx).incrementAndGet();
        System.out.println("Session created: " + se.getSession().getId() + " | active = " + n);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext ctx = se.getSession().getServletContext();
        int n = counter(ctx).decrementAndGet();
        System.out.println("Session destroyed: " + se.getSession().getId() + " | active = " + n);
    }
}