package com.example.specification_based.src.main.java;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.Test;

public class SubstringUtilsTest {

    @Test
    public void simpleCase() {
        assertThat(SubstringUtils.substringsBetween("abcd", "a", "d"))
                .isEqualTo(new String[]{"bc"});
    }

    @Test
    public void manySubstrings() {
        assertThat(
                SubstringUtils.substringsBetween("abcdabcdab", "a", "d")
        ).isEqualTo(new String[]{"bc", "bc"});
    }

    @Test
    public void openAndCloseTagsThatAreLongerThan1Char() {
        assertThat(SubstringUtils.substringsBetween("aabcddaabfddaab", "aa", "dd"))
                .isEqualTo(new String[]{"bc", "bf"});
    }

}