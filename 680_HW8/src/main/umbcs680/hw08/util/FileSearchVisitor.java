package umbcs680.hw08.util;

import umbcs680.hw08.fs.*;
import java.util.LinkedList;
import java.util.List;

public class FileSearchVisitor implements FSVisitor {
    private String fileName;
    private List<File> foundFiles = new LinkedList<>();

    public FileSearchVisitor(String fileName) {
        this.fileName = fileName;
    }

    public void visit(File file) {
        if (file.getName().equals(fileName)) {
            foundFiles.add(file);
        }
    }

    public void visit(Directory dir) {}
    public void visit(Link link) {}

    public List<File> getFoundFiles() {
        return foundFiles;
    }
}
