import org.junit.Assert;
import org.junit.Test;

public class FixedPointInArrayTest {
    FixedPointInArray checker = new FixedPointInArray();

    @Test
    public void check() {
        Assert.assertEquals(3, checker.fixedPoint(new int[]{-10, -5, 0, 3, 7}));
    }

}
