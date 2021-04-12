package ru.job4j.task;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        Map<String, Integer> map = new HashMap<>();
        String[] array = left.split("");
        for (String symbol : array) {
            if (map.containsKey(symbol)) {
                map.put(symbol, map.get(symbol) + 1);
            } else {
                map.put(symbol, 0);
            }
        }
        Map<String, Integer> map2 = new HashMap<>();
        String[] array2 = right.split("");
        for (String symbol : array2) {
            if (map2.containsKey(symbol)) {
                map2.put(symbol, map2.get(symbol) + 1);
            } else {
                map2.put(symbol, 0);
            }
        }
        return map.equals(map2);
    }
}