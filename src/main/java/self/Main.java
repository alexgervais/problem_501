package self;

import java.util.List;

public class Main {

    public static void main(final String[] args) {

        final long start = System.currentTimeMillis();

        final Divisor divisor = new Divisor(8);
        final List<Long> result = divisor.numbersNotExceedingNumberOfDivisors(Long.parseLong(args[0]));

        final long end = System.currentTimeMillis();

        System.out.println(result);
        System.out.println(String.format("Result: [%s]", result.size()));
        System.out.println(String.format("Took: [%s]ms", end - start));
    }
}
