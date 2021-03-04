import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoString {
    static String twoStrings(String s1, String s2) {

        Map<String, Integer> magazineWords = new HashMap<>();

        Set<Character> hash = new HashSet<>();
        for(int i=0; i<s1.length(); i++){
            hash.add(s1.charAt(i));
        }

        for(int i=0; i<s2.length(); i++){
            if(hash.contains(s2.charAt(i))) return "YES";
        }

        return "NO";

    }
}
