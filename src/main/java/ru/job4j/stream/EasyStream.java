package ru.job4j.stream;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {

    private List<Integer> list;

    private EasyStream(List<Integer> list) {
        this.list = list;
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> list2 = new ArrayList<>();
        for (Integer number : list) {
            number = fun.apply(number);
            list2.add(number);
        }
        return new EasyStream(list2);
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> list2 = new ArrayList<>();
        for (Integer number : list) {
            if (fun.test(number)) {
                list2.add(number);
            }
        }
        return new EasyStream(list2);
    }

    public List<Integer> collect() {
        return new ArrayList<>(list);
    }
}