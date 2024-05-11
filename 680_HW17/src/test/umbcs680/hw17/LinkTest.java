package umbcs680.hw17;
import umbcs680.hw17.fs.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class LinkTest {
    @BeforeAll
    public static void setup() {
        TestFixture.setupFixture();
    }

    @Test
    public void LinkPointsToCorrectTargetTest() {
        assertEquals("readme.md", TestFixture.rmMdLink.getTarget().getName());
    }

    @Test
    public void LinkSizeIsTargetSizeTest() {
        assertEquals(TestFixture.readme.getSize(), TestFixture.rmMdLink.getSize());
    }

    @Test
    public void LinkPathTest() {
        assertEquals("/rm.md/test/src/repo", TestFixture.rmMdLink.getPath());
    }

    @Test
    public void LinkIsNotDirectoryTest() {
        assertFalse(TestFixture.rmMdLink.isDirectory());
    }

    @Test
    public void LinkTargetIsFileTest() {
        assertTrue(TestFixture.rmMdLink.getTarget() instanceof File);
    }
}
