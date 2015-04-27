package self;

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

        final long divisorLimit = baseNumber / 2;

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
                divisor += 1;
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
            final Map<Long, Integer> factors = findFactors(n);

            long total = 1;
            for (Integer count : factors.values()) {
                total *= (count + 1);
                if (total > divisorCount) {
                    return false;
                }
            }
            return total == divisorCount;
        };
    }

}
