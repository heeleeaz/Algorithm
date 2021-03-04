import java.util.ArrayList;
import java.util.List;

public class FindOutlier {
    static int find(int[] integers) {
        List<Integer> evenIntegers = new ArrayList<>();
        List<Integer> oddIntegers = new ArrayList<>();

        for (int i : integers) {
            if (i % 2 == 0) evenIntegers.add(i);
            else oddIntegers.add(i);
        }
        return evenIntegers.size() == 1 ? evenIntegers.get(0) : oddIntegers.get(0);
    }
}