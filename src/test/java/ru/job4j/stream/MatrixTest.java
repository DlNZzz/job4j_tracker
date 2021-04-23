package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixTest {
    @Test
    public void whenCollectClass() {
        Integer[][] listlist = new Integer[0][];
        Matrix matrix = new Matrix();
        List<Integer> rsl = matrix.collect(listlist);
        List<Integer> expected = List.of(
        );
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClass2() {
        Integer[][] listlist = {{0, 1, 2}, {0, 9}};
        Matrix matrix = new Matrix();
        List<Integer> rsl = matrix.collect(listlist);
        List<Integer> expected = List.of(
                0,
                1,
                2,
                0,
                9
        );
        assertThat(rsl, is(expected));
    }
}