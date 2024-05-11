package umbcs680.hw17;
import umbcs680.hw17.fs.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;
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
    void alphabeticalSortingTest() {
        Directory mainDir = TestFixture.main;
        List<File> files = mainDir.getFiles(Comparator.comparing(File::getName));
        assertEquals("A.java", files.get(0).getName(), "Files should be sorted alphabetically by name");
        assertEquals("B.java", files.get(1).getName(), "Files should be sorted alphabetically by name");
    }

    @Test
    void reverseAlphabeticalSortingTest() {
        Directory testDir = TestFixture.test;
        List<File> files = testDir.getFiles(Comparator.comparing(File::getName).reversed());
        assertEquals("BTest.java", files.get(0).getName(), "Files should be sorted in reverse alphabetical order");
        assertEquals("ATest.java", files.get(1).getName(), "Files should be sorted in reverse alphabetical order");
    }

    @Test
    void sizeSortingTest() {
        Directory mainDir = TestFixture.main;
        List<File> files = mainDir.getFiles(Comparator.comparingInt(File::getSize));
        assertTrue(files.get(0).getSize() <= files.get(1).getSize(), "Files should be sorted by size in ascending order");
    }

    @Test
    void timestampSortingTest() {
        Directory srcDir = TestFixture.src;
        List<Directory> directories = srcDir.getSubDirectories(Comparator.comparing(Directory::getCreationTime));
        assertNotNull(directories, "Directories should be present");
        assertTrue(directories.get(0).getCreationTime().isBefore(directories.get(1).getCreationTime()), "Directories should be sorted by timestamp");
    }
}
