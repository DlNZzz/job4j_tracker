package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"},
                out
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        List<UserAction> listAction = Arrays.asList(actions);
        new StartUI(out).init(in, tracker, listAction);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() + "0. Exit"
                + System.lineSeparator() + "Select: " + System.lineSeparator()));
    }

    @Test
    public void whenFindAllAction() {
        String ln = System.lineSeparator();
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("qwerty 123"));
        Input in = new StubInput(
                new String[] {"0", "1"},
                out
        );
        UserAction[] actions = {
                new FindAllAction(out),
                new ExitAction()
        };
        List<UserAction> listAction = Arrays.asList(actions);
        new StartUI(out).init(in, tracker, listAction);
        String res = "Menu." + ln + "0. Show all items" + ln + "1. Exit" + ln + "Select: "
                + ln + "==== Show all items ====" + ln + item + ln + "Menu."
                + ln + "0. Show all items" + ln + "1. Exit" + ln + "Select: " + ln;
        assertThat(out.toString(), is(res));
    }

    @Test
    public void whenFindByNameAction() {
        String ln = System.lineSeparator();
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("qwerty"));
        Input in = new StubInput(
                new String[] {"0", "qwerty", "1"},
                out
        );
        UserAction[] actions = {
                new FindByNameAction(out),
                new ExitAction()
        };
        List<UserAction> listAction = Arrays.asList(actions);
        new StartUI(out).init(in, tracker, listAction);
        String res = "Menu." + ln + "0. Find items by name" + ln + "1. Exit" + ln + "Select: "
                + ln + "==== Find items by name ====" + ln + "Enter name: " + ln + item
                + ln + "Menu." + ln + "0. Find items by name" + ln + "1. Exit"
                + ln + "Select: " + ln;
        assertThat(out.toString(), is(res));
    }

    @Test
    public void whenFindByIdAction() {
        String ln = System.lineSeparator();
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("qwerty"));
        String id = String.valueOf(item.getId());
        Input in = new StubInput(
                new String[] {"0", id, "1"},
                out
        );
        UserAction[] actions = {
                new FindByIdAction(out),
                new ExitAction()
        };
        List<UserAction> listAction = Arrays.asList(actions);
        new StartUI(out).init(in, tracker, listAction);
        String res = "Menu." + ln + "0. Find item by Id" + ln + "1. Exit" + ln + "Select: "
                + ln + "==== Find item by Id ====" + ln + "Enter ID: " + ln + item + ln + "Menu."
                + ln + "0. Find item by Id" + ln + "1. Exit" + ln + "Select: " + ln;
        assertThat(out.toString(), is(res));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"-322", "0"},
                out
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = new UserAction[]{
                new ExitAction()
        };
        List<UserAction> listAction = Arrays.asList(actions);
        new StartUI(out).init(in, tracker, listAction);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln + "0. Exit" + ln + "Select: "
                        + ln + "Wrong input, you can select: 0 .. 0"
                        + ln + "Menu." + ln + "0. Exit" + ln + "Select: " + ln
                )
        );
    }
}