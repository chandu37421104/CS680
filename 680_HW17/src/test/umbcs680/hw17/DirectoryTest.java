package umbcs680.hw17;
import umbcs680.hw17.fs.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class DirectoryTest {
    @BeforeAll
    public static void setup() {
        TestFixture.setupFixture();
    }

    @Test
    public void testDirectoryContainsFiles() {
        assertTrue(TestFixture.main.contains(TestFixture.main.findFileByName("A.java")));
        assertTrue(TestFixture.test.contains(TestFixture.test.findFileByName("ATest.java")));
    }

    @Test
    public void testGetFiles() {
        assertEquals(2, TestFixture.main.getFiles().size());
        assertEquals(2, TestFixture.test.getFiles().size());
    }

    @Test
    public void testGetPath() {
        assertEquals("/repo/src/main", TestFixture.main.getPath());
    }

}
