package ru.job4j.collection;

import java.util.*;
/*
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
        }
 */
public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                start += start.equals("") ? el : "/" + el;
                tmp.add(start);
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        List<String> list = fillGaps(orgs);
        Collections.sort(list);
    }

    public static void sortDesc(List<String> orgs) {
        ArrayList<String> list = (ArrayList<String>) fillGaps(orgs);
        Collections.sort(list, new DepDescComp());
    }
}