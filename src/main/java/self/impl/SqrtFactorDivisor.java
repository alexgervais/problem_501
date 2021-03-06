package self.impl;

import self.Divisor;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class SqrtFactorDivisor extends Divisor {

    private final int divisorCount;

    public SqrtFactorDivisor(final int divisorCount) {

        this.divisorCount = divisorCount;
    }

    public Map<Long, Integer> findFactors(final Long baseNumber) {

        final Map<Long, Integer> factorsCountMap = new HashMap<>();

        final long divisorLimit = (long) Math.sqrt(baseNumber);

        long prime = 2;
        long remains = baseNumber;
        while (remains % prime == 0) {
            remains /= prime;
            incrementFactorMap(factorsCountMap, prime, 1);
        }

        prime++;
        while (remains > 1) {
            if (remains % prime == 0) {
                remains /= prime;
                incrementFactorMap(factorsCountMap, prime, 1);
            } else if (prime >= divisorLimit) {
                incrementFactorMap(factorsCountMap, baseNumber, 1);
                break;
            } else {
                prime += 2;
            }
        }

        return factorsCountMap;
    }

    private void incrementFactorMap(final Map<Long, Integer> map, final Long prime, final Integer increment) {

        final Integer previousFactorCount = map.get(prime);
        map.put(prime, previousFactorCount != null ? previousFactorCount + increment : increment);
    }

    @Override
    protected Predicate<Long> filterPredicate() {

        return n -> {
            final Collection<Integer> values = findFactors(n).values();

            long total = 1;
            for (Integer count : values) {
                total *= (count + 1);
                if (total > divisorCount) {
                    return false;
                }
            }
            return total == divisorCount;
        };
    }

}
