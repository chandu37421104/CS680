package umbcs680.hw08;
import umbcs680.hw08.fs.*;
import umbcs680.hw08.util.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;


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

    @Test
    void DirectoryCountingVisitorTest() {
        CountingVisitor visitor = new CountingVisitor();
        TestFixture.repo.accept(visitor);

        int expectedDirs = 4; 
        assertEquals(expectedDirs, visitor.getDirectoryCount(), "Counts directories including repo, src, main, and test");
    }

    @Test
    void LinkCountingVisitorTest() {
        CountingVisitor visitor = new CountingVisitor();
        TestFixture.repo.accept(visitor);

        int expectedLinks = 1;
        assertEquals(expectedLinks, visitor.getLinkCount(), "Counts one link");
    }

    @Test
    void FilesCountingVisitorTest() {
        CountingVisitor visitor = new CountingVisitor();
        TestFixture.repo.accept(visitor);

        int expectedFiles = 5; 
        assertEquals(expectedFiles, visitor.getFileCount(), "Counts files including readme.md, A.java, B.java, ATest.java, and BTest.java");
    }

    @Test
    void ReadmeFileSearchVisitorTest() {
        FileSearchVisitor searchVisitor = new FileSearchVisitor("readme.md");
        TestFixture.repo.accept(searchVisitor);

        assertEquals(2, searchVisitor.getFoundFiles().size(), "Should find one file named 'readme.md'");
    }

    @Test
    void aJavaFileSearchVisitorTest() {
        FileSearchVisitor searchVisitor = new FileSearchVisitor("A.java");
        TestFixture.repo.accept(searchVisitor);

        assertEquals(1, searchVisitor.getFoundFiles().size(), "Should find one file named 'A.java'");
    }

    @Test
    void FileCrawlingVisitorTest() {
        FileCrawlingVisitor crawlVisitor = new FileCrawlingVisitor();
        TestFixture.repo.accept(crawlVisitor);

        List<String> visitedPaths = crawlVisitor.getVisitedPaths();
        assertTrue(visitedPaths.contains("Visiting directory: repo"));
        assertTrue(visitedPaths.contains("Visiting file: readme.md"));
        assertTrue(visitedPaths.contains("Visiting link: rm.md"));
        assertTrue(visitedPaths.contains("Visiting file: A.java"));
        assertTrue(visitedPaths.contains("Visiting file: B.java"));
        assertTrue(visitedPaths.contains("Visiting file: ATest.java"));
        assertTrue(visitedPaths.contains("Visiting file: BTest.java"));
    }
}
