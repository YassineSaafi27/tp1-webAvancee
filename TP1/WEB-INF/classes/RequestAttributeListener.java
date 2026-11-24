import jakarta.servlet.ServletRequestAttributeEvent;
import jakarta.servlet.ServletRequestAttributeListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class RequestAttributeListener implements ServletRequestAttributeListener {

    @Override
    public void attributeAdded(ServletRequestAttributeEvent e) {
        System.out.println("[REQUEST] Attribute added: " + e.getName() + " = " + e.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent e) {
        Object newVal = e.getServletRequest().getAttribute(e.getName());
        System.out.println("[REQUEST] Attribute replaced: " + e.getName()
                + " : " + e.getValue() + " -> " + newVal);
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent e) {
        System.out.println("[REQUEST] Attribute removed: " + e.getName() + " (was " + e.getValue() + ")");
    }
}