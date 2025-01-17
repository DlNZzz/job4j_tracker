package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        out.println("==== Find items by name ====");
        String name = input.askStr("Enter name: ");
        List<Item> list = memTracker.findByName(name);
        if (list.size() > 0) {
            for (Item item : list) {
                out.println(item);
            }
        } else {
            out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}
