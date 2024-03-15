package umbcs680.multicastdesign;

public class TeamManager implements Observer, Commenter {
    private String name;

    public TeamManager(String name) {
        this.name = name;
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
}
