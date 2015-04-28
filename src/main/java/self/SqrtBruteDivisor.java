package self;

import java.util.function.Predicate;

public class SqrtBruteDivisor extends Divisor {

    private final int divisorCount;

    public SqrtBruteDivisor(final int divisorCount) {

        this.divisorCount = divisorCount;
    }

    public int findDivisorsCountOf(final long n) {

        int divisorsCount = 2;
        final long limit = (long) Math.sqrt(n);
        long i = 1;
        while (++i <= limit) {
            if (n % i == 0) {
                divisorsCount += 2;

                if (divisorsCount > divisorCount) {
                    break;
                }
            }
        }

        if (--i * i == n) {
            divisorsCount--;
        }

        return divisorsCount;
    }

    @Override
    protected Predicate<Long> filterPredicate() {

        return n -> findDivisorsCountOf(n) == divisorCount;
    }
}
