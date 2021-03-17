import java.util.Collections;
import java.util.List;

public class GetNumberOfOptions {
    public static long getNumberOfOptions(
            List<Integer> priceOfJeans,
            List<Integer> priceOfShoes,
            List<Integer> priceOfSkirts,
            List<Integer> priceOfTops,
            int budgeted) {

        Collections.sort(priceOfJeans, (a, b) -> Integer.compare(a, b));
        Collections.sort(priceOfShoes, (a, b) -> Integer.compare(a, b));
        Collections.sort(priceOfSkirts, (a, b) -> Integer.compare(a, b));
        Collections.sort(priceOfTops, (a, b) -> Integer.compare(a, b));


        return -1;
    }
}
