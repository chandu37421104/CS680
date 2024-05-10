package umbcs680.hw12.util;

import umbcs680.hw12.fs.*;

import java.util.ArrayList;
import java.util.List;

public class FileCrawlingVisitor implements FSVisitor {
    private List<String> visitedPaths = new ArrayList<>();

    @Override
    public void visit(File file) {
        visitedPaths.add("Visiting file: " + file.getName());
    }

    @Override
    public void visit(Directory directory) {
        visitedPaths.add("Visiting directory: " + directory.getName());
        for (FSElement child : directory.getChildren()) {
            child.accept(this);
        }
    }

    @Override
    public void visit(Link link) {
        visitedPaths.add("Visiting link: " + link.getName());
        
        FSElement target = link.getTarget();
        if (target != null) {
            target.accept(this);
        }
    }

    public List<String> getVisitedPaths() {
        return visitedPaths;
    }

}
