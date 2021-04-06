package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SortByNameItemTest {
    @Test
    public void testComparatorBigSmall() {
        List<Item> items = Arrays.asList(
                new Item("Fix bugs"),
                new Item("Impl task"),
                new Item("Reboot server")
        );
        Collections.sort(items, new SortByNameItemBigSmall());
        List<Item> matcher = Arrays.asList(
                new Item("Fix bugs"),
                new Item("Impl task"),
                new Item("Reboot server")
        );
        assertThat(items, is(matcher));
    }

    @Test
    public void testComparatorSmallBig() {
        List<Item> items = Arrays.asList(
                new Item("Fix bugs"),
                new Item("Impl task"),
                new Item("Reboot server")
        );
        Collections.sort(items, new SortByNameItemSmallBig());
        List<Item> matcher = Arrays.asList(
                new Item("Reboot server"),
                new Item("Impl task"),
                new Item("Fix bugs")
        );
        assertThat(items, is(matcher));
    }
}
