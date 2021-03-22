package ru.job4j.oop;

public class User {
    private String name;    // поле находится в классе
    private int age;    // поле находится в классе

    public boolean canDrive() {
        boolean can = false;    // локальная переменная находится в методе
        if (age >= 18) {
            can = true;
        }
        return can;
    }
}