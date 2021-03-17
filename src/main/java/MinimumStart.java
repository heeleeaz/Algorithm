import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class MinimumStart {
    public static void main(String[] args) {
        System.out.println(minStart(new ArrayList<>() {
            {
                add(-5);
                add(-4);
                add(-2);
                add(3);
                add(1);
            }
        }));
        Assert.assertEquals(minStart(new ArrayList<>() {
            {
                add(-5);
                add(-4);
                add(-2);
                add(3);
                add(1);
            }
        }), 7);
        Assert.assertEquals(minStart(new ArrayList<>() {
            {
                add(-5);
                add(4);
                add(-2);
                add(3);
                add(1);
                add(-1);
                add(-6);
                add(-1);
                add(0);
                add(5);
            }
        }), 8);
        Assert.assertEquals(minStart(new ArrayList<>() {
            {
                add(-4);
                add(3);
                add(2);
                add(1);
            }
        }), 5);
    }

    public static long minStart(List<Integer> arr) {
        if (arr == null || arr.size() == 0) return 1;

        long res = 1, sum = 1;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
            if (sum < 1) {
                res = res + Math.abs(sum) + 1; // increment res by the difference to keep sum to 1
                sum = 1;
            }
        }

        return res;
    }
}
