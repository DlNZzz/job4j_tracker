package ru.job4j.tracker;

public class FindItemById implements UserAction {
    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("==== Find item by Id ====");
        int id = input.askInt("Enter ID: ");
        Item item = tracker.findById(id);
        if (item == null) {
            System.out.println("Заявка с таким id не найдена");
        } else {
            System.out.println(item);
        }
        return true;
    }
}
