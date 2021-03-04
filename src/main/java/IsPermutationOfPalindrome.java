import org.junit.Assert;

public class IsPermutationOfPalindrome {
    public static void main(String[] args) {
        Assert.assertTrue(isPermutationOfPalindromeSingleN("Tact Coa"));
        Assert.assertTrue(isPermutationOfPalindromeSingleN("abb"));
    }

    static boolean isPermutationOfPalindrome(String phrase) {
        int[] characterSet = new int[26];

        for (char c : phrase.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                int index = c - 'a';
                characterSet[index]++;
            }
        }

        int numberOfOddCharacterCount = 0;
        for (int count : characterSet) {
            if (count % 2 != 0) {
                numberOfOddCharacterCount += 1;
            }
        }

        return numberOfOddCharacterCount <= 1;
    }

    static boolean isPermutationOfPalindromeSingleN(String phrase) {
        int[] characterSet = new int[26];

        int numberOfOddCharacterCount = 0;
        for (char c : phrase.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                int index = c - 'a';
                characterSet[index]++;

                if (characterSet[index] % 2 == 1) {
                    numberOfOddCharacterCount++;
                } else {
                    numberOfOddCharacterCount--;
                }
            }
        }
        return numberOfOddCharacterCount <= 1;
    }

}
