package self;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public abstract class Divisor {

    public Long numbersCountNotExceedingNumberOfDivisors(final Long baseNumber) {

        return stream(baseNumber).count();
    }

    public Collection<Long> numbersNotExceedingNumberOfDivisors(final Long baseNumber) {

        return stream(baseNumber).collect(Collectors.toList());
    }

    private Stream<Long> stream(final Long baseNumber) {

        return LongStream.range(1, baseNumber + 1)
            .boxed()
            .parallel()
            .filter(filterPredicate());
    }

    abstract Predicate<Long> filterPredicate();

}
