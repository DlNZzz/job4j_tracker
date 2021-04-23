package ru.job4j.stream;

import java.util.Comparator;
import java.util.Objects;

public class Address implements Comparator<Address> {
    private String city;
    private String street;
    private int home;
    private int apartment;

    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    @Override
    public int compare(Address o1, Address o2) {
        return o1.city.compareTo(o2.city);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return home == address.home
                && apartment == address.apartment
                && Objects.equals(city, address.city)
                && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, home, apartment);
    }
}