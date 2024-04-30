package umbcs680.hw08.util;

import umbcs680.hw08.fs.*;

public interface FSVisitor {
    void visit(File file);
    void visit(Directory dir);
    void visit(Link link);
}
