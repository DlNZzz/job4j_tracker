package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    @Test
    public void whenCollectClass() {
        List<Profile> students = List.of(
        );
        Profiles profiles = new Profiles();
        List<Address> rsl = profiles.collect(students);
        List<Address> expected = new ArrayList<>();
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassA() {
        Address address = new Address("city", "street", 10, 22);
        Address address2 = new Address("city3", "street3", 102, 242);
        Address address3 = new Address("city2", "street2", 101, 232);
        List<Profile> students = List.of(
                new Profile(address),
                new Profile(address2),
                new Profile(address3),
                new Profile(new Address("city", "street", 10, 22))
        );
        Profiles profiles = new Profiles();
        List<Address> rsl = profiles.collect(students);
        List<Address> expected = new ArrayList<>();
        expected.add(address);
        expected.add(address3);
        expected.add(address2);
        assertThat(rsl, is(expected));
    }
}