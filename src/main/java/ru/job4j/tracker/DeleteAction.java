package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        out.println("==== Delete item ====");
        int id = input.askInt("Enter ID: ");
        if (memTracker.delete(id)) {
            out.println("Успешно");
        } else {
            out.println("Неуспешно");
        }
        return true;
    }
}
