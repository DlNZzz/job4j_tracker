package ru.job4j.poly;

public class Transport2 {
    public static void main(String[] args) {
        Vehicle airplane = new Airplane();
        Vehicle bus2 = new Bus2();
        Vehicle train = new Train();
        Vehicle[] vehicles = new Vehicle[] {airplane, bus2, train};
        for (Vehicle v : vehicles) {
            v.move();
        }
    }
}
