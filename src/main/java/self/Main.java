package self;

import java.util.Collection;

public class Main {

    public static void main(final String[] args) {

        final long n = extractVariableN(args);

        final long start = System.currentTimeMillis();

        final Divisor divisor = new Divisor(8);
        final Collection<Long> result = divisor.numbersNotExceedingNumberOfDivisors(n);

        final long end = System.currentTimeMillis();

        System.out.println(result);
        System.out.println(String.format("Result: [%s]", result.size()));
        System.out.println(String.format("Took: [%s]ms", end - start));
    }

    private static long extractVariableN(final String[] args) {

        if (args.length != 1) {
            System.out.println("Expected exactly 1 argument 'n'");
            System.exit(1);
        }

        try {
            return Long.parseLong(args[0]);
        } catch (Exception e) {
            System.out.println("Expected 'n' to be a number");
            System.exit(1);
        }

        return -1;
    }
}
