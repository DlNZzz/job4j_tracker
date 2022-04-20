package ru.job4j.tracker;

import org.junit.Test;

import java.time.format.DateTimeFormatter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByNameActionTest {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    @Test
    public void testExecute() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("123");
        tracker.add(item);
        FindByNameAction findByNameAction = new FindByNameAction(out);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("123");
        findByNameAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("==== Find items by name ====" + ln
                + String.format("id: %d, name: %s, created: %s",
                item.getId(),
                item.getName(),
                item.getCreated().format(FORMATTER))
                + ln));
    }
}