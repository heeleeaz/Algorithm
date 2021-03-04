import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

class DecodeWays {
    public int numDecodings(String s) {
        return backtracking(0, s, new HashMap<>());
    }

    public int backtracking(int index, String s, Map<Integer, Integer> memo) {
        if (index == s.length()) return 1;
        if (index == s.length() - 1) return 1;

        if (s.charAt(index) == '0') return 0;

        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        int ans = backtracking(index + 1, s, memo);
        if (Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            ans += backtracking(index + 2, s, memo);
        }

        memo.put(index, ans);

        return ans;


    }
}