import java.util.HashMap;
import java.util.Stack;

class BloombergMinAddToMakeValid {
    public int minAddToMakeValid(String S) {
        int close = 0;
        int open = 0;
        for (Character c : S.toCharArray()) {
            if (c == '(') {
                open += 1;
            } else {
                if (open != 0) {
                    open -= 1;
                } else {
                    close += 1;
                }
            }
        }

        return open + close;
    }

    public int minAddToMakeValidUsingStack(String S) {
        Stack<Character> stack = new Stack<>();

        int close = 0;
        for (Character c : S.toCharArray()) {
            if (c == '(') {
                stack.add(c);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    close += 1;
                }
            }
        }

        return stack.size() + close;
    }
}