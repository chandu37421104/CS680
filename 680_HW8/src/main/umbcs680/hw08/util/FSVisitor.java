package umbcs680.hw08.util;

import umbcs680.hw08.fs.*;

public interface FSVisitor {
    void visit(Link link);
    void visit(Directory directory);
    void visit(File file);
}
