package ru.job4j.tracker;

import java.util.Arrays;
import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, List<UserAction> listAction) {
        boolean run = true;
        while (run) {
            this.showMenu(listAction);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= listAction.size()) {
                out.println("Wrong input, you can select: 0 .. " + (listAction.size() - 1));
                continue;
            }
            UserAction action = listAction.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> listAction) {
        out.println("Menu.");
        for (int index = 0; index < listAction.size(); index++) {
            out.println(index + ". " + listAction.get(index).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(),
                new CreateAction(output),
                new FindAllAction(output),
                new ReplaceAction(output),
                new DeleteAction(output),
                new FindByIdAction(output),
                new FindByNameAction(output)
        };
        List<UserAction> listAction = Arrays.asList(actions);
        new StartUI(output).init(input, tracker, listAction);
    }
}