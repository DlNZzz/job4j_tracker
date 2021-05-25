package ru.job4j.calculator;

import static ru.job4j.math.MathFunction.*;

public class MathCalculator {

    public static double sumAndMultiply(double first, double second) {
        return sum(first, second)
                + multiply(first, second);
    }

    public static double differenceAnddivision(double first, double second) {
        return sum(difference(first, second), division(first, second));
    }

    public static double sumAndSum(double first, double second) {
        return sum(sum(sum(first, second), multiply(first, second)),
                sum(difference(first, second), division(first, second)));
    }

    public static void main(String[] args) {
        System.out.println("Результат расчета равен: " + sumAndMultiply(10, 20));
    }
}