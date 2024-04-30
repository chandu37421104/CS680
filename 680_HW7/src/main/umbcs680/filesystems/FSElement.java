package umbcs680.filesystems;

import java.time.LocalDateTime;

public abstract class FSElement {
    protected Directory parent;
    protected String name;
    protected int size;
    protected LocalDateTime creationTime;
    protected String permissions;

    public FSElement(Directory parent, String name, int size, LocalDateTime creationTime, String permissions) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
        this.permissions = permissions;
        if (parent != null) {
            parent.addChild(this);
        }
    }

    public abstract int getSize();

    public void delete() {
        if (parent != null) {
            parent.removeChild(this);
        }
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public Directory getParent() {
        return parent;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }


    public boolean isDirectory() {
        return this instanceof Directory;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }
}
