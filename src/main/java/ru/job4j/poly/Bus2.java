package ru.job4j.poly;

public class Bus2 implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " идет по трассе");
    }
}
