import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PangramTest {
    private ReverseVowels checker = new ReverseVowels();

    @Test
    public void test1() {
        assertEquals("Aa", checker.reverseVowels("aA"));
    }
}