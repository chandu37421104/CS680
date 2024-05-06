package umbcs680.wiser;

import java.util.ArrayList;
import java.util.List;

public class WeeklySessions extends CourseComponent {
    private List<CourseComponent> sessions = new ArrayList<>();

    @Override
    public void add(CourseComponent session) {
        sessions.add(session);
    }

    @Override
    public void remove(CourseComponent session) {
        sessions.remove(session);
    }

    public int getChildCount() {
        return sessions.size();
    }

    @Override
    public void display() {
        System.out.println("Displaying weekly sessions:");
        for (CourseComponent session : sessions) {
            session.display();
        }
    }
}