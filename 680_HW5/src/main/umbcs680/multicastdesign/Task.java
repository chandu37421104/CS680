package umbcs680.multicastdesign;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task implements Observable {
    private String taskDetail;
    private boolean isCompleted = false;
    private List<Comment> comments = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    
    public Task(String taskDetail) {
        this.taskDetail = taskDetail;
    }

    public void addComment(String commenterName, String commentText) {
        Comment comment = new Comment(commenterName, commentText);
        comments.add(comment);
        notifyObservers(commenterName + " commented: " + commentText);
    }

    @Override
    public List<Observer> getObservers() {
        return observers;
    }

    @Override
    public void attach(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void displayTaskDetails() {
        System.out.println("Task: " + taskDetail + " | Completed: " + isCompleted);
        for (Comment comment : comments) {
            System.out.println("\t" + comment);
        }
    }

    public String getTaskDetail() {
        return taskDetail;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void completeTask() {
        if (!isCompleted) {
            this.isCompleted = true;
            notifyObservers("Task '" + taskDetail + "' marked as completed.");
        }
    }

    public boolean checkObserverNames(Task task, List<String> expectedNames) {
        List<String> actualObserverNames = task.getObservers().stream()
            .map(observer -> {
                if (observer instanceof ProjectManager) {
                    return ((ProjectManager) observer).getName();
                } else if (observer instanceof TeamManager) {
                    return ((TeamManager) observer).getName();
                } else if (observer instanceof TeamMember) {
                    return ((TeamMember) observer).getName();
                } else {
                    return ""; 
                }
            })
            .collect(Collectors.toList());

        return actualObserverNames.containsAll(expectedNames) && expectedNames.containsAll(actualObserverNames);
    }
}
