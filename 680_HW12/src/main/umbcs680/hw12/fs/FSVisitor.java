package umbcs680.hw12.fs;

public interface FSVisitor {
    void visit(Directory directory);
    void visit(File file);
    void visit(Link link);
}
