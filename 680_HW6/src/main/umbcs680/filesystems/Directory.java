package umbcs680.filesystems;

import java.time.LocalDateTime;
import java.util.LinkedList;


public class Directory extends FSElement {
   
    private LinkedList<FSElement> children;

    public Directory(Directory parent, String name) {
        super(parent, name, 0); 
        this.children = new LinkedList<>();
    }

    public void appendChild(FSElement child) {
        children.add(child);
        child.parent = this;
    }

    public LinkedList<Directory> getSubDirectories() {
        LinkedList<Directory> subDirs = new LinkedList<>();
        for (FSElement child : children) {
            if (child.isDirectory()) {
                subDirs.add((Directory) child);
            }
        }
        return subDirs;
    }

    public LinkedList<File> getFiles() {
        LinkedList<File> files = new LinkedList<>();
        for (FSElement child : children) {
            if (!child.isDirectory()) {
                files.add((File) child);
            }
        }
        return files;
    }

    public int getTotalSize() {
        int totalSize = 0;
        for (FSElement child : children) {
            totalSize += child.getSize();
            if (child.isDirectory()) {
                totalSize += ((Directory) child).getTotalSize(); 
            }
        }
        return totalSize;
    }

    public LinkedList<FSElement> getChildren() {
        return new LinkedList<>(children); 
    }

    public void removeChild(FSElement child) {
        children.remove(child);
    }

    public FSElement getChildByName(String name) {
        return children.stream()
                .filter(child -> child.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
    
    public void recalculateSize() {
        this.size = children.stream().mapToInt(FSElement::getSize).sum();
        if (parent != null) {
            parent.recalculateSize();
        }
    }

    @Override
    public boolean isDirectory() {
        return true;
    }
}
