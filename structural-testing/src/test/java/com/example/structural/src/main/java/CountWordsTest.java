package com.example.structural.src.main.java;



import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.Test;

public class CountWordsTest {
    @Test
    public void twoWordsEndingWithS() {
        int words = new CountWords().count("dogs cats");
        assertThat(words).isEqualTo(2);
    }

    @Test
    public void noWordsAtAll() {
        int words = new CountWords().count("dog cat");
        assertThat(words).isEqualTo(0);
    }

    @Test
    public void wordsThatEndInR() {
        int words = new CountWords().count("car bar");
        assertThat(words).isEqualTo(2);
    }
}