package self.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.Map;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class SqrtFactorDivisorTest {

    private SqrtFactorDivisor divisor;
    private long start;

    @Before
    public void setUp() throws Exception {

        divisor = new SqrtFactorDivisor(8);
        start = System.currentTimeMillis();
    }

    @After
    public void tearDown() throws Exception {

        System.out.println(String.format("Test took [%s]ms", System.currentTimeMillis() - start));
    }

    @Test
    public void findFactors_24() throws Exception {

        final Map<Long, Integer> result = divisor.findFactors(24L);

        assertThat(result.size(), is(equalTo(2)));
        assertThat(result.get(2L), is(equalTo(3)));
        assertThat(result.get(3L), is(equalTo(1)));
    }

    @Test
    public void findFactors_6552() throws Exception {

        final Map<Long, Integer> result = divisor.findFactors(6552L);

        assertThat(result.size(), is(equalTo(4)));
        assertThat(result.get(2L), is(equalTo(3)));
        assertThat(result.get(3L), is(equalTo(2)));
        assertThat(result.get(7L), is(equalTo(1)));
        assertThat(result.get(13L), is(equalTo(1)));
    }

    @Test
    public void numbersNotExceedingNumberOfDivisors_10() throws Exception {

        final Collection<Long> result = divisor.numbersNotExceedingNumberOfDivisors(10L);

        assertThat(result.size(), is(equalTo(0)));
    }

    @Test
    public void numbersNotExceedingNumberOfDivisors_24() throws Exception {

        final Collection<Long> result = divisor.numbersNotExceedingNumberOfDivisors(24L);

        assertThat(result.size(), is(equalTo(1)));
        assertThat(result, hasItems(24L));
    }

    @Test
    public void numbersNotExceedingNumberOfDivisors_100() throws Exception {

        final Collection<Long> result = divisor.numbersNotExceedingNumberOfDivisors(100L);

        assertThat(result.size(), is(equalTo(10)));
        assertThat(result, hasItems(24L, 30L, 40L, 42L, 54L, 56L, 66L, 70L, 78L, 88L));
    }

    @Test
    public void numbersNotExceedingNumberOfDivisors_1000() throws Exception {

        final Collection<Long> result = divisor.numbersNotExceedingNumberOfDivisors(1000L);

        assertThat(result.size(), is(equalTo(180)));
        assertThat(result, hasItems(24L, 30L, 40L, 42L, 54L, 56L, 66L, 70L, 78L, 88L, 102L, 104L, 105L,
            110L, 114L, 128L, 130L, 135L, 136L, 138L, 152L, 154L, 165L, 170L, 174L, 182L, 184L, 186L, 189L, 190L, 195L,
            222L, 230L, 231L, 232L, 238L, 246L, 248L, 250L, 255L, 258L, 266L, 273L, 282L, 285L, 286L, 290L, 296L, 297L,
            310L, 318L, 322L, 328L, 344L, 345L, 351L, 354L, 357L, 366L, 370L, 374L, 375L, 376L, 385L, 399L, 402L, 406L,
            410L, 418L, 424L, 426L, 429L, 430L, 434L, 435L, 438L, 442L, 455L, 459L, 465L, 470L, 472L, 474L, 483L, 488L,
            494L, 498L, 506L, 513L, 518L, 530L, 534L, 536L, 555L, 561L, 568L, 574L, 582L, 584L, 590L, 595L, 598L, 602L,
            606L, 609L, 610L, 615L, 618L, 621L, 627L, 632L, 638L, 642L, 645L, 646L, 651L, 654L, 658L, 663L, 664L, 665L,
            670L, 678L, 682L, 686L, 705L, 710L, 712L, 715L, 730L, 741L, 742L, 754L, 759L, 762L, 776L, 777L, 782L, 783L,
            786L, 790L, 795L, 805L, 806L, 808L, 814L, 822L, 824L, 826L, 830L, 834L, 837L, 854L, 856L, 861L, 872L, 874L,
            875L, 885L, 890L, 894L, 897L, 902L, 903L, 904L, 906L, 915L, 935L, 938L, 942L, 946L, 957L, 962L, 969L, 970L,
            978L, 986L, 987L, 994L, 999L));
    }

    @Test
    public void numbersCountNotExceedingNumberOfDivisors_24() throws Exception {

        final Long result = divisor.numbersCountNotExceedingNumberOfDivisors(24L);

        assertThat(result, is(equalTo(1L)));
    }

    @Test
    public void numbersCountNotExceedingNumberOfDivisors_100() throws Exception {

        final Long result = divisor.numbersCountNotExceedingNumberOfDivisors(100L);

        assertThat(result, is(equalTo(10L)));
    }

    @Test
    public void numbersCountNotExceedingNumberOfDivisors_1000() throws Exception {

        final Long result = divisor.numbersCountNotExceedingNumberOfDivisors(1000L);

        assertThat(result, is(equalTo(180L)));
    }

    @Test
    public void numbersCountNotExceedingNumberOfDivisors_10000() throws Exception {

        final Long result = divisor.numbersCountNotExceedingNumberOfDivisors(10000L);

        assertThat(result, is(equalTo(2114L)));
    }

    @Test
    public void numbersCountNotExceedingNumberOfDivisors_50000() throws Exception {

        final Long result = divisor.numbersCountNotExceedingNumberOfDivisors(50000L);

        assertThat(result, is(equalTo(10957L)));
    }

    @Test
    public void numbersCountNotExceedingNumberOfDivisors_100000() throws Exception {

        final Long result = divisor.numbersCountNotExceedingNumberOfDivisors(100000L);

        assertThat(result, is(equalTo(22181L)));
    }
}
