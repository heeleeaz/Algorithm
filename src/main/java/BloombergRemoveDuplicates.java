import org.junit.Assert;

import java.util.Stack;

//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
class BloombergRemoveDuplicates {
    public static void main(String[] args) {
        Assert.assertEquals(removeDuplicatesStack("deeedbbcccbdaa", 3), "aa");
        Assert.assertEquals(removeDuplicatesStack("pbbcggttciiippooaais", 2), "ps");
    }

    public String removeDuplicates(String s, int k) {
        StringBuilder builder = new StringBuilder(s);

        int[] count = new int[builder.length()];

        for (int i = 0; i < builder.length(); i++) {
            if (i == 0 || builder.charAt(i) != builder.charAt(i - 1)) {
                count[i] = 1;
            } else {
                count[i] = count[i - 1] + 1;
                if (count[i] == k) {
                    builder.delete(i - k + 1, i + 1);
                    i = i - k;
                }
            }
        }

        return builder.toString();
    }


    public static String removeDuplicatesStack(String s, int k) {
        StringBuilder builder = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < builder.length(); i++) {
            if (i == 0 || builder.charAt(i) != builder.charAt(i - 1)) {
                stack.push(1);
            } else {
                int increment = stack.pop() + 1;
                if (increment == k) {
                    builder.delete(i - k + 1, i + 1);
                    i = i - k;
                } else {
                    stack.push(increment);
                }
            }
        }

        return builder.toString();
    }
}