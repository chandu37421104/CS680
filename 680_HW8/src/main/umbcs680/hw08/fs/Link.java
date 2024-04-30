package umbcs680.hw08.fs;

import java.time.LocalDateTime;
import umbcs680.hw08.util.FSVisitor;

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

    @Override
    public void accept(FSVisitor visitor) {
    visitor.visit(this); // Simply visit the link
    }

}


