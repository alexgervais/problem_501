package self;

public class Main {

    public static final int EIGHT_DIVISORS = 8;

    public static void main(final String[] args) throws Exception {

        final long n = extractVariableN(args);
        final Divisor divisor = extractDivisor(args);

        final long start = System.currentTimeMillis();

        final Long result = divisor.numbersCountNotExceedingNumberOfDivisors(n);

        final long end = System.currentTimeMillis();

        System.out.println(String.format("Result: [%s]", result));
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

    private static Divisor extractDivisor(final String[] args) {

        return new FactorDivisor(EIGHT_DIVISORS);
    }
}
