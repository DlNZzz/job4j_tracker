package ru.job4j.lambda;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DiapasonTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = new Diapason().diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenLinearResults2() {
        List<Double> result = new Diapason().diapason(0, 1, x -> x);
        List<Double> expected = Arrays.asList(0D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenLinearResults3() {
        List<Double> result = new Diapason().diapason(0, 4, x -> x * x);
        List<Double> expected = Arrays.asList(0D, 1D, 4D, 9D);
        assertThat(result, is(expected));
    }
}