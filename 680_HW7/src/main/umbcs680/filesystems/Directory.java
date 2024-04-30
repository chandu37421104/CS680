package umbcs680.filesystems;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class Directory extends FSElement {
    private List<FSElement> children;  // This holds the elements in the directory

    public Directory(Directory parent, String name, LocalDateTime creationTime, String permissions) {
        super(parent, name, 0, creationTime, permissions);
        children = new ArrayList<>();  // Initialize the list of children
    }

    public void addChild(FSElement child) {
        children.add(child);  // Add a child element to the directory
    }

    public void removeChild(FSElement child) {
        children.remove(child);  // Remove a child element from the directory
    }

    public File createFile(String name, int size, LocalDateTime creationTime, String permissions) {
        File file = new File(this, name, size, creationTime, permissions);
        this.addChild(file);  // Add the newly created file to children
        return file;
    }

    public Directory createDirectory(String name, LocalDateTime creationTime, String permissions) {
        Directory dir = new Directory(this, name, creationTime, permissions);
        this.addChild(dir);  // Add the newly created directory to children
        return dir;
    }

    public void moveElement(FSElement element, Directory newParent) {
        this.removeChild(element);  // Remove element from current directory
        newParent.addChild(element);  // Add element to the new directory
        element.setParent(newParent);  // Set the new parent for the element
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for (FSElement element : children) {  // Iterate over children to calculate total size
            if (!(element instanceof Link)) {  // Only count size if the element is not a Link
                totalSize += element.getSize();
            }
        }
        return totalSize;
    }

    public List<FSElement> getChildren() {
        return new ArrayList<>(children);  // Return a copy of the children list
    }
}
