package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] o1Array = o1.split("/");
        String[] o2Array = o2.split("/");
        int o1Length = o1.split("/").length;
        int o2Length = o2.split("/").length;
        if (o1Array[0].compareTo(o2Array[0]) == 0) {
            for (int i = 1; i < Math.min(o1Length, o2Length); i++) {
                if (o1Array[i].compareTo(o2Array[i]) != 0) {
                    return o1Array[i].compareTo(o2Array[i]);
                }
            }
        }
        return o1Length > o2Length ? 1 : -1;
    }
}
