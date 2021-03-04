import java.util.ArrayList;
import java.util.List;

class BloombergPalindromicNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1221));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;

        List<Integer> remainderList = new ArrayList<>();
        int quotient = x;
        while (quotient != 0) {
            int rem = quotient % 10;
            quotient = quotient / 10;
            remainderList.add(rem);
        }

        for (int i = 0; i < remainderList.size() / 2; i++) {
            int left = remainderList.get(i);
            int right = remainderList.get(remainderList.size() - 1 - i);

            if (left != right) return false;
        }

        return true;
    }

    public boolean isPalindromeRevertHalf(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int quotient = x;
        int revertedNumber = 0;
        while (quotient > revertedNumber) {
            revertedNumber = (10 * revertedNumber) + quotient % 10;
            quotient = quotient / 10;
        }


        return (quotient == revertedNumber) || (quotient == revertedNumber/10);
    }
}
