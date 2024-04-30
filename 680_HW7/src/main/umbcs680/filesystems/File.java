package umbcs680.filesystems;

import java.time.LocalDateTime;

public class File extends FSElement {
    public File(Directory parent, String name, int size, LocalDateTime creationTime, String permissions) {
        super(parent, name, size, creationTime, permissions);
    }

    @Override
    public int getSize() {
        return size;
    }
}
