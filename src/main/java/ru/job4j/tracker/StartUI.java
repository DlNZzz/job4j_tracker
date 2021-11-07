package ru.job4j.tracker;

import java.util.List;

public class StartUI {
    private Output out;

    public StartUI() {
        out = new ConsoleOutput();
    }

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store memTracker, List<UserAction> listAction) {
        boolean run = true;
        while (run) {
            this.showMenu(listAction);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= listAction.size()) {
                out.println("Wrong input, you can select: 0 .. " + (listAction.size() - 1));
                continue;
            }
            UserAction action = listAction.get(select);
            run = action.execute(input, memTracker);
        }
    }

    private void showMenu(List<UserAction> listAction) {
        out.println("Menu.");
        for (int index = 0; index < listAction.size(); index++) {
            out.println(index + ". " + listAction.get(index).name());
        }
    }

    public static void main(String[] args) {
        Input input = new ValidateInput(
                new ConsoleInput()
        );
        Output output = new ConsoleOutput();
        try (Store tracker = new SqlTracker()) {
            tracker.init();
            List<UserAction> actions = List.of(
                    new CreateAction(output),
                    new ReplaceAction(output),
                    new DeleteAction(output),
                    new FindAllAction(output),
                    new FindByIdAction(output),
                    new FindByNameAction(output),
                    new ExitAction()
            );
            new StartUI().init(input, tracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}