
package umbcs680.multicastdesign;

import java.util.ArrayList;
import java.util.List;

public class TeamMember implements Observer, Commenter {
    private String name;
    private List<String> notifications; 

    public TeamMember(String name) {
        this.name = name;
        this.notifications = new ArrayList<>();

    }
    public String getName() {
        return this.name;
    }

    @Override
    public void update(String message) {
        notifications.add(message);
        System.out.println(name + " received an update: " + message);
    }

    @Override
    public void comment(Task task, String comment) {
        task.addComment(name, comment);
    }

    public void displayNotifications() {
        System.out.println("Notifications for " + name + ":");
        for (String notification : notifications) {
            System.out.println("\t- " + notification);
        }
    }
    public List<String> getNotifications() {
        return new ArrayList<>(notifications); 
    }
}

