package ru.job4j.profession;

public class Engineer extends Profession {
    public Engineer() {
    }

    public Engineer(String name, String surname, boolean education, int birthday) {
        super(name, surname, education, birthday);
    }

    public Project project(Engineer engineer) {
        return new Project();
    }
}
