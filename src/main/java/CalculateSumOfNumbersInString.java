import org.junit.Assert;

public class CalculateSumOfNumbersInString {
    public static void main(String[] args) {
//        System.out.println(calculateSumOfNumbersInString("1999"));
    }

    public static int calculateSumOfNumbersInString(String inputString) {
        StringBuilder allString = new StringBuilder();
        for (int i = 0; i < inputString.length(); i++) {
            char ch = inputString.charAt(i);
            if (Character.isDigit(ch)) {
                allString.append(ch);
            }
        }
        return Integer.parseInt(allString.toString());
    }
}
