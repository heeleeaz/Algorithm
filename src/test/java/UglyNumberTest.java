import org.junit.Assert;
import org.junit.Test;

public class UglyNumberTest {
    UglyNumbers uglyNumbers = new UglyNumbers();

    @Test
    public void test1(){
        Assert.assertEquals(8, uglyNumbers.uglyNumbers(7));
    }
}
