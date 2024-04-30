package umbcs680.hw08.util;

import umbcs680.hw08.fs.*;
import java.util.ArrayList;
import java.util.List;

import umbcs680.hw08.fs.*;
import java.util.ArrayList;
import java.util.List;

public class FileCrawlingVisitor implements FSVisitor {
    private List<String> visitedPaths = new ArrayList<>();

    @Override
    public void visit(File file) {
        visitedPaths.add("Visiting file: " + file.getName());
    }

    @Override
    public void visit(Directory dir) {
        visitedPaths.add("Visiting directory: " + dir.getName());
    }

    @Override
    public void visit(Link link) {
        visitedPaths.add("Visiting link: " + link.getName());
    }

    public List<String> getVisitedPaths() {
        return visitedPaths;
    }
}
