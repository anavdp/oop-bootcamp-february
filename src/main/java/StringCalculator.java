import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    public static final String ALLOWED_DELIMITERS = "[,\\n]";
    public static final String NEGATIVE_NUMBER_GROUP_REGEX = "(-\\d+)";
    public static final int MAX_ALLOWED_NUMBER = 1000;

    public static int add(String s) {
        throwExceptionIfNegativeValues(s);
        if ("".equals(s)) {
            return 0;
        }
        List<Integer> numbersToSum = splitAndToList(s);
        numbersToSum = filterBiggerNumbers(numbersToSum);
        return numbersToSum.stream().mapToInt(Integer::intValue).sum();
    }

    private static List<Integer> filterBiggerNumbers(List<Integer> numbersToSum) {
        return numbersToSum.stream().filter(num -> num < MAX_ALLOWED_NUMBER).collect(Collectors.toList());
    }

    private static List<Integer> splitAndToList(String s) {
        var numbersToSum = s.split(ALLOWED_DELIMITERS);
        return Arrays.stream(numbersToSum).map(Integer::parseInt).collect(Collectors.toList());
    }

    private static void throwExceptionIfNegativeValues(String s) {
        Pattern pattern = Pattern.compile(NEGATIVE_NUMBER_GROUP_REGEX);
        Matcher matcher = pattern.matcher(s);
        List<String> negativeNumbers = new ArrayList<>();
        while (matcher.find()) {
            negativeNumbers.add(matcher.group());
        }
        if (!negativeNumbers.isEmpty()) {
            throw new ArithmeticException("negatives not allowed:" + String.join(",", negativeNumbers));
        }
    }
}
