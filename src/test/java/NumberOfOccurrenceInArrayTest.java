import org.junit.Assert;
import org.junit.Test;

public class NumberOfOccurrenceInArrayTest {
    NumberOfOccurrenceInArray check = new NumberOfOccurrenceInArray();

    @Test
    public void check1() {
        int result = check.numberOfOccurrence(new int[]{1, 1, 2, 2, 2, 2, 3}, 2);
        Assert.assertEquals(4, result);
    }

    @Test
    public void check2() {
        int result = check.numberOfOccurrence(new int[]{1, 1, 2, 2, 2, 2, 3}, 3);
        Assert.assertEquals(1, result);
    }

}
