package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book headFirst = new Book("headFirst", 700);
        Book cleanCode = new Book("Clean code", 40);
        Book javaHerbertSchildt = new Book("javaHerbertSchildt", 1500);
        Book java = new Book("java", 999);
        Book[] array = new Book[4];
        array[0] = headFirst;
        array[1] = cleanCode;
        array[2] = javaHerbertSchildt;
        array[3] = java;
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].getName() + " " + array[i].getCount());
        }
        System.out.println();
        Book temp = array[0];
        array[0] = array[3];
        array[3] = temp;
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].getName() + " " + array[i].getCount());
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            if (array[i].getName().equals("Clean code")) {
                System.out.println(array[i].getName() + " " + array[i].getCount());
            }
        }
    }
}
