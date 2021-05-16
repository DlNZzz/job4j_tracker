package ru.job4j.stream;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EasyStream {

    private List<Integer> list;

    private EasyStream(List<Integer> list) {
        this.list = list;
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        return new EasyStream(list.stream()
                .map(fun)
                .collect(Collectors.toList()));
    }

    public EasyStream filter(Predicate<Integer> fun) {
        return new EasyStream(list.stream()
                .filter(fun)
                .collect(Collectors.toList()));
    }

    public List<Integer> collect() {
        return list;
    }
}