package umbcs680.hw12.fs;
import java.util.Comparator;

public class ReverseAlphabeticalComparator implements Comparator<FSElement> {
    @Override
    public int compare(FSElement e1, FSElement e2) {
        return e2.getName().compareTo(e1.getName());
    }
}
