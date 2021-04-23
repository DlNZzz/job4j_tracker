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
        List<Profile> students = List.of(
                new Profile(new Address("city", "street", 10, 22)),
                new Profile(new Address("city2", "street2", 101, 232)),
                new Profile(new Address("city3", "street3", 102, 242)),
                new Profile(new Address("city4", "street4", 103, 252))
        );
        Profiles profiles = new Profiles();
        List<Address> rsl = profiles.collect(students);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("city", "street", 10, 22));
        expected.add(new Address("city2", "street2", 101, 232));
        expected.add(new Address("city3", "street3", 102, 242));
        expected.add(new Address("city4", "street4", 103, 252));
        assertThat(rsl, is(expected));
    }
}