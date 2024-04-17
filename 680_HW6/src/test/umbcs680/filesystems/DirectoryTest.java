package umbcs680.filesystems;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;


public class DirectoryTest {

    private Directory root;
    private File fileA, fileB, readme;
    private Directory src, main, test;

    @BeforeEach
    public void setUp() {
        root = new Directory(null, "repo");
        src = new Directory(root, "src");
        main = new Directory(src, "main");
        test = new Directory(src, "test");
        
        fileA = new File(main, "A.java", 100);
        fileB = new File(main, "B.java", 150);
        File aTest = new File(test, "ATest.java", 50);
        File bTest = new File(test, "BTest.java", 60);
        readme = new File(root, "readme.md", 30);
        
        main.appendChild(fileA);
        main.appendChild(fileB);
        test.appendChild(aTest);
        test.appendChild(bTest);
        src.appendChild(main);
        src.appendChild(test);
        root.appendChild(src);
        root.appendChild(readme);
    }

    @Test
    public void AppendChild() {
        Directory newDir = new Directory(root, "newDir");
        root.appendChild(newDir);
        assertTrue(root.getSubDirectories().contains(newDir));
    }

    @Test
public void GetSubDirectories() {
    assertTrue(root.getSubDirectories().contains(src));
    assertFalse(root.getSubDirectories().stream()
        .anyMatch(d -> d.getName().equals("readme.md")));
}

@Test
public void GetFiles() {
    assertTrue(root.getFiles().contains(readme));
    assertFalse(root.getFiles().stream()
        .anyMatch(f -> f.getName().equals("src")));
}

@Test
public void GetTotalSize() {
    assertEquals(390, root.getTotalSize());
}

@Test
public void directoriesWithDifferentNamesOrContents_ShouldNotBeEqual() {
    Directory diffDir = new Directory(root, "diffSrc");
    assertNotEquals(src, diffDir);
}

@Test
public void changingDirectoryName_ShouldReflectChange() {
    String newName = "newSrc";
    src.setName(newName);
    assertEquals(newName, src.getName());
}



@Test
public void addingFileToSubDirectory_ShouldReflectInRootSize() {
    File newFile = new File(test, "C.java", 20);
    test.appendChild(newFile);
    assertEquals(410, root.getTotalSize());
}
}

