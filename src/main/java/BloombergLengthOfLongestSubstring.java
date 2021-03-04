import java.util.HashSet;
import java.util.Set;

class BloombergLengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();

        int left = 0;
        int right = 0;
        Set<Character> characterMap = new HashSet<>();
        int max = 0;

        while (left < chars.length && right < chars.length) {
            if (!characterMap.contains(chars[right])) {
                characterMap.add(chars[right++]);
                max = Math.max(max, characterMap.size());
            } else {
                characterMap.remove(chars[left++]);
            }
        }

        return max;
    }

//    public int lengthOfLongestSubstringOptimized(String s) {
//        char[] chars = s.toCharArray();
//
//        int[] characterHash = new int[128];
//
//        int ans = 0;
//        for (int j = 0, i = 0; j < s.length(); j++) {
//            i = Math.max(i, characterHash[chars[j]]);
//            ans = Math.max(ans, j - i + 1);
//            characterHash[chars[j]] = j + 1;
//        }
//
//        return ans;
//    }

    public int lengthOfLongestSubstringOptimized(String s) {
        char[] chars = s.toCharArray();

        int[] characterHash = new int[128];

        int ans = 0;
        for (int j = 0, i = 0; j < chars.length; j++) {
            i = Math.max(i, characterHash[j]);
            ans = Math.max(ans, j - i + 1);
            characterHash[chars[j]] = j + 1;
        }

        return ans;
    }
}