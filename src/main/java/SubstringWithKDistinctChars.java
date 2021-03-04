import org.junit.Assert;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class SubstringWithKDistinctChars {
    public static void main(String[] args) {
//        Assert.assertEquals(substringWithKDistinctChars("abc", 2), 2);
        Assert.assertEquals(substringWithKDistinctChars("abafg", 2), 5);
    }

    public static int substringWithKDistinctChars(String inputString, int num) {
        char[] chars = inputString.toCharArray();
        int left = 0, right = 0;
        int distinct = 0, result = 0, prefix = 0;

        Map<Character, Integer> numCount = new HashMap<>();
        while (right < chars.length) {
            if (numCount.containsKey(chars[right]) && numCount.get(chars[right]) != 0)
                numCount.put(chars[right], numCount.get(chars[right]) + 1);
            else {
                distinct++;
                numCount.put(chars[right], 1);
            }

            if (distinct > num) {
                numCount.put(chars[left], numCount.get(chars[left]) - 1);
                prefix = 0;
                distinct--;
                left++;
            }
            while (numCount.get(chars[left]) > 1) {
                numCount.put(chars[left], numCount.get(chars[left]) - 1);
                left++;
                prefix++;
            }
            if (distinct == num)
                result += 1 + prefix;

            right++;
        }
        return result;
    }

    public static int kDistinctSub(String s, int k) {
        int count = 0;
        Set<Character> charsFound = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            int uniqueFound = 0;
            for (int j = i; j < s.length(); j++) {
                if (uniqueFound == k) {
                    if (charsFound.contains(s.charAt(j))) {
                        count++;
                    } else {
                        charsFound.clear();
                        break;
                    }
                } else {
                    if (!charsFound.contains(s.charAt(j))) {
                        charsFound.add(s.charAt(j));
                        uniqueFound++;
                        if (uniqueFound == k) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}