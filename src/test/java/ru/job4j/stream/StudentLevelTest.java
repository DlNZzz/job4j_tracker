package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StudentLevelTest {

    @Test
    public void whenSorted() {
        List<Student2> input = new ArrayList<>();
        input.add(new Student2("Masha", 28));
        input.add(new Student2("Pety", 128));
        List<Student2> expected = List.of(
                new Student2("Pety", 128),
                new Student2("Masha", 28)
        );
        assertThat(StudentLevel.levelOf(input, 20), is(expected));
    }

    @Test
    public void whenOnlyNull() {
        List<Student2> input = new ArrayList<>();
        input.add( null);
        List<Student2> expected = List.of();
        assertThat(StudentLevel.levelOf(input, 100), is(expected));
    }

    @Test
    public void whenHasNull() {
        List<Student2> input = new ArrayList<>();
        input.add( null);
        input.add(new Student2("Pety",28));
        List<Student2> expected = List.of(new Student2("Pety",28));
        assertThat(StudentLevel.levelOf(input, 10), is(expected));
    }
}
