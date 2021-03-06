package self.impl;

import self.Divisor;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class FactorDivisor extends Divisor {

    private final int divisorCount;
    private final Map<Long, Map<Long, Integer>> calculatedFactors;

    public FactorDivisor(final int divisorCount) {

        this.divisorCount = divisorCount;
        this.calculatedFactors = new HashMap<>();
    }

    public Map<Long, Integer> findFactors(final Long baseNumber) {

        final Map<Long, Integer> factorsCountMap = new HashMap<>();

        final long divisorLimit;
        if (baseNumber % 2 == 0) {
            divisorLimit = baseNumber / 2;
        } else {
            divisorLimit = baseNumber / 3;
        }

        long divisor = 2;
        long remains = baseNumber;
        while (remains > 1) {
            if (remains % divisor == 0) {
                remains /= divisor;
                incrementMap(factorsCountMap, divisor, 1);

                if (calculatedFactors.containsKey(remains)) {
                    calculatedFactors.get(remains).forEach((factor, factorCount) -> incrementMap(factorsCountMap, factor, factorCount));
                    break;
                }
            } else if (divisor >= divisorLimit) {
                incrementMap(factorsCountMap, baseNumber, 1);
                break;
            } else {
                divisor++;
            }
        }

        calculatedFactors.putIfAbsent(baseNumber, factorsCountMap);

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
