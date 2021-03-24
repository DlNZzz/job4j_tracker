package ru.job4j.tracker;

/*
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        LocalDateTime time = item.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String timeFormat = time.format(formatter);
        System.out.println(timeFormat);
    }
}
*/

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        Tracker tracker = new Tracker();
        tracker.add(item);
        System.out.println(tracker.findById(item.getId()));
    }
}