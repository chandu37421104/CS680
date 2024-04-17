package umbcs680.filesystems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


public class FileTest {
    
    private File file;
    
    @BeforeEach
    public void setUp() {
        file = new File(null, "testFile.txt", 200);
    }
    
    @Test
    public void testGetName() {
        assertEquals("testFile.txt", file.getName());
    }

    @Test
    public void testGetSize() {
        assertEquals(200, file.getSize());
    }
    
    @Test
    public void testIsDirectory() {
        assertFalse(file.isDirectory());
    }

    @Test
    public void testGetCreationTime() {
        assertNotNull(file.getCreationTime());
    }
}
