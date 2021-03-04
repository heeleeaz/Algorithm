import org.junit.Assert;

public class OneWayEdit {
    public static void main(String[] args) {
//        Assert.assertTrue(oneWayEdit("pale", "ple"));
        Assert.assertFalse(oneWayEdit("pale", "bae"));
    }

    public static boolean oneWayEdit(String text, String compareText) {
        int[] characterHash = new int[26];

        for (char c : text.toCharArray()) {
            int index = c - 'a';
            characterHash[index]++;
        }

        for (char c : compareText.toCharArray()) {
            int index = c - 'a';
            if (characterHash[index] > 0) {
                characterHash[index]--;
            }else{
                characterHash[index]++;
            }
        }


        int sum = 0;
        for (int hash : characterHash) {
            System.out.println(hash);
            sum += hash;
        }


        return sum <= 2;
    }
}
