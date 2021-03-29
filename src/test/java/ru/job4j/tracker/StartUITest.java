package ru.job4j.tracker;

import org.junit.Test;
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
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() + "0. Exit"
                + System.lineSeparator() + "Select: " + System.lineSeparator()));
    }

    @Test
    public void whenFindAllAction() {
        String ln = System.lineSeparator();
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "qwerty 123", "1", "2"},
                out
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new FindAllAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String res = "Menu." + ln + "0. Create" + ln + "1. Show all items" + ln + "2. Exit" + ln + "Select: "
                + ln + "==== Create a new Item ====" + ln + "Enter name: " + ln + "Menu." + ln + "0. Create"
                + ln + "1. Show all items" + ln + "2. Exit" + ln + "Select: " + ln + "==== Show all items ===="
                + ln + "Item{id=1, name='qwerty 123'}" + ln + "Menu." + ln + "0. Create" + ln + "1. Show all items"
                + ln + "2. Exit" + ln + "Select: " + ln;
        assertThat(out.toString(), is(res));
    }

    @Test
    public void whenFindByNameAction() {
        String ln = System.lineSeparator();
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "qwerty", "1", "qwerty", "2"},
                out
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new FindByNameAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String res = "Menu." + ln + "0. Create" + ln + "1. Find items by name" + ln + "2. Exit" + ln + "Select: "
                + ln + "==== Create a new Item ====" + ln + "Enter name: " + ln + "Menu." + ln + "0. Create"
                + ln + "1. Find items by name" + ln + "2. Exit" + ln + "Select: " + ln + "==== Find items by name ===="
                + ln + "Enter name: " + ln + "Item{id=1, name='qwerty'}" + ln + "Menu." + ln + "0. Create" + ln + "1. Find items by name" + ln + "2. Exit"
                + ln + "Select: " + ln;
        assertThat(out.toString(), is(res));
    }

    @Test
    public void whenFindByIdAction() {
        String ln = System.lineSeparator();
        Output out = new StubOutput();
        String id = "1";
        Input in = new StubInput(
                new String[] {"0", "qwerty", "1", id, "2"},
                out
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new FindByIdAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String res = "Menu." + ln + "0. Create" + ln + "1. Find item by Id" + ln + "2. Exit" + ln + "Select: "
                + ln + "==== Create a new Item ====" + ln + "Enter name: " + ln + "Menu." + ln + "0. Create"
                + ln + "1. Find item by Id" + ln + "2. Exit" + ln + "Select: " + ln + "==== Find item by Id ===="
                + ln + "Enter ID: " + ln + "Item{id=1, name='qwerty'}" + ln + "Menu." + ln + "0. Create" + ln + "1. Find item by Id" + ln + "2. Exit"
                + ln + "Select: " + ln;
        assertThat(out.toString(), is(res));
    }
}