package umbcs680.multicastdesign;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class TeamMember implements Commenter {
    private String name;
    private List<String> notifications;

    public TeamMember(String name) {
        this.name = name;
        this.notifications = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void attachToObservable(Observable observable) {
        Consumer<String> notificationReceiver = message -> {
            System.out.println(name + " received an update: " + message);
            notifications.add(message);
        };
        observable.attach(notificationReceiver);
    }

    @Override
    public void comment(Task task, String commentText) {
        task.addComment(name, commentText);
    }

    public void displayNotifications() {
        System.out.println("Notifications for " + name + ":");
        notifications.forEach(notification -> System.out.println("\t- " + notification));
    }

    public List<String> getNotifications() {
        return new ArrayList<>(notifications);
    }
}


