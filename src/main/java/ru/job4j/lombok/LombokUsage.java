package ru.job4j.lombok;

public class LombokUsage {
    public static void main(String[] args) {
        var role = Role.of()
                .id(1)
                .name("ADMIN")
                .accessBy("create")
                .accessBy("update")
                .accessBy("read")
                .accessBy("delete")
                .build();
        System.out.println(role);
    }
}
