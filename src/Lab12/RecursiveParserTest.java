package Lab12;

import org.junit.Test;
import static org.junit.Assert.*;

public class RecursiveParserTest {

    @Test
    public void testValidExpressions() throws Exception {
        assertEquals(13.0, new RecursiveParser("3 + 5 * 2").evaluate(), 0.001);
        assertEquals(16.0, new RecursiveParser("(3 + 5) * 2").evaluate(), 0.001);
        assertEquals(17.0, new RecursiveParser("10 / 2 + 3 * 4").evaluate(), 0.001);
        assertEquals(14.0, new RecursiveParser("10 + 2 * (5 - 3)").evaluate(), 0.001);
        assertEquals(11.9, new RecursiveParser("3.5 + 4.2 * 2").evaluate(), 0.001);
        assertEquals(6.0, new RecursiveParser("(2.5 + 3.5) * 2.0 / (1.0 + 1.0)").evaluate(), 0.001);
    }

    @Test
    public void testInvalidExpressions() {
        assertThrows(IllegalArgumentException.class, () -> new RecursiveParser("3 +").evaluate());
        assertThrows(ArithmeticException.class, () -> new RecursiveParser("5 / 0").evaluate());
        assertThrows(IllegalArgumentException.class, () -> new RecursiveParser("(3 + 5").evaluate());
    }

    @Test
    public void testEmptyExpression() {
        assertThrows(IllegalArgumentException.class, () -> new RecursiveParser("").evaluate());
    }
}
