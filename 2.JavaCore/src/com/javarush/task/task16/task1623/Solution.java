package com.javarush.task.task16.task1623;

/* 
Рекурсивное создание нитей
*/

public class Solution {
    static int count = 15;
    static volatile int countCreatedThreads;

    public static void main(String[] args) {
        System.out.println(new GenerateThread());
    }

    public static class GenerateThread extends Thread {
        public GenerateThread() {
            super("Name: " + ++countCreatedThreads);
            //if (countCreatedThreads == 0) {
                //countCreatedThreads++;
            //}
            this.start();
        }

        @Override
        public void run() {
            while (countCreatedThreads < Solution.count) {
                Thread thread = new GenerateThread();
                System.out.println(thread.toString());
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public String toString() {
            return countCreatedThreads + " created";
        }
    }
}
