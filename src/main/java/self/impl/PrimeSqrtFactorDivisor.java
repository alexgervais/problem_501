package self.impl;

import self.Divisor;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class PrimeSqrtFactorDivisor extends Divisor {

    private final int divisorCount;

    private static final List<Long> PRIMES;

    static {
        PRIMES = new ArrayList<>();
        try {
            final URL resource = PrimeSqrtFactorDivisor.class.getClassLoader().getResource("primes.csv");
            final Stream<String> stream = Files.lines(Paths.get(resource.toURI()))
                .map(line -> line.split(","))
                .flatMap(Arrays::stream);

            stream.forEach(prime -> PRIMES.add(Long.valueOf(prime.trim())));
            stream.close();
        } catch (Exception e) {
            System.out.println("Failed to load primes.csv resource file");
            e.printStackTrace();
        }
    }

    public PrimeSqrtFactorDivisor(final int divisorCount) {

        this.divisorCount = divisorCount;
    }

    public Map<Long, Integer> findFactors(final Long baseNumber) {

        final Map<Long, Integer> factorsCountMap = new HashMap<>();

        final long divisorLimit = (long) Math.sqrt(baseNumber);

        int primeIndex = 0;
        long prime = PRIMES.get(primeIndex);
        long remains = baseNumber;

        while (remains > 1) {
            if (remains % prime == 0) {
                remains /= prime;
                incrementFactorMap(factorsCountMap, prime, 1);
            } else if (prime >= divisorLimit) {
                incrementFactorMap(factorsCountMap, baseNumber, 1);
                break;
            } else {
                prime = PRIMES.get(++primeIndex);
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
