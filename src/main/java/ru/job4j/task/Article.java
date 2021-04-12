package ru.job4j.task;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Article {
    public static boolean generateBy(String origin, String line) {
        Set<String> set = new HashSet<>(Arrays.asList(origin.split(" ")));
        int count = line.split(" ").length;
        for (String wordL : line.split(" ")) {
            for (String word : set) {
                char symbol = word.substring(word.length() - 1).charAt(0);
                if (!(symbol >= 'а') || !(symbol <= 'я')) {
                    if (word.substring(0, word.length() - 1).equals(wordL)) {
                        count--;
                        break;
                    }
                } else {
                    if (word.equals(wordL)) {
                        count--;
                        break;
                    }
                }
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        System.out.println("123456".substring(0, 4));
        System.out.println('а' + 0);
        System.out.println('я' + 0);
    }
}