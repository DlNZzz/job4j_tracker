package ru.job4j.tracker;

import org.junit.Test;

import java.time.format.DateTimeFormatter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByIdActionTest {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    @Test
    public void testExecute() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("123");
        tracker.add(item);
        FindByIdAction findByIdAction = new FindByIdAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        findByIdAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("==== Find item by Id ====" + ln
                + String.format("id: %d, name: %s, created: %s",
                item.getId(),
                item.getName(),
                item.getCreated().format(FORMATTER))
                + ln));
    }
}