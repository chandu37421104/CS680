package umbcs680.filesystems;

import java.time.LocalDateTime;

public class Link extends FSElement {
    private FSElement target;

    public Link(Directory parent, String name, LocalDateTime creationTime, String permissions, FSElement target) {
        super(parent, name, 0, creationTime, permissions);
        this.target = target;
    }

    @Override
    public int getSize() {
        return target.getSize();
    }

    public FSElement getTarget() {
        return target;
    }
}


