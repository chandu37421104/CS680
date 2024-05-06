package umbcs680.wiser;

public class Session extends CourseComponent {
    private String title;

    public Session(String title) {
        this.title = title;
    }

    @Override
    public void display() {
        System.out.println("Session: " + title);
    }

    public String gettitle() {
        return title;
    }
}