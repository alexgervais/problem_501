package self.impl;

import self.Divisor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public class BruteDivisor extends Divisor {

    private final int divisorCount;

    public BruteDivisor(final int divisorCount) {

        this.divisorCount = divisorCount;
    }

    public Collection<Long> findDivisorsOf(final long n) {

        if (n % 2 == 0) {
            return findEvenNumberDivisors(n);
        } else {
            return findOddNumberDivisors(n);
        }
    }

    private Collection<Long> findOddNumberDivisors(final long n) {

        final Collection<Long> divisors = new ArrayList<>();

        divisors.add(1L);
        divisors.add(n);

        int foundDivisors = 2;
        final long limit = n / 3;
        long i = 1;
        while ((i += 2) <= limit) {
            if (n % i == 0) {
                divisors.add(i);

                if (++foundDivisors > divisorCount) {
                    break;
                }
            }
        }

        return divisors;
    }

    private Collection<Long> findEvenNumberDivisors(final long n) {

        final Collection<Long> divisors = new ArrayList<>();

        divisors.add(1L);
        divisors.add(n);

        int foundDivisors = 2;
        final long limit = n / 2;
        long i = 1;
        while (++i <= limit) {
            if (n % i == 0) {
                divisors.add(i);

                if (++foundDivisors > divisorCount) {
                    break;
                }
            }
        }

        return divisors;
    }

    @Override
    protected Predicate<Long> filterPredicate() {

        return n -> findDivisorsOf(n).size() == divisorCount;
    }
}
