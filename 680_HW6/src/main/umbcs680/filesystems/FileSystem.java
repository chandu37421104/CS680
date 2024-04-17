package umbcs680.filesystems;
import java.util.LinkedList;
import java.util.HashMap;

public class FileSystem {
    private static volatile FileSystem instance;
    private HashMap<String, Directory> drives;

    private FileSystem() {
        drives = new HashMap<>();
    }

    public static FileSystem getFileSystem() {
        if (instance == null) {
            synchronized (FileSystem.class) {
                if (instance == null) {
                    instance = new FileSystem();
                }
            }
        }
        return instance;
    }

    public void addDrive(String driveLetter, Directory root) {
        drives.put(driveLetter.toUpperCase(), root);
    }

    public Directory getDrive(String driveLetter) {
        return drives.get(driveLetter.toUpperCase());
    }
}
