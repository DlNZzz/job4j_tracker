package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] array = new Item[size];
        int len = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                array[len++] = items[i];
            }
        }
        return Arrays.copyOf(array, len);
    }

    public Item[] findByName(String key) {
        Item[] array = new Item[size];
        int len = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i].getName().equals(key)) {
                array[len++] = items[i];
            }
        }
        return Arrays.copyOf(array, len);
    }
}