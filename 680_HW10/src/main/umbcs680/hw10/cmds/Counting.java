package umbcs680.hw10.cmds;

import umbcs680.hw10.fs.FSCommand;
import umbcs680.hw10.fs.Directory;
import umbcs680.hw10.util.CountingVisitor;

public class Counting implements FSCommand {
    private final Directory directory;
    private int numFiles;
    private int numDirectories;

    public Counting(Directory directory) {
        this.directory = directory;
    }

    @Override
    public void execute() {
        CountingVisitor visitor = new CountingVisitor();
        directory.accept(visitor);
        numFiles = visitor.getFileCount();
        numDirectories = visitor.getDirectoryCount();
    }

    public int getNumFiles() {
        return numFiles;
    }

    public int getNumDirectories() {
        return numDirectories;
    }
}
