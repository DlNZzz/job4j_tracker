package ru.job4j.stream;

import java.util.Comparator;
import java.util.Objects;

public class Student2 implements Comparator<Student2> {

    private int score;
    private String surname;

    public Student2(String surname, int score) {
        this.score = score;
        this.surname = surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getScore() {
        return score;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public int compare(Student2 o1, Student2 o2) {
        return Integer.compare(o2.score, o1.score);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student2 student = (Student2) o;
        return score == student.score
                && surname.equals(student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, surname);
    }
}