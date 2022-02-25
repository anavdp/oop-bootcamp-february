import java.util.Arrays;

public class StringCalculator {
    public static int add(String s) {
        checkNegativeValues(s);
        if ("".equals(s)) {
            return 0;
        }
        var numbersToSum = s.split("[,\\n]");
        if (numbersToSum.length > 1) {
            return Arrays.stream(numbersToSum).mapToInt(Integer::parseInt).sum();
        }
        return Integer.parseInt(s);
    }

    private static void checkNegativeValues(String s) {

    }
}
