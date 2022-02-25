import java.util.Arrays;

public class StringCalculator {
    public static int add(String s) {
        checkNegativeValues(s);
        if ("".equals(s)) {
            return 0;
        }
        var numbersToSum = s.split("[,\\n]");
        return Arrays.stream(numbersToSum).mapToInt(Integer::parseInt).sum();
    }

    private static void checkNegativeValues(String s) {

    }
}
