package ru.job4j.tracker;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Entity
@Table(name = "items")
public class Item {
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;

    private LocalDateTime created = LocalDateTime.now();

    public Item() {
    }

    public Item(String name) {
        this.name = name;
        this.description = "";
        long millis = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(millis);
        created = timestamp.toLocalDateTime();
    }

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
        long millis = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(millis);
        created = timestamp.toLocalDateTime();
    }

    @Override
    public String toString() {
        return String.format("id: %s, name: %s, created: %s", id, name, FORMATTER.format(created));
    }
}