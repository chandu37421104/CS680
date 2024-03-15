package umbcs680.multicastdesign;

import java.util.ArrayList;
import java.util.List;

public class ProjectManager implements Observer, Commenter {
    private String name;


    public ProjectManager(String name) {
        this.name = name;
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
   
}
