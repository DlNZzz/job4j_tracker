package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int sumAllOperation(int y) {
        return sum(y) + minus(y) + divide(y) + multiply(y);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int rslSum = sum(1);
        int rslMinus = minus(2);
        int rslDivide = calculator.divide(3);
        int rslMultiply = calculator.multiply(4);
        int rslSumAllOperation = calculator.sumAllOperation(5);
        System.out.println(rslSum);
        System.out.println(rslMinus);
        System.out.println(rslDivide);
        System.out.println(rslMultiply);
        System.out.println(rslSumAllOperation);
    }
}