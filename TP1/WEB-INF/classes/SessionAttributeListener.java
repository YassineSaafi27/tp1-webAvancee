import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

@WebListener
public class SessionAttributeListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent e) {
        System.out.println("Attribute added: " + e.getName() + " = " + e.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent e) {
        // getValue() returns the OLD value in this event
        Object newVal = e.getSession().getAttribute(e.getName());
        System.out.println("Attribute replaced: " + e.getName() + " : " + e.getValue() + " -> " + newVal);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent e) {
        System.out.println("Attribute removed: " + e.getName() + " (was " + e.getValue() + ")");
    }
}