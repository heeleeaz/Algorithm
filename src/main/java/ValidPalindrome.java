import java.util.ArrayList;
import java.util.List;

class ValidPalindrome {
    public boolean isPalindrome(String s) {
        List<Character> chars = new ArrayList<>();

        for (char c : s.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z' || c >= '0' && c <= '9') {
                chars.add(c);
            }
        }

        for (int i = 0; i < chars.size(); i++) {
            char start = chars.get(i);
            char end = chars.get((chars.size() - 1) - i);

            if (start != end) {
                return false;
            }
        }

        return true;

    }
}

//convert char array
//consider only [a-z0-9]
//add to array
//read from start and end
//compare character