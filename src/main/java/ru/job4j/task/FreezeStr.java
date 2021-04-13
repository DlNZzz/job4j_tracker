package ru.job4j.task;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        Map<String, Integer> map = new HashMap<>();
        String[] arrayLeft = left.split("");
        String[] arrayRight = right.split("");
        for (String symbol : arrayLeft) {
            if (map.containsKey(symbol)) {
                map.put(symbol, map.get(symbol) + 1);
            } else {
                map.put(symbol, 0);
            }
        }
        for (String symbol : arrayRight) {
            if (map.containsKey(symbol)) {
                int count = map.get(symbol);
                if (count == 0) {
                    map.remove(symbol);
                } else {
                    map.put(symbol, --count);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }
}