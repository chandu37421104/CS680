package umbcs680.hw12.fs;
import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<FSElement> {
    @Override
    public int compare(FSElement e1, FSElement e2) {
        return e1.getName().compareTo(e2.getName());
    }
}
