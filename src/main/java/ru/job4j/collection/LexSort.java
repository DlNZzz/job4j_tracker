package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] arrayLeft = left.split("\\.");
        String[] arrayRight = right.split("\\.");
        for (int i = 0; i < Math.min(arrayLeft.length, arrayRight.length); i++) {
            int l = Integer.parseInt(arrayLeft[i]);
            int r = Integer.parseInt(arrayRight[i]);
            if (l > r) {
                return 1;
            }
            if (l < r) {
                return -1;
            }
        }
        return 0;
    }
}