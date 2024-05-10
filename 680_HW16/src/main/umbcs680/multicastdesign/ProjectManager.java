package umbcs680.multicastdesign;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ProjectManager implements Commenter {
    private String name;
    private List<String> notifications;

    public ProjectManager(String name) {
        this.name = name;
        this.notifications = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void attachToObservable(Observable observable) {
        Consumer<String> notificationReceiver = message -> {
            System.out.println("ProjectManager " + name + " received update: " + message);
            notifications.add(message);
        };
        observable.attach(notificationReceiver);
    }

    @Override
    public void comment(Task task, String commentText) {
        task.addComment(name, commentText);
    }

    public List<String> getNotifications() {
        return new ArrayList<>(notifications);
    }
}
