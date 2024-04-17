package umbcs680.filesystems;

import java.time.LocalDateTime;

public class File extends FSElement {

    public File(Directory parent, String name, int size) {
        super(parent, name, size);
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public void setName(String name) {
        this.name = name;
       
    }

    @Override
    public void setSize(int size) {
        this.size = size;
        if (parent != null) {
            parent.recalculateSize();
        }
    }
}

