package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        /*
        ArrayList<String> list = (ArrayList<String>) fillGaps(orgs);
        Set<String> tmp = new LinkedHashSet<>();
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    String temp = list.get(i);
                    list.set(i, list.get(j));
                    list.add(temp);
                }
            }
        }
        for (String s : list) {
            tmp.add(s);
        }*/
        return 0;
    }
}