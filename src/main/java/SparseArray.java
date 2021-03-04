import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * There is a collection of input strings and a collection of query strings. For each query string, determine how many times it occurs in the list of input strings. Return an array of the results.
 *
 * Example
 *
 *
 *
 * There are  instances of ',  of '' and  of ''. For each query, add an element to the return array, .
 *
 * Function Description
 *
 * Complete the function matchingStrings in the editor below. The function must return an array of integers representing the frequency of occurrence of each query string in strings.
 *
 * matchingStrings has the following parameters:
 *
 * string strings[n] - an array of strings to search
 * string queries[q] - an array of query strings
 * Returns
 *
 * int[q]: an array of results for each query
 * Input Format
 *
 * The first line contains and integer , the size of .
 * Each of the next  lines contains a string .
 * The next line contains , the size of .
 * Each of the next  lines contains a string .
 *
 * Constraints
 *
 *
 *
 *  .
 */

public class SparseArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(matchingStrings(new String[]{"aba", "baba", "aba", "xzxb"}, new String[]{"aba", "xzxb", "ab"})));
        System.out.println(Arrays.toString(matchingStrings(new String[]{"def", "de", "fgh"}, new String[]{"de", "1mn", "fgh"})));
        System.out.println(Arrays.toString(matchingStrings(new String[]{"abcde", "sdaklfj", "asdjf", "na", "basdn", "sdaklfj", "asdjf", "na", "asdjf", "na", "basdn", "sdaklfj", "asdjf"}, new String[]{"abcde", "sdaklfj", "asdjf", "na", "basdn"})));
    }

    static int[] matchingStrings(String[] strings, String[] queries) {
        HashMap<String, Integer> stringCountMap = new HashMap();

        for (String string : strings) {
            int currentCount = stringCountMap.getOrDefault(string, 0);
            stringCountMap.put(string, currentCount + 1);
        }

        int[] counts = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int count = stringCountMap.getOrDefault(queries[i], 0);
            counts[i] = count;
        }

        return counts;
    }
}
