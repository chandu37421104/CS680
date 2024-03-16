package umbcs680.multicastdesign;
import java.util.List;
import java.util.ArrayList;
public class TeamManager implements Observer, Commenter {
    private String name;
    private List<String> notifications;

    public TeamManager(String name) {
        this.name = name;
        this.notifications = new ArrayList<>();
    }
    public String getName() {
        return this.name;
    } 
    @Override
    public void update(String message) {
        System.out.println("TeamManager " + name + " received update: " + message);
    }

    @Override
    public void comment(Task task, String commentText) {
        task.addComment(name, commentText);
    }

    public List<String> getNotifications() {
        return new ArrayList<>(notifications);
    }
        

}

