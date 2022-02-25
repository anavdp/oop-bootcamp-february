import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class StringCalculatorTest {
    @Test
    public void itShouldReturnZeroForEmptyString() {
        assertEquals(StringCalculator.add(""), 0);
    }

    @Test
    public void itShouldReturnsTheValueForASingleNumber() {
        assertEquals(StringCalculator.add("1"), 1);
    }

    @Test
    public void itShouldAddTwoNumbersWithCommaDelimiter() {
        assertEquals(StringCalculator.add("2,3"), 5);
    }

    @Test
    public void itShouldAddTwoNumbersWithNewLineDelimiter() {
        assertEquals(StringCalculator.add("2\n3"), 5);
    }

    @Test
    public void itShouldAddNumbersWithMixedDelimiters() {
        assertEquals(StringCalculator.add("2\n3,4"), 9);
    }

    @Test(expectedExceptions = ArithmeticException.class, expectedExceptionsMessageRegExp = "negatives not allowed:-1,-3")
    public void itShouldThrowExceptionWhenNegativeNumbersArePassed() {
        StringCalculator.add("-1,2,-3");
    }

    @Test
    public void itShouldAddNumbersIgnoringGreaterThan1000() {
        assertEquals(StringCalculator.add("2\n1001,4"), 6);
    }
}
