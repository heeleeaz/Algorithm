import org.junit.Assert;

import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        Assert.assertEquals(aa("([)]"), false);
        Assert.assertEquals(aa("()[]{}"), true);
    }

    public static boolean aa(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == ')' || c == '}' || c == ']') {
                char opening = stack.pop();

                if (c == ')' && opening == '(' || c == '}' && opening == '{' || c == ']' && opening == '[') {
                    continue;
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}