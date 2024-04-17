package umbcs680.filesystems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FileSystemTest {

    private FileSystem fileSystem;
    private Directory root;

    @BeforeEach
    public void setUp() {
        fileSystem = FileSystem.getFileSystem();
        root = new Directory(null, "root");
        fileSystem.addDrive("C", root);
    }

    @Test
    public void testSingletonInstance() {
        FileSystem anotherFileSystem = FileSystem.getFileSystem();
        assertSame(fileSystem, anotherFileSystem);
    }

    @Test
    public void testAddDrive() {
        Directory anotherRoot = new Directory(null, "anotherRoot");
        fileSystem.addDrive("D", anotherRoot);
        assertNotNull(fileSystem.getDrive("D"));
        assertSame(anotherRoot, fileSystem.getDrive("D"));
    }
}

