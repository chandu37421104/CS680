package umbcs680.filesystems;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FileSystemTest {
    @BeforeAll
    public static void setup() {
        TestFixture.setupFixture();
    }

    @Test
    public void FindDirectoryByNameTest() {
        Directory srcDir = TestFixture.repo.getSubDirectories().stream()
            .filter(dir -> "src".equals(dir.getName()))
            .findFirst()
            .orElse(null);
        assertNotNull(srcDir);
    }

    @Test
    public void FindFileByPathTest() {
        File foundFile = TestFixture.repo.findFileByName("readme.md");
        assertNotNull(foundFile, "File 'readme.md' should be present in the file system");
    }

    @Test
    public void SingletonInstanceTest() {
        FileSystem fs1 = FileSystem.getFileSystem();
        FileSystem fs2 = FileSystem.getFileSystem();

        assertSame(fs1, fs2);
    }
}
