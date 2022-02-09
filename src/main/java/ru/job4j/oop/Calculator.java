package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);
    }
}