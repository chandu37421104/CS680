package umbcs680.hw10.fs;

public interface FSVisitor {
    void visit(Directory directory);
    void visit(File file);
    void visit(Link link);
}
