package umbcs680.multicastdesign;
import java.util.List;
public interface Observer {
    void update(String message);
    default List<String> getNotifications() {
        throw new UnsupportedOperationException("getNotifications not implemented");
    }
    
}
