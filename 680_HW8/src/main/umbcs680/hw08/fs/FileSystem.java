package umbcs680.hw08.fs;

import java.util.ArrayList;
import java.util.List;

public class FileSystem {
    private static FileSystem instance = new FileSystem();
    private List<Directory> rootDirs;

    private FileSystem() {
        rootDirs = new ArrayList<>();
    }

    public static FileSystem getInstance() {
        return instance;
    }

    public void addRootDir(Directory dir) {
        rootDirs.add(dir);
    }

    public List<Directory> getRootDirs() {
        return new ArrayList<>(rootDirs);
    }
}
