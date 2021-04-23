package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ListInMapTest {
    @Test
    public void whenCollectClass() {
        List<Student> students = List.of(
        );
        ListInMap profiles = new ListInMap();
        Map<String, Student> rsl = profiles.collect(students);
        Map<String, Student> expected = new HashMap<>();
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClass2() {
        List<Student> students = List.of(
                new Student(20, "awe"),
                new Student(212, "qwer"),
                new Student(20, "awe")
        );
        ListInMap profiles = new ListInMap();
        Map<String, Student> rsl = profiles.collect(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put("awe", new Student(20, "awe"));
        expected.put("qwer", new Student(212, "qwer"));
        assertThat(rsl, is(expected));
    }
}