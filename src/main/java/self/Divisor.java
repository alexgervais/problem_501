package self;

import java.util.ArrayList;
import java.util.Collection;

public class Divisor {

    private final int divisorCount;

    public Divisor(final int divisorCount) {

        this.divisorCount = divisorCount;
    }

    public Collection<Long> findDivisorsOf(final long n) {

        final Collection<Long> divisors = new ArrayList<>();

        divisors.add(1L);
        divisors.add(n);

        if (n % 2 == 0) {
            findEvenNumberDivisors(n, divisors);
        } else {
            findOddNumberDivisors(n, divisors);
        }

        return divisors;
    }

    private void findOddNumberDivisors(final long n, final Collection<Long> divisors) {

        int foundDivisors = 2;
        final long limit = n / 3;
        long i = 2;
        while (++i <= limit) {
            if (n % i == 0) {
                divisors.add(i);

                if (++foundDivisors > divisorCount) {
                    return;
                }
            }
        }
    }

    private void findEvenNumberDivisors(final long n, final Collection<Long> divisors) {

        int foundDivisors = 2;
        final long limit = n / 2;
        long i = 1;
        while (++i <= limit) {
            if (n % i == 0) {
                divisors.add(i);

                if (++foundDivisors > divisorCount) {
                    return;
                }
            }
        }
    }

    public Collection<Long> numbersNotExceedingNumberOfDivisors(final long baseNumber) {

        final Collection<Long> numbers = new ArrayList<>();

        for (long i = 1; i <= baseNumber; i++) {
            if (findDivisorsOf(i).size() == divisorCount) {
                numbers.add(i);
            }
        }

        return numbers;
    }
}
