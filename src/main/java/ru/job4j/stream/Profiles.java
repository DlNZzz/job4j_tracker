package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//(h1, h2) -> h1.getCity().compareTo(h2.getCity())

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        return profiles
                .stream()
                .map(Profile::getAddress)
                .sorted((h1, h2) -> h1.compare(h1, h2))
                .distinct()
                .collect(Collectors.toList());
    }
}
