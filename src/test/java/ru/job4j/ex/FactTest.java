package ru.job4j.ex;

import org.junit.Test;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void testCalc() {
        new Fact().calc(-12);
    }
}