package umbcs680.hw17.fs;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class FileSystem {
    private static FileSystem instance = null;
    private List<Directory> rootDirs;

    private FileSystem() {
        this.rootDirs = new LinkedList<>();
    }

    public static FileSystem getFileSystem() {
        if (instance == null) {
            instance = new FileSystem();
        }
        return instance;
    }

    public List<Directory> getRootDirs() {
        return rootDirs;
    }

    public void appendRootDir(Directory root) {
        rootDirs.add(root);
    }


    public Directory findDirectoryByName(String name) {
        return rootDirs.stream()
                       .filter(dir -> dir.getName().equals(name))
                       .findFirst()
                       .orElse(null);
    }

    public File findFileByPath(String path) {
        String[] parts = path.split("/");
        Optional<Directory> currentDir = Optional.ofNullable(findDirectoryByName(parts[0]));
    
        if (currentDir.isEmpty()) {
            return null;
        }
    
        
        for (int i = 1; i < parts.length - 1; i++) {
            final String part = parts[i];
            currentDir = currentDir.flatMap(dir -> dir.getSubDirectories()
                                                      .stream()
                                                      .filter(subDir -> subDir.getName().equals(part))
                                                      .findFirst());
            if (currentDir.isEmpty()) {
                return null; 
            }
        }
    

        return currentDir.flatMap(dir -> dir.getFiles()
                                            .stream()
                                            .filter(file -> file.getName().equals(parts[parts.length - 1]))
                                            .findFirst())
                         .orElse(null);
    }
    
}

