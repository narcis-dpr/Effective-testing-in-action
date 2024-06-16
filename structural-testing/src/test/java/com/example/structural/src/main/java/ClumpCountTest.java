package com.example.structural.src.main.java;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class ClumpCountTest {

    @ParameterizedTest
    @MethodSource("generator")
    public void testClumps(int[] nums, int expectedNoOfClump) {
        assertThat(ClumpCount.countClumps(nums)).isEqualTo(expectedNoOfClump);
    }

    static Stream<Arguments> generator() {
        return Stream.of(
                of(new int[]{}, 0), // empty
                of(null, 0), // null
                of(new int[]{1,2,2,2,1}, 1), // one clump
                of(new int[]{1}, 0), // one element

                // an example of a missing test case!! Structural testing is not enough!
                of(new int[]{2,2}, 1)
        );
    }
}
