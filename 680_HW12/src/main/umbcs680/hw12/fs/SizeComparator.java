package umbcs680.hw12.fs;
import java.util.Comparator;

public class SizeComparator implements Comparator<FSElement> {
    @Override
    public int compare(FSElement e1, FSElement e2) {
        return Integer.compare(e1.getSize(), e2.getSize());
    }
}
