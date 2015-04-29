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

        long divisor = 2;
        long remains = baseNumber;
        while (remains % divisor == 0) {
            remains /= divisor;
            incrementMap(factorsCountMap, divisor, 1);
        }

        divisor++;
        while (remains > 1) {
            if (remains % divisor == 0) {
                remains /= divisor;
                incrementMap(factorsCountMap, divisor, 1);
            } else if (divisor >= divisorLimit) {
                incrementMap(factorsCountMap, baseNumber, 1);
                break;
            } else {
                divisor += 2;
            }
        }

        return factorsCountMap;
    }

    private void incrementMap(final Map<Long, Integer> map, final Long key, final Integer increment) {

        final Integer previousFactorCount = map.get(key);
        map.put(key, previousFactorCount != null ? previousFactorCount + increment : increment);
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
