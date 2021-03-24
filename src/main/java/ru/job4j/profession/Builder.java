package ru.job4j.profession;

public class Builder extends Engineer {
    public Builder() {
    }

    public Builder(String name, String surname, boolean education, int birthday) {
        super(name, surname, education, birthday);
    }
}
