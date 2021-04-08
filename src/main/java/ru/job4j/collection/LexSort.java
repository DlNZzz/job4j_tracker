package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] arrayLeft = left.split("\\.");
        String[] arrayRight = right.split("\\.");
        int leftInt = Integer.parseInt(arrayLeft[0]);
        int rightInt = Integer.parseInt(arrayRight[0]);
        return Integer.compare(leftInt, rightInt);
    }
}