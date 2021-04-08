package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        char[] charsLeft = left.toCharArray();
        char[] charsRight = right.toCharArray();
        int rsl = 0;
        for (int i = 0; i < Math.min(charsLeft.length, charsRight.length); i++) {
            if ((rsl = Character.compare(charsLeft[i], charsRight[i])) != 0) {
                break;
            }
        }
        return rsl == 0 ? Integer.compare(charsLeft.length, charsRight.length) : rsl;
    }
}