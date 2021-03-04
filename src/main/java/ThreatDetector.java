import java.util.ArrayList;
import java.util.List;


public class ThreatDetector {

    public static void threatDetector(List<String> textMessages) {
        for (String s : textMessages) {
            System.out.println(threatDetector(s));
        }
    }

    public static String threatDetector(String textMessage) {
        int sumPalindromeChars = 0;

        int messageLength = textMessage.length();
        String palindromeWords = textMessage.substring(0, messageLength - 3);
        String characterSymbol = textMessage.substring(messageLength - 3);

        char[] palindromeCharacters = palindromeWords.toCharArray();
        int count = 1;
        char previousChar = palindromeCharacters[0];

        for (int i = 1; i < palindromeCharacters.length; i++) {
            char current = palindromeCharacters[i];
            if (current == previousChar) {
                count += 1;
            } else {
                if (count > 2) sumPalindromeChars += count;
                count = 1;
            }
            previousChar = current;
        }

        if (count > 2) sumPalindromeChars += count;

        return characterSymbol + " " + severityLevelMessage(sumPalindromeChars);
    }

    private static String severityLevelMessage(int palindromeCount) {
        if (palindromeCount >= 1 && palindromeCount <= 10) return "Possible";
        if (palindromeCount >= 11 && palindromeCount <= 40) return "Probable";
        if (palindromeCount >= 41 && palindromeCount <= 150) return "Escalate";
        else return "Ignore";
    }

    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("xxxayyySPY");
        a.add("xxxxxxbzzzzzzIVV");
        a.add("xxAyyDJI");
        threatDetector(a);
    }

}