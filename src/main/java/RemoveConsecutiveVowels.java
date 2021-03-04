import org.junit.Assert;

public class RemoveConsecutiveVowels {
    static boolean isVowel(char ch) {
        return (ch == 'a') || (ch == 'e') || (ch == 'i') || (ch == 'o') || (ch == 'u');
    }

    public static String removeConsecutiveVowels(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str.charAt(0));
        for (int i = 1; i < str.length(); i++)
            if (!isVowel(str.charAt(i - 1)) || !isVowel(str.charAt(i))) {
                char ch = str.charAt(i);
                stringBuilder.append(ch);
            }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Assert.assertEquals("aba", removeConsecutiveVowels("aba"));
    }
}
