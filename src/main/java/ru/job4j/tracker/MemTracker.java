package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MemTracker implements Store {
    private final List<Item> list = new ArrayList<>();
    private int ids = 1;

    @Override
    public void init() {

    }

    public Item add(Item item) {
        item.setId(ids++);
        list.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? list.get(index) : null;
    }

    public List<Item> findAll() {
        return list;
    }

    public List<Item> findByName(String key) {
        List<Item> list = new ArrayList<>();
        for (Item item : this.list) {
            if (item.getName().equals(key)) {
                list.add(item);
            }
        }
        return list;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < list.size(); index++) {
            if (list.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            list.set(index, item);
            item.setId(id);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            list.remove(index);
        }
        return rsl;
    }

    @Override
    public void close() throws Exception {

    }
}