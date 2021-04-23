package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }
/*
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getName().contains(key)
                    || person.getSurname().contains(key)
                    || person.getAddress().contains(key)
                    || person.getPhone().contains(key)) {
                result.add(person);
            }
        }
        return result;
    }
*/

    public ArrayList<Person> find(String key) {
        Predicate<Person> combineName = s -> s.getName().contains(key);
        Predicate<Person> combineSurname = s -> s.getSurname().contains(key);
        Predicate<Person> combineAddress = s -> s.getAddress().contains(key);
        Predicate<Person> combinePhone = s -> s.getPhone().contains(key);
        Predicate<Person> combine = combineName.or(combineSurname).
                or(combineAddress).or(combinePhone);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}