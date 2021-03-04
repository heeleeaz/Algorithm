import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PangramChecker {
    static final int CHAR_SIZE = 26;

    public boolean check(String sentence) {
        Set<Character> characters = new HashSet<>(CHAR_SIZE);
        for (char c : sentence.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') characters.add(c);
        }

        return characters.size() == CHAR_SIZE;
    }
}