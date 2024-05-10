package umbcs680.multicastdesign;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Project implements Observable {
    private String projectName;
    private List<Consumer<String>> observers = new ArrayList<>();
    private List<Task> tasks = new ArrayList<>();

    public Project(String projectName) {
        this.projectName = projectName;
    }

    public void addTask(Task task) {
        tasks.add(task);
        notifyObservers("Task '" + task.getTaskDetail() + "' added to project '" + projectName + "'");
    }

    public String getProjectStatus() {
        int totalTasks = tasks.size();
        int completedTasks = (int) tasks.stream().filter(Task::isCompleted).count();
        int pendingTasks = totalTasks - completedTasks;

        return String.format("Project '%s' Status: Total Tasks: %d, Completed: %d, Pending: %d",
                             projectName, totalTasks, completedTasks, pendingTasks);
    }

    public void updateProject(String updateDetails) {
        notifyObservers("Project '" + projectName + "' updated: " + updateDetails);
    }

    public List<Task> getTasks() {
        return this.tasks;
    }

    @Override
    public List<Consumer<String>> getObservers() {
        return observers;
    }

    @Override
    public void attach(Consumer<String> observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Consumer<String> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        observers.forEach(observer -> observer.accept(message));
    }
}

