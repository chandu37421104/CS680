package umbcs680.hw08.fs;

import java.time.LocalDateTime;

import umbcs680.hw08.util.FSVisitor;

public class File extends FSElement {
    public File(Directory parent, String name, int size, LocalDateTime creationTime, String permissions) {
        super(parent, name, size, creationTime, permissions);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void accept(FSVisitor visitor) {
    visitor.visit(this); 
    }
}
