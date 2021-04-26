package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StudentLevel {
    public static List<Student2> levelOf(List<Student2> students, int bound) {
        return students.stream()
                .filter(Objects::nonNull)
                .sorted((left, right) -> left.compare(left, right))
                .takeWhile(st -> st.getScore() > bound)
                .collect(Collectors.toList());
    }
}