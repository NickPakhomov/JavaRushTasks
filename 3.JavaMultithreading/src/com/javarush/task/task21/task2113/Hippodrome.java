package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hippodrome {

    private List<Horse> horses;

    public static Hippodrome game;

    public static void main(String[] args) throws Exception {
        List<Horse> horseList = new ArrayList<>();
        horseList.add(new Horse("Коля",3, 0));
        horseList.add(new Horse("Валя",3, 0));
        horseList.add(new Horse("Неля",3, 0));
        game = new Hippodrome(horseList);

        game.run();

        game.printWinner();
    }

    public Hippodrome(List<Horse> list) {
        horses = list;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws Exception {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse horse : horses)
            horse.move();
    }

    public void print() {
        for (Horse horse : horses)
            horse.print();

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Collections.sort(horses);

        return horses.get(0);
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
