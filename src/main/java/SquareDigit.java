import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SquareDigit {

    public int squareDigits(int n) {
        StringBuilder stringBuilder = new StringBuilder();

        int quotient = n;
        while (quotient > 0) {
            int remainder = quotient % 10;
            quotient = quotient / 10;

            stringBuilder.append(remainder * remainder);

        }

        return Integer.parseInt(stringBuilder.toString());
    }

}