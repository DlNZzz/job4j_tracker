package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        out.println("==== Edit item ====");
        int id = input.askInt("Enter ID: ");
        String name = input.askStr("Enter name: ");
        Item newItem = new Item(name);
        if (memTracker.replace(id, newItem)) {
            out.println("Успешно");
        } else {
            out.println("Неуспешно");
        }
        return true;
    }
}
