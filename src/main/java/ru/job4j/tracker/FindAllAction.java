package ru.job4j.tracker;

import java.util.List;

public class FindAllAction implements UserAction {
    private final Output out;

    public FindAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        out.println("==== Show all items ====");
        List<Item> list = memTracker.findAll();
        for (Item item : list) {
            out.println(item);
        }
        return true;
    }
}
