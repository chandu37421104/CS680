package umbcs680.hw10.cmds;

import umbcs680.hw10.fs.FSCommand;
import umbcs680.hw10.fs.Directory;
import umbcs680.hw10.util.FileSearchVisitor;
import umbcs680.hw10.fs.File;

import java.util.List;

public class FileSearch implements FSCommand {
    private final Directory directory;
    private final String fileName;
    private List<File> foundFiles;

    public FileSearch(Directory directory, String fileName) {
        this.directory = directory;
        this.fileName = fileName;
    }

    @Override
    public void execute() {
        FileSearchVisitor visitor = new FileSearchVisitor(fileName);
        directory.accept(visitor);
        foundFiles = visitor.getFoundFiles();
    }

    public List<File> getFoundFiles() {
        return foundFiles;
    }
}
