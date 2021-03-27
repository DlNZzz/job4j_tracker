package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            String msgID = "Enter id: ";
            String msg = "Enter name: ";
            int select = input.askInt("Select: ");
            if (select == 0) {
                System.out.println("==== Create a new Item ====");
                String name = input.askStr(msg);
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("==== Show all items ====");
                Item[] items = tracker.findAll();
                for (Item item : items) {
                    System.out.println(item);
                }
            } else if (select == 2) {
                System.out.println("==== Edit item ====");
                int id = input.askInt(msgID);
                String name = input.askStr(msg);
                Item newItem = new Item(name);
                if (tracker.replace(id, newItem)) {
                    System.out.println("Успешно");
                } else {
                    System.out.println("Неуспешно");
                }
            } else if (select == 3) {
                System.out.println("==== Delete item ====");
                int id = input.askInt(msgID);
                if (tracker.delete(id)) {
                    System.out.println("Успешно");
                } else {
                    System.out.println("Неуспешно");
                }
            } else if (select == 4) {
                System.out.println("==== Find item by Id ====");
                int id = input.askInt(msgID);
                Item item = tracker.findById(id);
                if (item == null) {
                    System.out.println("Заявка с таким id не найдена");
                } else {
                    System.out.println(item);
                }
            } else if (select == 5) {
                System.out.println("==== Find items by name ====");
                String name = input.askStr(msg);
                Item[] items = tracker.findByName(name);
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Заявки с таким именем не найдены");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}