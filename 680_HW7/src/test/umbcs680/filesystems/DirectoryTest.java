package umbcs680.filesystems;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

public class DirectoryTest {
    private Directory root;
    private Directory src;
    private Directory main;
    private File aJava;
    private File bJava;

    @BeforeEach
    void setup() {
        root = new Directory(null, "repo", LocalDateTime.now(), "rwx");
        src = new Directory(root, "src", LocalDateTime.now(), "rwx");
        main = new Directory(src, "main", LocalDateTime.now(), "rwx");
        aJava = new File(main, "A.java", 200, LocalDateTime.now(), "rw-");
        bJava = new File(main, "B.java", 150, LocalDateTime.now(), "rw-");
    }

    @Test
    void AddingChildToDirectoryTest() {
        assertEquals(2, main.getChildren().size(), "Main directory should contain two files initially.");
        File newFile = new File(main, "C.java", 100, LocalDateTime.now(), "rw-");
        main.addChild(newFile);
        assertEquals(4, main.getChildren().size(), "Main directory should contain three files after adding one.");
    }

    @Test
    void RemovingChildFromDirectoryTest() {
        main.removeChild(aJava);
        assertEquals(1, main.getChildren().size(), "Main directory should have one file after removal.");
        assertFalse(main.getChildren().contains(aJava), "Main directory should not contain A.java after it is removed.");
    }

    @Test
    void GetFileSizeTest() {
        int expectedSize = aJava.getSize() + bJava.getSize();
        assertEquals(expectedSize, main.getSize(), "Size of the main directory should be the sum of its files' sizes.");
    }
}
