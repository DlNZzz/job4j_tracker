package ru.job4j.collection;

import java.util.Comparator;

public class JobDescByNameSmallBig implements Comparator<Job> {
    @Override
    public int compare(Job o, Job o2) {
        return o.getName().compareTo(o2.getName());
    }
}
