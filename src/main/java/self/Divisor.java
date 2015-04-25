package self;

import java.util.ArrayList;
import java.util.List;

public class Divisor {

    private final int divisorCount;

    public Divisor(final int divisorCount) {

        this.divisorCount = divisorCount;
    }

    public List<Long> findDivisorsOf(final long n) {

        final List<Long> divisors = new ArrayList<>();

        for (long i = 1; i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }

        return divisors;
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
