package umbcs680.hw08.fs;

import java.util.ArrayList;
import java.util.List;

import umbcs680.hw08.util.FSVisitor;

import java.time.LocalDateTime;

public class Directory extends FSElement {
    private List<FSElement> children;

    public Directory(Directory parent, String name, LocalDateTime creationTime, String permissions) {
        super(parent, name, 0, creationTime, permissions);
        children = new ArrayList<>();
    }

    public void addChild(FSElement elem) {
        if (!children.contains(elem)) {
            children.add(elem);
        }
    }
    

    public void removeChild(FSElement child) {
        children.remove(child);
    }

    public File createFile(String name, int size, LocalDateTime creationTime, String permissions) {
        File file = new File(this, name, size, creationTime, permissions);
        return file;
    }

    public Directory createDirectory(String name, LocalDateTime creationTime, String permissions) {
        Directory dir = new Directory(this, name, creationTime, permissions);
        return dir;
    }

    public void moveElement(FSElement element, Directory newParent) {
        this.removeChild(element);
        element.parent = newParent;
        newParent.addChild(element);
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for (FSElement element : children) {
            totalSize += element.getSize();
        }
        return totalSize;
    }

    public List<FSElement> getChildren() {
        return new ArrayList<>(children);
    }

    @Override
    public void accept(FSVisitor visitor) {
    visitor.visit(this);
    for (FSElement child : children) {
        child.accept(visitor); // Recursively accept, ensuring each child is visited only once
    }
    }

    }
