import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BraceChecker {

    public boolean isValid(String braces) {
        Stack<Character> braceStack = new Stack<>();
        Map<Character, Character> braceMap = new HashMap<>(3);
        braceMap.put('(', ')');
        braceMap.put('{', '}');
        braceMap.put('[', ']');


        for (Character c : braces.toCharArray()) {
            if (braceMap.containsKey(c)) {
                braceStack.push(c);
            } else {
                if (braceStack.isEmpty()) return false;

                Character closedBrace = braceMap.get(braceStack.pop());
                if (closedBrace != c) return false;
            }
        }

        return (braceStack.size() == 0);
    }

    public boolean isValidUsingSwitch(String braces) {
        Stack<Character> braceStack = new Stack<>();

        for (Character c : braces.toCharArray()) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    braceStack.push(c);
                    break;
                case ')':
                    if (braceStack.pop() != '(') return false;
                    break;
                case '}':
                    if (braceStack.pop() != '{') return false;
                    break;
                case ']':
                    if (braceStack.pop() != '[') return false;
                    break;
            }
        }

        return true;
    }

}