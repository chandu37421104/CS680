package umbcs680.hw08;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import umbcs680.hw08.fs.*;
import umbcs680.hw08.util.*;
import java.time.LocalDateTime;
import java.util.List;

class FileSystemTest {

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
        root.addChild(src);
        src.addChild(main);
        src.addChild(test);
        main.addChild(aJava);
        main.addChild(bJava);
        test.addChild(aTestJava);
        test.addChild(bTestJava);
        test.addChild(rmLink);
    }

    @Test
    void TotalCountingVisitorTest() {
    CountingVisitor visitor = new CountingVisitor();
    root.accept(visitor);

    int expectedDirs = 4; 
    int expectedFiles = 5; 
    int expectedLinks = 1; 

    assertEquals(expectedDirs, visitor.getNumDirs(), "Counts directories including root, src, main, and test");
    assertEquals(expectedFiles, visitor.getNumFiles(), "Counts files including readme, A.java, B.java, ATest.java, BTest.java");
    assertEquals(expectedLinks, visitor.getNumLinks(), "Counts one link");

    int totalExpected = expectedDirs + expectedFiles + expectedLinks;
    int totalActual = visitor.getNumDirs() + visitor.getNumFiles() + visitor.getNumLinks();
    assertEquals(totalExpected, totalActual, "Total count of elements should match individual counts");
    }
    
    @Test
    void DirectoryCountingVisitorTest() {
    CountingVisitor visitor = new CountingVisitor();
    root.accept(visitor);
    int expectedDirs = 4; 
    assertEquals(expectedDirs, visitor.getNumDirs(), "Counts directories including root, src, main, and test");
    }

    @Test
    void LinkCountingVisitorTest() {
    CountingVisitor visitor = new CountingVisitor();
    root.accept(visitor);
    int expectedLinks = 1; 
    assertEquals(expectedLinks, visitor.getNumLinks(), "Counts one link");
    }

    @Test
    void FilesCountingVisitorTest() {
    CountingVisitor visitor = new CountingVisitor();
    root.accept(visitor);
    int expectedFiles = 5; 
    assertEquals(expectedFiles, visitor.getNumFiles(), "Counts files including readme, A.java, B.java, ATest.java, BTest.java");
    }

    @Test
    void ReadmeFileSearchVisitorTest() {
        FileSearchVisitor searchVisitor = new FileSearchVisitor("readme.md");
        root.accept(searchVisitor);
        assertEquals(1, searchVisitor.getFoundFiles().size(), "Should find one file named 'readme.md'");
    }
    
    @Test
    void aJavaFileSearchVisitorTest() {
        FileSearchVisitor searchVisitor = new FileSearchVisitor("A.java");
        root.accept(searchVisitor);
        assertEquals(1, searchVisitor.getFoundFiles().size(), "Should find one file named 'A.java'");
    }


    @Test
void FileCrawlingVisitorTest() {
    FileCrawlingVisitor crawlVisitor = new FileCrawlingVisitor();
    root.accept(crawlVisitor);

    List<String> visitedPaths = crawlVisitor.getVisitedPaths();
    assertTrue(visitedPaths.contains("Visiting directory: repo"));
    assertTrue(visitedPaths.contains("Visiting file: readme.md"));
    assertTrue(visitedPaths.contains("Visiting link: rm.md"));
}
}
