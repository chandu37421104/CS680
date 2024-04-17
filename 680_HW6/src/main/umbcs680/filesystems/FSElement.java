package umbcs680.filesystems;

import java.time.LocalDateTime;

public abstract class FSElement {
    protected String name;
    protected int size;
    protected LocalDateTime creationTime;
    protected Directory parent;

    
    public FSElement(Directory parent, String name, int size) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = LocalDateTime.now();
    }

    
    public abstract boolean isDirectory();

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public Directory getParent() {
        return parent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(int size) {
        this.size = size;
    }

  
    public void setParent(Directory parent) {
        this.parent = parent;
    }
}
