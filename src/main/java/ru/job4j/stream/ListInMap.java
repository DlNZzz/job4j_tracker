package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class ListInMap {
    public Map<String, Student> collect(List<Student> students) {
        return students
                .stream()
                .collect(
                        Collectors.toMap(
                                Student::getSurname,
                                e -> e,
                                (s, e) -> s)
                );
    }
}
