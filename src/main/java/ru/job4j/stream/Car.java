package ru.job4j.stream;

public class Car {
    private String name;
    private int age;
    private String engine;
    private int fuel;
    private int speed;

    static class Builder {
        private String name;
        private int age;
        private String engine;
        private int fuel;
        private int speed;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildAge(int age) {
            this.age = age;
            return this;
        }

        Builder buildEngine(String engine) {
            this.engine = engine;
            return this;
        }

        Builder buildFuel(int fuel) {
            this.fuel = fuel;
            return this;
        }

        Builder buildSpeed(int speed) {
            this.speed = speed;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.name = name;
            car.age = age;
            car.engine = engine;
            car.fuel = fuel;
            car.speed = speed;
            return car;
        }
    }
}
