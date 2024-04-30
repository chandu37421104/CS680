package umbcs680.filesystems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

public class FileTest {
    private Directory main;
    private File aJava;

    @BeforeEach
    void setup() {
        main = new Directory(null, "main", LocalDateTime.now(), "rwx");
        aJava = new File(main, "A.java", 200, LocalDateTime.now(), "rw-");
    }

    @Test
    void testGetSize() {
        assertEquals(200, aJava.getSize(), "The size of A.java should be 200.");
    }

    @Test
    void testDelete() {
        aJava.delete();
        assertFalse(main.getChildren().contains(aJava), "Main directory should not contain A.java after it is deleted.");
        assertEquals(0, main.getSize(), "Size of the main directory should be 0 after deleting A.java.");
    }

    @Test
    void testMoveFile() {
        Directory test = new Directory(null, "test", LocalDateTime.now(), "rwx");
        main.moveElement(aJava, test);
        assertTrue(test.getChildren().contains(aJava), "Test directory should contain A.java after moving.");
        assertFalse(main.getChildren().contains(aJava), "Main directory should not contain A.java after it has been moved.");
        assertEquals(0, main.getSize(), "Size of the main directory should be 0 after moving out A.java.");
        assertEquals(200, test.getSize(), "Size of the test directory should be 200 after adding A.java.");
    }
}
