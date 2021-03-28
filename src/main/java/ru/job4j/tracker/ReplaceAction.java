package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("==== Edit item ====");
        int id = input.askInt("Enter ID: ");
        String name = input.askStr("Enter name: ");
        Item newItem = new Item(name);
        if (tracker.replace(id, newItem)) {
            System.out.println("Успешно");
        } else {
            System.out.println("Неуспешно");
        }
        return true;
    }
}
