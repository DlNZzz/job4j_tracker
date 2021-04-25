package ru.job4j.stream;

import java.util.Comparator;
import java.util.Objects;

public class Profile {
    private Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}
