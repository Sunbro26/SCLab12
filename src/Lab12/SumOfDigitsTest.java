package Lab12;

import org.junit.Test;
import static org.junit.Assert.*;

public class SumOfDigitsTest {

    @Test
    public void testPositiveNumbers() {
        assertEquals(0, SumOfDigits.sumOfDigits(0));
        assertEquals(5, SumOfDigits.sumOfDigits(5));
        assertEquals(6, SumOfDigits.sumOfDigits(123));
        assertEquals(35, SumOfDigits.sumOfDigits(98765));
        assertEquals(1, SumOfDigits.sumOfDigits(1000000));
    }

    @Test
    public void testNegativeNumbers() {
        assertEquals(15, SumOfDigits.sumOfDigits(-12345));
        assertEquals(27, SumOfDigits.sumOfDigits(-999));
    }

    @Test
    public void testEdgeCases() {
        assertEquals(72, SumOfDigits.sumOfDigits(99999999)); // Large sum
        assertEquals(1, SumOfDigits.sumOfDigits(1000000)); // Leading zeros irrelevant
    }
}
