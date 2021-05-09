package ru.job4j.stream;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(s -> s.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(n -> new Tuple(n.getName(), n.getSubjects().stream()
                        .mapToDouble(Subject::getScore)
                        .average()
                        .orElse(0)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(s -> s.getSubjects().stream())
                .collect(Collectors
                        .groupingBy(Subject::getName,
                                Collectors.averagingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(n -> new Tuple(n.getKey(), n.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(n -> new Tuple(n.getName(), n.getSubjects().stream()
                        .mapToDouble(Subject::getScore)
                        .sum()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(new Tuple("", 0));
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(s -> s.getSubjects().stream())
                .collect(Collectors
                        .groupingBy(Subject::getName,
                                Collectors.summingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(n -> new Tuple(n.getKey(), n.getValue()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(new Tuple("", 0));
    }
}