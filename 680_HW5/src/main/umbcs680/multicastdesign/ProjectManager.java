package umbcs680.multicastdesign;

import java.util.ArrayList;
import java.util.List;

public class ProjectManager implements Observer, Commenter {
    private String name;
    private List<String> notifications;

    public ProjectManager(String name) {
        this.name = name;
        this.notifications = new ArrayList<>();
    }
    public String getName() {
        return this.name;
    }

    @Override
    public void update(String message) {
        System.out.println("ProjectManager " + name + " received update: " + message);
    }

    @Override
    public void comment(Task task, String commentText) {
        task.addComment(name, commentText);
    }
    public List<String> getNotifications() {
        return new ArrayList<>(notifications);
    }
   
}
