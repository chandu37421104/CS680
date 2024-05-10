package umbcs680.hw12.fs;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Directory extends FSElement {
    private List<FSElement> children;

    public Directory(Directory parent, String name, LocalDateTime creationTime) {
        super(parent, name, 0, creationTime);
        this.children = new LinkedList<>();
    }

    public void appendChild(FSElement child) {
        child.setParent(this);
        children.add(child);
        // Ensure the default alphabetical ordering is maintained
        Collections.sort(children, new AlphabeticalComparator());
    }

    public List<FSElement> getChildren() {
        // Return children sorted by default alphabetical ordering
        return getChildren(new AlphabeticalComparator());
    }

    public List<FSElement> getChildren(Comparator<FSElement> comparator) {
        List<FSElement> sortedChildren = new LinkedList<>(children);
        Collections.sort(sortedChildren, comparator);
        return sortedChildren;
    }

    public List<Directory> getSubDirectories() {
        return getSubDirectories(new AlphabeticalComparator());
    }

    public List<Directory> getSubDirectories(Comparator<FSElement> comparator) {
        List<Directory> subDirs = new LinkedList<>();
        for (FSElement elem : children) {
            if (elem instanceof Directory) {
                subDirs.add((Directory) elem);
            }
        }
        Collections.sort(subDirs, comparator);
        return subDirs;
    }

    public List<File> getFiles() {
        return getFiles(new AlphabeticalComparator());
    }

    public List<File> getFiles(Comparator<FSElement> comparator) {
        List<File> files = new LinkedList<>();
        for (FSElement elem : children) {
            if (elem instanceof File) {
                files.add((File) elem);
            }
        }
        Collections.sort(files, comparator);
        return files;
    }

    public List<Link> getLinks() {
        return getLinks(new AlphabeticalComparator());
    }

    public List<Link> getLinks(Comparator<FSElement> comparator) {
        List<Link> links = new LinkedList<>();
        for (FSElement elem : children) {
            if (elem instanceof Link) {
                links.add((Link) elem);
            }
        }
        Collections.sort(links, comparator);
        return links;
    }

    public int countChildren() {
        return children.size();
    }

    public int countFiles() {
        return getFiles().size();
    }

    public int countSubDirectories() {
        return getSubDirectories().size();
    }

    public int countLinks() {
        return getLinks().size();
    }

    public int getTotalSize() {
        int totalSize = 0;
        for (FSElement elem : children) {
            totalSize += elem.getSize();
            if (elem instanceof Directory) {
                totalSize += ((Directory) elem).getTotalSize();
            }
        }
        return totalSize;
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public String getPath() {
        StringBuilder path = new StringBuilder(name);
        Directory currentParent = parent;

        while (currentParent != null) {
            path.insert(0, currentParent.getName() + "/");
            currentParent = currentParent.getParent();
        }

        return path.toString();
    }

    public boolean contains(FSElement child) {
        return children.contains(child);
    }

    public File findFileByName(String name) {
        for (FSElement element : children) {
            if (element instanceof File && name.equals(element.getName())) {
                return (File) element;
            }
            if (element instanceof Directory) {
                File foundFile = ((Directory) element).findFileByName(name);
                if (foundFile != null) {
                    return foundFile;
                }
            }
        }
        return null;
    }

    @Override
    public void accept(FSVisitor visitor) {
        visitor.visit(this);
        for (FSElement child : children) {
            child.accept(visitor);
        }
    }
}
