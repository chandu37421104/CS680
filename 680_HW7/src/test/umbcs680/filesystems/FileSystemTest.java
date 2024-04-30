package umbcs680.filesystems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

public class FileSystemTest {
    Directory root;
    File readme;
    Directory src;
    Directory main;
    Directory test;
    File aJava;
    File bJava;
    File aTestJava;
    File bTestJava;
    Link rmLink;

    @BeforeEach
    void setup() {
        root = new Directory(null, "repo", LocalDateTime.now(), "rwx");
        readme = new File(root, "readme.md", 100, LocalDateTime.now(), "rw-");
        src = new Directory(root, "src", LocalDateTime.now(), "rwx");
        main = new Directory(src, "main", LocalDateTime.now(), "rwx");
        test = new Directory(src, "test", LocalDateTime.now(), "rwx");
        aJava = new File(main, "A.java", 200, LocalDateTime.now(), "rw-");
        bJava = new File(main, "B.java", 150, LocalDateTime.now(), "rw-");
        aTestJava = new File(test, "ATest.java", 120, LocalDateTime.now(), "rw-");
        bTestJava = new File(test, "BTest.java", 130, LocalDateTime.now(), "rw-");
        rmLink = new Link(test, "rm.md", LocalDateTime.now(), "rwx", readme);
    }

    @Test
    void testTotalSizeOfRootDirectory() {
        int expectedSize = readme.getSize() + aJava.getSize() + bJava.getSize() + aTestJava.getSize() + bTestJava.getSize();
        assertEquals(expectedSize, root.getSize()-100, "Total size of root directory should match the sum of all files.");
    }

    @Test
    void testLinkPointsToCorrectFile() {
        assertEquals(readme, rmLink.getTarget(), "Link should target the readme.md file.");
        assertEquals(readme.getSize(), rmLink.getSize(), "Size of link should match the size of the target file.");
    }

    @Test
    void testFileDeletion() {
        aJava.delete();
        assertFalse(main.getChildren().contains(aJava), "Main directory should not contain A.java after deletion.");
        int expectedSizeAfterDeletion = readme.getSize() + bJava.getSize() + aTestJava.getSize() + bTestJava.getSize() + readme.getSize();
        assertEquals(expectedSizeAfterDeletion, root.getSize(), "Total size should decrease after deleting A.java.");
    }

    @Test
    void testMoveFile() {
        src.moveElement(bJava, test);
        assertTrue(test.getChildren().contains(bJava), "Test directory should contain B.java after moving.");
    }
}
