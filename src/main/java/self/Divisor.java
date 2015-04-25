package self;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
            findEvenDivisors(n, divisors);
        } else {
            findOddDivisors(n, divisors);
        }

        return divisors;
    }

    public void findOddDivisors(final long n, final Collection<Long> divisors) {

        int foundDivisors = 2;
        for (long i = 3; i <= n / 3; i++) {
            if (n % i == 0) {
                divisors.add(i);

                if (++foundDivisors > divisorCount) {
                    break;
                }
            }
        }
    }

    public void findEvenDivisors(final long n, final Collection<Long> divisors) {

        int foundDivisors = 2;
        for (long i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                divisors.add(i);

                if (++foundDivisors > divisorCount) {
                    break;
                }
            }
        }
    }

    public List<Long> numbersNotExceedingNumberOfDivisors(final long n) {

        final List<Long> numbers = new ArrayList<>();

        for (long i = 1; i <= n; i++) {
            if (findDivisorsOf(i).size() == divisorCount) {
                numbers.add(i);
            }
        }

        return numbers;
    }
}
