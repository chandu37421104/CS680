package umbcs680.hw17.fs;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Objects;

public class Link extends FSElement {
    private FSElement target;

    public Link(Directory parent, String name, LocalDateTime creationTime, FSElement target) {
        super(parent, name, 0, creationTime);
        this.target = target;
    }

    public FSElement getTarget() {
        return target;
    }

    public void setTarget(FSElement target) {
        this.target = target;
    }

    @Override
    public boolean isDirectory() {
        return false;  
    }

    @Override
    public int getSize() {
        return target.getSize();
    }

    @Override
    public String getPath() {
        return Stream.iterate(this, FSElement::getParent)
                     .takeWhile(Objects::nonNull)
                     .map(FSElement::getName)
                     .collect(Collectors.joining("/", "/", ""));
    }
}

