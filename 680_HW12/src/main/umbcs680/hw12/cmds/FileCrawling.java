package umbcs680.hw12.cmds;

import umbcs680.hw12.fs.FSCommand;
import umbcs680.hw12.fs.Directory;
import umbcs680.hw12.util.FileCrawlingVisitor;

import java.util.List;

public class FileCrawling implements FSCommand {
    private final Directory directory;
    private List<String> visitedPaths;

    public FileCrawling(Directory directory) {
        this.directory = directory;
    }

    @Override
    public void execute() {
        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        directory.accept(visitor);
        visitedPaths = visitor.getVisitedPaths();
    }

    public List<String> getVisitedPaths() {
        return visitedPaths;
    }
}
