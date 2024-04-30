package umbcs680.hw08.util;

import umbcs680.hw08.fs.*;

public class CountingVisitor implements FSVisitor {
    private int numFiles = 0;
    private int numDirs = 0;
    private int numLinks = 0;

    @Override
public void visit(File file) {
    System.out.println("Visiting file: " + file.getName());
    numFiles++;
}

@Override
public void visit(Directory dir) {
    System.out.println("Visiting directory: " + dir.getName());
    numDirs++;
}

@Override
public void visit(Link link) {
    System.out.println("Visiting link: " + link.getName());
    numLinks++;
}


    public int getNumFiles() {
        return numFiles;
    }

    public int getNumDirs() {
        return numDirs;
    }

    public int getNumLinks() {
        return numLinks;
    }
}
