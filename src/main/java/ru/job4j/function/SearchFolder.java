package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFolder {
    public boolean check(Predicate<String> pred, String s) {
        return pred.test(s);
    }

    public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
        List<Folder> rsl = new ArrayList<>();
        SearchFolder searchFolder = new SearchFolder();
        for (Folder f : list) {
            if (searchFolder.check(str -> str.contains("bug"), f.getName()) && pred.test(f)) {
                rsl.add(f);
            } else if (searchFolder.check(i -> Integer.parseInt(i) > 100,
                    String.valueOf(f.getSize())) && pred.test(f)) {
                rsl.add(f);
            }
        }
        return rsl;
    }
}