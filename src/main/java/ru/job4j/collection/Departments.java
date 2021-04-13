package ru.job4j.collection;

import java.util.*;

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
        //return new ArrayList<>(tmp);
    }
/*
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("K1/SK1",
                "K1/SK2",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K2",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2"));
        for (String s : sortAsc(list)) {
            System.out.println(s);
        }
    }
 */
}