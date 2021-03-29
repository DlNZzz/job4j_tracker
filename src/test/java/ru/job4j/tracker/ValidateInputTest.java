package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"},
                out
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenInvalidInput2() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1"},
                out
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenInvalidInput3() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "2", "3", "4"},
                out
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(0));
    }

    @Test
    public void whenInvalidInput4() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"-2"},
                out
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-2));
    }
}