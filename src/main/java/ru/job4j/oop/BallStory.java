package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball kolobok = new Ball();
        WolfBall wolf = new WolfBall();
        Hare hare = new Hare();
        Fox fox = new Fox();
        hare.tryEat(kolobok);
        kolobok.go(hare);
        wolf.tryEat(kolobok);
        kolobok.go(wolf);
        fox.tryEat(kolobok);
        kolobok.death(fox);
    }
}
