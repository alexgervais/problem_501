package self;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Divisor {

    private final int divisorCount;

    public Divisor(final int divisorCount) {

        this.divisorCount = divisorCount;
    }

    public Collection<Long> findDivisorsOf(final long n) {

        if (n % 2 == 0) {
            return findEvenNumberDivisors(n);
        } else {
            return findOddNumberDivisors(n);
        }
    }

    public Collection<Long> numbersNotExceedingNumberOfDivisors(final Long baseNumber) {

        return stream(baseNumber).collect(Collectors.toList());
    }

    public Long numbersCountNotExceedingNumberOfDivisors(final Long baseNumber) {

        return stream(baseNumber).count();
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

    private Stream<Long> stream(final Long baseNumber) {

        return LongStream.range(1, baseNumber + 1)
            .boxed()
            .parallel()
            .filter(n -> findDivisorsOf(n).size() == divisorCount);
    }
}
