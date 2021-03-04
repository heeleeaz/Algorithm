import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayIndexEqualityTest {
    private final ArrayIndexEquality checker = new ArrayIndexEquality();

    @Test
    public void testValid() {
        assertEquals(3, checker.indexEqualsValueSearch(new int[]{-8, 0, 1, 3, 5}));
    }
}
