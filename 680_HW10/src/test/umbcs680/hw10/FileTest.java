package umbcs680.hw10;
import umbcs680.hw10.fs.*;
import umbcs680.hw10.util.*;
import umbcs680.hw10.cmds.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FileTest {
    @BeforeAll
    public static void setup() {
        TestFixture.setupFixture();
    }

    @Test
    public void readmeFileSizeTest() {
        assertEquals(20, TestFixture.readme.getSize());
    }

    @Test
    public void aJavaFileSizeTest() {
        assertEquals(120, TestFixture.aJava.getSize());
    }

    @Test
    public void bJavaFileSizeTest() {
        assertEquals(80, TestFixture.bJava.getSize());
    }

    @Test
    public void aTestJavaFileSizeTest() {
        assertEquals(140, TestFixture.aTestJava.getSize());
    }

    @Test
    public void bTestJavaFileSizeTest() {
        assertEquals(60, TestFixture.bTestJava.getSize());
    }

    @Test
    public void AJavaPathTest() {
        assertEquals("repo/src/main/A.java", TestFixture.aJava.getPath());
    }

    @Test
    public void ATestJavaPathTest() {
        assertEquals("repo/src/test/ATest.java", TestFixture.aTestJava.getPath());
    }
}
