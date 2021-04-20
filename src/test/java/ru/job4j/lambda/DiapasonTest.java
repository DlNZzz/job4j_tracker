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
        List<Double> result = new Diapason().diapason(0, 1, x -> Math.pow(x, 2));
        List<Double> expected = Arrays.asList(0D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenLinearResults3() {
        List<Double> result = new Diapason().diapason(0, 4, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(1D, 2D, 4D, 8D);
        assertThat(result, is(expected));
    }
}