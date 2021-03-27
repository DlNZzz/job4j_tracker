package ru.job4j.poly;

public class Bus implements Transport {
    private int passenger;
    private int price;

    @Override
    public void ride() {
        System.out.println("Едет");
    }

    @Override
    public void setPassengers(int passenger) {
        this.passenger = passenger;
    }

    @Override
    public int refuel(int quantity) {
        return price * quantity;
    }
}
