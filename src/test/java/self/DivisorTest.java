package self;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DivisorTest {

    private Divisor divisor;
    private long start;

    @Before
    public void setUp() throws Exception {

        divisor = new Divisor(8);
        start = System.currentTimeMillis();
    }

    @After
    public void tearDown() throws Exception {

        System.out.println(String.format("Test took [%s]ms", System.currentTimeMillis() - start));
    }

    @Test
    public void findDivisorsOf_9() throws Exception {

        final List<Long> result = divisor.findDivisorsOf(9);

        assertThat(result, hasItems(1L, 3L, 9L));
    }

    @Test
    public void findDivisorsOf_10() throws Exception {

        final List<Long> result = divisor.findDivisorsOf(10);

        assertThat(result, hasItems(1L, 2L, 5L, 10L));
    }

    @Test
    public void findDivisorsOf_24() throws Exception {

        final List<Long> result = divisor.findDivisorsOf(24);

        assertThat(result, hasItems(1L, 2L, 3L, 4L, 6L, 8L, 12L, 24L));
    }

    @Test
    public void numbersNotExceedingNumberOfDivisors_10() throws Exception {

        final List<Long> result = divisor.numbersNotExceedingNumberOfDivisors(10);

        assertThat(result.size(), is(equalTo(0)));
    }

    @Test
    public void numbersNotExceedingNumberOfDivisors_24() throws Exception {

        final List<Long> result = divisor.numbersNotExceedingNumberOfDivisors(24);

        assertThat(result.size(), is(equalTo(1)));
        assertThat(result, is(equalTo(Arrays.asList(24L))));
    }

    @Test
    public void numbersNotExceedingNumberOfDivisors_100() throws Exception {

        final List<Long> result = divisor.numbersNotExceedingNumberOfDivisors(100);

        assertThat(result.size(), is(equalTo(10)));
        assertThat(result, is(equalTo(Arrays.asList(24L, 30L, 40L, 42L, 54L, 56L, 66L, 70L, 78L, 88L))));
    }

    @Test
    public void numbersNotExceedingNumberOfDivisors_1000() throws Exception {

        final List<Long> result = divisor.numbersNotExceedingNumberOfDivisors(1000);

        assertThat(result.size(), is(equalTo(180)));
    }

    @Test
    public void numbersNotExceedingNumberOfDivisors_10000() throws Exception {

        final List<Long> result = divisor.numbersNotExceedingNumberOfDivisors(10000);

        assertThat(result.size(), is(equalTo(2114)));
    }
/*
    @Test
    public void numbersNotExceedingNumberOfDivisors_100000() throws Exception {

        final List<Long> result = divisor.numbersNotExceedingNumberOfDivisors(100000);

        assertThat(result.size(), is(equalTo(22181)));
    }

    @Test
    public void numbersNotExceedingNumberOfDivisors_1000000() throws Exception {

        final List<Long> result = divisor.numbersNotExceedingNumberOfDivisors(1000000);

        assertThat(result.size(), is(equalTo(224427)));
    }*/
}
