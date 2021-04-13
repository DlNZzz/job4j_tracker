package ru.job4j.task;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Article {
    public static boolean generateBy(String origin, String line) {
        boolean rsl = true;
        String[] originText = origin.replaceAll("\\p{P}", "").split(" ");
        String[] lineText = line.replaceAll("\\p{P}", "").split(" ");
        Set<String> check = new HashSet<>(Arrays.asList(originText));
        for (String word : lineText) {
            if (!check.contains(word)) {
                return false;
            }
        }
        return rsl;
    }
}