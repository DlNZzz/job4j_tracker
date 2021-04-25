package ru.job4j.stream;

import java.util.stream.Stream;

import static java.util.stream.Stream.of;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(level -> of(Value.values())
                        .map(task -> level + " " + task))
                .forEach(System.out::println);
    }
}