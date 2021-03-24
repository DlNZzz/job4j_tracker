package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student jora = new Student();
        jora.setName("Jora");
        jora.setGroup("ИЭ-47-19");
        jora.setCreated(new Date());
        System.out.println(jora.getName() + "\n" + jora.getGroup() + "\n" + jora.getCreated());
    }
}
