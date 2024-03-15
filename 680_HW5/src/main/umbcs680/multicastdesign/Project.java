package umbcs680.multicastdesign;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Project implements Observable {
    private String projectName;
    private List<Observer> observers = new ArrayList<>();
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

        return "Project '" + projectName + "' Status: Total Tasks: " + totalTasks +
                ", Completed: " + completedTasks + ", Pending: " + pendingTasks;
    }

    public void updateProject(String updateDetails) {
        notifyObservers("Project '" + projectName + "' updated: " + updateDetails);
    }
    public List<Task> getTasks() {
        return this.tasks;
    }

    @Override
    public List<Observer> getObservers() {
        return observers;
    }
}
