import org.junit.Assert;
import org.junit.Test;

public class FloorValueOfSortedArrayTest {
    FloorValueOfSortedArray checker = new FloorValueOfSortedArray();

    @Test
    public void test1() {
        int result = checker.floorValue(new int[]{-1, 2, 3, 5, 6, 8, 9, 10}, 7);
        Assert.assertEquals(6, result);
    }
}
