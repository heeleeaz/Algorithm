import org.junit.Test;

import static org.junit.Assert.*;

public class NegativeNumberInSortedMatrixTest {
    private NegativeNumberInSortedMatrix checker = new NegativeNumberInSortedMatrix();

    @Test
    public void testExample() {
        assertEquals(8, checker.countNegatives(new int[][]{
                {4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}
        }));
    }

    @Test
    public void testExample2() {
        assertEquals(0, checker.countNegatives(new int[][]{{3, 2}, {1, 0}}));
    }

    @Test
    public void testExample3() {
        assertEquals(1, checker.countNegatives(new int[][]{{-1}}));
        assertEquals(3, checker.countNegatives(new int[][]{{5,1,0}, {-5,-5,-5}}));
    }
}
