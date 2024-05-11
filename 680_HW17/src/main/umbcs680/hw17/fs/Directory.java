package umbcs680.hw17.fs;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.LinkedList;

public class Directory extends FSElement {
    private List<FSElement> children;

    public Directory(Directory parent, String name, LocalDateTime creationTime) {
        super(parent, name, 0, creationTime);
        this.children = new LinkedList<>();
    }

    public void appendChild(FSElement child) {
        child.setParent(this);
        children.add(child);
        children.sort((c1, c2) -> c1.getName().compareTo(c2.getName()));
    }

    public List<FSElement> getChildren(Comparator<FSElement> comparator) {
        return children.stream().sorted(comparator).collect(Collectors.toList());
    }
    public boolean contains(FSElement element) {
        return children.contains(element);
    }

    public List<Directory> getSubDirectories() {
        return getSubDirectories(Comparator.comparing(Directory::getName)); // Simplify by reusing the other method
    }
    
    public List<Directory> getSubDirectories(Comparator<Directory> comparator) {
        return children.stream()
                       .filter(Directory.class::isInstance)
                       .map(Directory.class::cast)
                       .sorted(comparator)
                       .collect(Collectors.toList());
    }
    

    public List<File> getFiles() {
        return getFiles(Comparator.comparing(File::getName)); // Simplify by reusing the other method
    }
    
    public List<File> getFiles(Comparator<File> comparator) {
        return children.stream()
                       .filter(File.class::isInstance)
                       .map(File.class::cast)
                       .sorted(comparator)
                       .collect(Collectors.toList());
    }
    

    public List<Link> getLinks(Comparator<Link> comparator) {
        return children.stream()
                       .filter(Link.class::isInstance)
                       .map(Link.class::cast)
                       .sorted(comparator)
                       .collect(Collectors.toList());
    }
    

    public int getTotalSize() {
        return children.stream()
                       .mapToInt(FSElement::getSize)
                       .sum() + children.stream()
                       .filter(Directory.class::isInstance)
                       .mapToInt(d -> ((Directory) d).getTotalSize())
                       .sum();
    }

    public File findFileByName(String name) {
        return children.stream()
                       .filter(e -> e instanceof File && e.getName().equals(name))
                       .map(File.class::cast)
                       .findFirst()
                       .orElseGet(() -> children.stream()
                                                .filter(Directory.class::isInstance)
                                                .map(Directory.class::cast)
                                                .map(d -> d.findFileByName(name))
                                                .filter(java.util.Objects::nonNull)
                                                .findFirst()
                                                .orElse(null));
    }

    public List<FSElement> getChildrenByName() {
        return getChildren(Comparator.comparing(FSElement::getName));
    }

    public List<FSElement> getChildrenByReverseName() {
        return getChildren(Comparator.comparing(FSElement::getName).reversed());
    }

    public List<FSElement> getChildrenBySize() {
        return getChildren(Comparator.comparingInt(FSElement::getSize));
    }

    public List<FSElement> getChildrenByTimestamp() {
        return getChildren(Comparator.comparing(FSElement::getCreationTime));
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public String getPath() {
        if (parent == null) {
            return "/" + name;
        } else {
            return parent.getPath() + "/" + name;
        }
    }
    
}
