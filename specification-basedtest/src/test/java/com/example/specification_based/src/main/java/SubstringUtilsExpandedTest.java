package com.example.specification_based.src.main.java;

import static com.example.specification_based.src.main.java.SubstringUtils.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.Test;

public class SubstringUtilsExpandedTest {

    @Test
    public void strIsNullOrEmpty() {
        assertThat(substringsBetween(null, "a", "b"))
                .isEqualTo(null);

        assertThat(substringsBetween("", "a", "b"))
                .isEqualTo(new String[]{});
    }

    @Test
    public void openIsNullOrEmpty() {
        assertThat(substringsBetween("abc", null, "b")).isEqualTo(null);
        assertThat(substringsBetween("abc", "", "b")).isEqualTo(null);
    }

    @Test
    public void closeIsNullOrEmpty() {
        assertThat(substringsBetween("abc", "a", null)).isEqualTo(null);
        assertThat(substringsBetween("abc", "a", "")).isEqualTo(null);
    }

    @Test
    public void strOfLength1() {
        assertThat(substringsBetween("a", "a", "b")).isEqualTo(null);
        assertThat(substringsBetween("a", "b", "a")).isEqualTo(null);
        assertThat(substringsBetween("a", "b", "b")).isEqualTo(null);
        assertThat(substringsBetween("a", "a", "b")).isEqualTo(null);
    }

    @Test
    public void openAndCloseOfLength1() {
        assertThat(substringsBetween("abc", "x", "y")).isEqualTo(null);
        assertThat(substringsBetween("abc", "a", "y")).isEqualTo(null);
        assertThat(substringsBetween("abc", "x", "c")).isEqualTo(null);
        assertThat(substringsBetween("abc", "a", "c")).isEqualTo(new String[] {"b", "b"});
    }

    @Test
    public void openAndCloseTagsOfDifferentSizes() {
        assertThat(substringsBetween("aabcc", "xx", "yy")).isEqualTo(null);
        assertThat(substringsBetween("aabcc", "aa", "yy")).isEqualTo(null);
        assertThat(substringsBetween("aabcc", "xx", "cc")).isEqualTo(null);
        assertThat(substringsBetween("aabbcc", "aa", "cc")).isEqualTo(new String[] {"bb"});
        assertThat(substringsBetween("aabbccaaeecc", "aa", "cc")).isEqualTo(new String[] {"bb", "ee"});
        assertThat(substringsBetween("a abb ddc ca abbcc", "a a", "c c")).isEqualTo(new String[] {"bb dd"});
    }
    @Test
    public void noSubstringBetweenOpenAndCloseTags() {
        assertThat(substringsBetween("aabb", "aa", "bb")).isEqualTo(new String[] {""});
    }
}