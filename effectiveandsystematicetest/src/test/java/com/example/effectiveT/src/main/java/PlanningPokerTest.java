package com.example.effectiveT.src.main.java;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.Combinators;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PlanningPokerTest {

    @Test
    public void rejectNullInput() {
        assertThatThrownBy(() -> new PlanningPoker().identifyExtremes(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void rejectEmptyList() {
        assertThatThrownBy(() -> {
            List<Estimate> emptyList = Collections.emptyList();
            new PlanningPoker().identifyExtremes(emptyList);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void rejectSingleEstimate() {
        assertThatThrownBy(() -> {
            List<Estimate> list = Arrays.asList(new Estimate("Eleanor", 1));
            new PlanningPoker().identifyExtremes(list);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void twoEstimates() {
        List<Estimate> list = Arrays.asList(
                new Estimate("Mauricio", 10),
                new Estimate("Frank", 5)
        );
        List<String> devs = new PlanningPoker().identifyExtremes(list);

        assertThat(devs).containsExactlyInAnyOrder("Mauricio", "Frank");
    }

    @Test
    public void manyEstimates() {
        List<Estimate> list = Arrays.asList(
                new Estimate("Mauricio", 10),
                new Estimate("Arie", 5),
                new Estimate("Andy", 10),
                new Estimate("Frank", 7),
                new Estimate("Annibale", 5)
        );

        List<String> devs = new PlanningPoker().identifyExtremes(list);

        assertThat(devs).containsExactlyInAnyOrder("Mauricio", "Arie");
    }

    @Property
    void estimatesInAnyOrder(@ForAll("estimates") List<Estimate> estimates) {
        estimates.add(new Estimate("MrLowEstimate", 1));
        estimates.add(new Estimate("MsHighEstimate", 100));
        Collections.shuffle(estimates);

        List<String> devs = new PlanningPoker().identifyExtremes(estimates);

        assertThat(devs)
                .containsExactlyInAnyOrder("MrLowEstimate", "MsHighEstimate");
    }
//    @Test
//    public void inAnyOrder() {
//        estimates.add(new Estimate("MrLowEstimate", 1));
//        estimates.add(new Estimate("MsHighEstimate", 100));
//
//        Collections.shuffle(estimates);
//
//        List<String> dev = new PlanningPoker().identifyExtremes(estimates);
//
//        assertThat(dev).containsExactlyInAnyOrder("MrLowEstimate", "MsHighEstimate");
//    }

    @Provide
    Arbitrary<List<Estimate>> estimate() {
        Arbitrary<String> names = Arbitraries.strings().withCharRange('a', 'z').ofLength(5);

        Arbitrary<Integer> values = Arbitraries.integers().between(2, 99);
        Arbitrary<Estimate> estimates = Combinators.combine(names, values)
                .as((name, value) -> new Estimate(name, value));

        return estimates.list().ofMinSize(1);
    }

    @Test
    public void developersWithSameEstimates() {
        List<Estimate> list = Arrays.asList(
                new Estimate("Mauricio", 10),
                new Estimate("Arie", 5),
                new Estimate("Andy", 10),
                new Estimate("Frank", 7),
                new Estimate("Annibale", 5)
        );
        List<String> devs = new PlanningPoker().identifyExtremes(list);

        assertThat(devs).containsExactlyInAnyOrder("Mauricio", "Arie");
    }

    @Test
    public void allDevelopersWithTheSameEstimate() {
        List<Estimate> list = Arrays.asList(
                new Estimate("Mauricio", 10),
                new Estimate("Arie", 10),
                new Estimate("Andy", 10),
                new Estimate("Frank", 10),
                new Estimate("Annibale", 10)
        );
        List<String> devs = new PlanningPoker().identifyExtremes(list);
        assertThat(devs).isEmpty();
    }

}