package umbcs680.wiser;

import java.util.ArrayList;
import java.util.List;

public class Course extends CourseComponent {
    private String name;
    private List<CourseComponent> components = new ArrayList<>();

    public Course(String name) {
        this.name = name;
    }

    @Override
    public void add(CourseComponent component) {
        components.add(component);
    }

    @Override
    public void remove(CourseComponent component) {
        components.remove(component);
    }

    public boolean hasChild(CourseComponent component) {
        return components.contains(component);
    }

    public CourseComponent getChild(int index) {
        if (index >= 0 && index < components.size()) {
            return components.get(index);
        }
        return null;
    }

    public String getName() {
        return name;
    }

    @Override
    public void display() {
        System.out.println("Course: " + name);
        for (CourseComponent component : components) {
            component.display();
        }
    }
}