import java.util.Set;
import java.util.TreeSet;

public class TwoToOne {

    public static String longest(String s1, String s2) {
        Set<Character> characterSet = new TreeSet<>();
        for (char c : (s1 + s2).toCharArray()) characterSet.add(c);

        StringBuilder builder = new StringBuilder(characterSet.size());
        for (Character c : characterSet) {
            builder.append(c);
        }

        return builder.toString();
    }
}