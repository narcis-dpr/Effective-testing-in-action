package com.example.effectiveT.src.main.java;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

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
}