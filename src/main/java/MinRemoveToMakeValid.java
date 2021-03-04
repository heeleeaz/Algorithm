import java.util.Stack;

class MinRemoveToMakeValid {
    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValidWithStack(")a(b)c()("));
    }

    public static String minRemoveToMakeValidWithStack(String s) {
        Stack<Character> characterStack = new Stack<>();
        Stack<Integer> indexes = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                characterStack.add(c);
                indexes.add(i);
            } else if (c == ')') {
                if (!characterStack.isEmpty()) {
                    characterStack.pop();
                    indexes.pop();
                } else {
                    indexes.add(i);
                }
            }
        }

        StringBuilder builder = new StringBuilder(s);
        int padding = 0;
        for (Integer i : indexes) {
            builder.deleteCharAt(i - padding++);
        }
        return builder.toString();
    }

    public String minRemoveToMakeValid(String s) {
        Stack<Integer> indexes = new Stack<>();

        int open = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                indexes.add(i);
                open += 1;
            } else if (c == ')') {
                if (open != 0) {
                    indexes.pop();
                    open -= 1;
                } else {
                    indexes.add(i);
                }
            }
        }

        StringBuilder builder = new StringBuilder(s);
        int padding = 0;
        for (Integer i : indexes) {
            builder.deleteCharAt(i - padding++);
        }
        return builder.toString();
    }
}