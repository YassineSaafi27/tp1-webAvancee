import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ApplicationAttributeListener implements ServletContextAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent e) {
        System.out.println("[APP] Attribute added: " + e.getName() + " = " + e.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent e) {
        // getValue() returns the OLD value
        Object newVal = e.getServletContext().getAttribute(e.getName());
        System.out.println("[APP] Attribute replaced: " + e.getName()
                + " : " + e.getValue() + " -> " + newVal);
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent e) {
        System.out.println("[APP] Attribute removed: " + e.getName() + " (was " + e.getValue() + ")");
    }
}