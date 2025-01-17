package ru.job4j.oop;
/*
Если position равно 1, то в консоль должны выводиться слова песни "Пусть бегут неуклюже".

Если равно 2, то в консоль должны выводиться слова песни "Спокойной ночи".

Во всех остальных случаях должно появиться "Песня не найдена".
 */
public class Jukebox {
    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
        } else if (position == 2) {
            System.out.println("Спокойной ночи");
        } else {
            System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox musical = new Jukebox();
        musical.music(1);
        musical.music(2);
        musical.music(6534);
    }
}
