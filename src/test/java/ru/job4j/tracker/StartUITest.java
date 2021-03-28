package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() + "0. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenFindAllAction() {
        String ln = System.lineSeparator();
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new FindAllAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String res = "Menu." + ln + "0. Show all items" + ln + "1. Exit" + ln + "==== Show all items ===="
                + ln + "Menu." + ln + "0. Show all items" + ln + "1. Exit" + ln;
        assertThat(out.toString(), is(res));
    }

    @Test
    public void whenFindByNameAction() {
        String ln = System.lineSeparator();
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "qwe", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new FindByNameAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String res = "Menu.\r\n0. Find items by name\r\n1. Exit\r\n==== Find items by name ====\r\nMenu.\r\n0. Find items by name\r\n1. Exit\r\n";
        assertThat(out.toString(), is(res));
    }

    @Test
    public void whenFindByIdAction() {
        String ln = System.lineSeparator();
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new FindByIdAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String res = "Menu.\r\n0. Find item by Id\r\n1. Exit\r\n==== Find item by Id ====\r\nMenu.\r\n0. Find item by Id\r\n1. Exit\r\n";
        assertThat(out.toString(), is(res));
    }
}